package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Notation;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.NotationResponseType;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Renderer;
import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.Agnostic2SemanticTransducer;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.MensuralAgnostic2SemanticTransducer;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.io.mei.MEISongExporter;
import es.ua.dlsi.im3.core.score.staves.Pentagram;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import es.ua.dlsi.im3.omr.encoding.semantic.KernSemanticExporter;
import es.ua.dlsi.im3.omr.encoding.semantic.MensSemanticImporter;
import es.ua.dlsi.im3.omr.encoding.semantic.Semantic2IMCore;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticEncoding;

import java.io.FileNotFoundException;
import java.util.List;

public class SemanticRepresentationModel {

    private final ProjectModel projectModel;
    private final RegionRepository regionRepository;

    public SemanticRepresentationModel(ProjectModel projectModel, RegionRepository regionRepository) {
        this.projectModel = projectModel;
        this.regionRepository = regionRepository;
    }

    public Notation getNotation(Project project, String partName, Region region, boolean mensustriche, Renderer renderer) throws IM3WSException {

        if (region.getSemanticEncoding() == null) {
            return new Notation("Region has not a semantic encoding yet");
        }

        //TODO Ahora sólo lo guardo en la región
        MensSemanticImporter mensSemanticImporter = new MensSemanticImporter(); //TODO Sólo va para mensural
        try {
            SemanticEncoding semantic = mensSemanticImporter.importString(project.getNotationType(), region.getSemanticEncoding());
            Semantic2IMCore semantic2IMCore = new Semantic2IMCore();
            //TODO compases y tonalidad anteriores
            List<ITimedElementInStaff> items = semantic2IMCore.convert(project.getNotationType(), null, null, semantic);
            ScoreSong song = new ScoreSong();
            ScorePart part = song.addPart();
            ScoreLayer layer = part.addScoreLayer();
            Staff staff = new Pentagram(song, "1", 1);
            staff.setNotationType(project.getNotationType());
            song.addStaff(staff);
            part.addStaff(staff);
            staff.addLayer(layer);
            for (ITimedElementInStaff timedElementInStaff: items) {
                if (timedElementInStaff instanceof Atom) {
                    layer.add((Atom) timedElementInStaff);
                } else {
                    staff.addElementWithoutLayer((IStaffElementWithoutLayer) timedElementInStaff);
                }
            }
            MEISongExporter exporter = new MEISongExporter();
            String mei = exporter.exportSong(song);
            return new Notation(NotationResponseType.mei, mei, region.getSemanticEncoding());
        } catch (IM3Exception e) {
            return new Notation("Cannot import semantic encoding: " + e.getMessage());
        }

        /*
        ProjectScoreSong projectScoreSong = projectModel.getProjectScoreSong(project);
        ProjectScoreSongPart projectScoreSongPart = projectScoreSong.getScorePart(partName);
        if (projectScoreSongPart == null) {
            projectScoreSongPart = projectScoreSong.addPart(partName);
        }

        ProjectScoreSongSystem system = projectScoreSongPart.getScoreSongSystem(region.getId());
        if (system == null) {
            system = projectScoreSongPart.addProjectScoreSystem(region.getId(), region.getBoundingBox());
        }

        Segment segment = new Segment(system.getFrom(), system.getTo());
        return projectModel.render(projectScoreSongPart.getScorePart(), segment, project.getNotationType(), project.getManuscriptType(), mensustriche, renderer);*/

    }

    public static AgnosticEncoding region2Agnostic(Region staff) throws IM3Exception {
        AgnosticEncoding agnosticEncoding = new AgnosticEncoding();
        staff.getSymbols().stream().sorted((o1, o2) -> {
            int diff = o1.getBoundingBox().getFromX() - o2.getBoundingBox().getFromX();
            if (diff == 0) {
                diff = o1.getBoundingBox().getFromY() - o2.getBoundingBox().getFromY();
                if (diff == 0) {
                    diff = o1.hashCode() - o2.hashCode();
                }
            }
            return diff;
        }).forEach(symbol -> agnosticEncoding.add(symbol.getAgnosticSymbol()));

        if (agnosticEncoding.getSymbols().isEmpty()) {
            throw new IM3Exception("There are not agnostic symbols to convert");
        }
        return agnosticEncoding;
    }

    /**
     *
     * @param staff
     * @return MEI
     */
    public Notation computeSemanticFromAgnostic(Project project, String partName, Region staff, boolean mensustriche, Renderer renderer) throws FileNotFoundException, IM3Exception, IM3WSException {
        AgnosticEncoding agnosticEncoding = region2Agnostic(staff);

        Agnostic2SemanticTransducer agnostic2SemanticTransducer;
        if (project.getNotationType() == NotationType.eMensural) {
            agnostic2SemanticTransducer = new MensuralAgnostic2SemanticTransducer();
        } else {
            throw new IM3Exception("No transducer found for notation " + project.getNotationType());
        }

        SemanticTransduction semantic = agnostic2SemanticTransducer.transduce(agnosticEncoding);

        //TODO De momnento estoy creando una song con una sóla parte, pentagrama ...
        // La añadimos a la song
        // Si había algo habrá que borrarlo

        // TODO esto hay que cambiarlo para que saque otra cosa y que tenga la song actual
        // TODO Tampoco debería poder haber nada después del pentagrama actual
        /*ScoreSong transducedSong = agnostic2SemanticTransducer.semantic2IMCore(semantic.getSemanticEncoding());
        ProjectScoreSongPart part = projectModel.getProjectScoreSong(project).getScorePart(partName);
        if (part == null) {
            throw new IM3Exception("Cannot find a part with name '" + partName + "'");
        }
        for (ITimedElementInStaff timedElementInStaff: transducedSong.getStaves().get(0).getCoreSymbolsOrdered()) {
            projectModel.addToPart(part, timedElementInStaff);
        }*/

        if (semantic.getSemanticEncoding().getSymbols().isEmpty()) {
            throw new IM3WSException("Cannot translate from agnostic");
        }
        //projectModel.addSemanticEncoding(project, partName, staff.getId(), staff.getBoundingBox(), semantic.getSemanticEncoding());
        KernSemanticExporter kernSemanticExporter = new KernSemanticExporter();
        sendSemanticEncoding(project, partName, staff, mensustriche, renderer, kernSemanticExporter.export(semantic.getSemanticEncoding()));
        return getNotation(project, partName, staff, mensustriche, renderer);
    }

    /**
     * If not saved, create and save it in project folder
     * @param project
     * @return
     */
    private ProjectScoreSong getScoreSong(Project project) throws IM3WSException {
        return projectModel.getProjectScoreSong(project);
    }

    public Notation sendSemanticEncoding(Project project, String partName, Region region, boolean mensustriche, Renderer renderer, String semanticEncoding) throws IM3WSException {
        //projectModel.addSemanticEncoding(project, partName, region.getId(), region.getBoundingBox(), semanticEncoding);
        //TODO Ahora sólo lo guardo en la región
        region.setSemanticEncoding(semanticEncoding);
        regionRepository.save(region);
        return getNotation(project, partName, region, mensustriche, renderer);
    }
}
