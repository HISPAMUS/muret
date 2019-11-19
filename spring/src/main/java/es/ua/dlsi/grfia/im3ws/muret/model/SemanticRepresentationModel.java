package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Notation;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Renderer;
import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.entity.Symbol;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.HorizontalSeparator;
import es.ua.dlsi.im3.omr.encoding.semantic.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SemanticRepresentationModel {

    private final ProjectModel projectModel;
    private final RegionRepository regionRepository;
    private NotationModel notationModel;

    public SemanticRepresentationModel(ProjectModel projectModel, RegionRepository regionRepository) {
        this.projectModel = projectModel;
        this.regionRepository = regionRepository;
        this.notationModel = new NotationModel();
    }


    public static AgnosticEncoding region2Agnostic(Region staff, boolean addSeparator) throws IM3Exception {
        AgnosticEncoding agnosticEncoding = new AgnosticEncoding();

        ArrayList<Symbol> symbols = new ArrayList<>(staff.getSymbols());
        symbols.sort(Symbol.getHorizontalPositionComparator());
        for (int i=0; i<symbols.size(); i++) {
            Symbol symbol = symbols.get(i);
            symbol.getAgnosticSymbol().setId(symbol.getId()); // associate the symbol ID to the agnostic symbol
            agnosticEncoding.add(symbol.getAgnosticSymbol());
            if (addSeparator && i < symbols.size() - 1) {
                agnosticEncoding.add(new HorizontalSeparator(AgnosticVersion.v2));
            }
        }

        if (agnosticEncoding.getSymbols().isEmpty()) {
            throw new IM3Exception("There are not agnostic symbols to convert");
        }
        return agnosticEncoding;
    }


    /**
     * @param staff
     * @return MEI
     */
    public Notation computeAndSaveSemanticFromAgnostic(Project project, String partName, Region staff, boolean mensurstrich, Renderer renderer) throws FileNotFoundException, IM3Exception, IM3WSException {
        AgnosticEncoding agnosticEncoding = region2Agnostic(staff, false);
        NotationType notationType = project.getNotationType();
        SemanticTransduction semanticTransduction = new TranslationModel().computeSemanticFromAgnostic(agnosticEncoding, notationType);

        Notation result = null;
        if (semanticTransduction.getErrorMessage() != null) {
            result = new Notation(semanticTransduction.getErrorMessage());
        } else {
            //projectModel.addSemanticEncoding(project, partName, staff.getId(), staff.getBoundingBox(), semantic.getSemanticEncoding());
            KernSemanticExporter kernSemanticExporter = new KernSemanticExporter();
            try {
                String kernExport = kernSemanticExporter.export(semanticTransduction.getSemanticEncoding());
                sendSemanticEncoding(project, partName, staff, mensurstrich, renderer, kernExport);
                result = notationModel.getNotation(project, partName, staff, mensurstrich, renderer);
            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot generate the score", e);
                result = new Notation("Cannot generate the score:" + e.getMessage());
            }
        }
        return result;
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
        return notationModel.getNotation(project, partName, region, mensustriche, renderer);
    }
}
