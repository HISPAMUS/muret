package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Notation;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Renderer;
import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.Agnostic2SemanticTransducer;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.MensuralAgnostic2SemanticTransducer;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;

import java.io.FileNotFoundException;

public class SemanticRepresentationModel {

    private final ProjectModel projectModel;

    public SemanticRepresentationModel(ProjectModel projectModel) {
        this.projectModel = projectModel;
    }

    public Notation getNotation(Project project, String partName, Region region, boolean mensustriche, Renderer renderer) throws IM3Exception {
        ProjectScoreSong projectScoreSong = projectModel.getProjectScoreSong(project);
        ProjectScoreSongPart projectScoreSongPart = projectScoreSong.getScorePart(partName);
        if (projectScoreSongPart == null) {
            throw new IM3Exception("Cannot find a part with name '" + partName + "'");
        }

        ProjectScoreSongSystem system = projectScoreSongPart.getScoreSongSystem(region.getId());
        if (system == null) {
            throw new IM3Exception("Cannot find a system with id '" + region + "'");
        }

        Segment segment = new Segment(system.getFrom(), system.getTo());
        return projectModel.render(projectScoreSongPart.getScorePart(), segment, project.getNotationType(), project.getManuscriptType(), mensustriche, renderer);
    }

    /**
     *
     * @param staff
     * @return MEI
     */
    public Notation computeSemanticFromAgnostic(Project project, String partName, Region staff, boolean mensustriche, Renderer renderer) throws FileNotFoundException, IM3Exception {
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

        return getNotation(project, partName, staff, mensustriche, renderer);
    }

    /**
     * If not saved, create and save it in project folder
     * @param project
     * @return
     */
    private ProjectScoreSong getScoreSong(Project project) throws IM3Exception {
        return projectModel.getProjectScoreSong(project);
    }
}
