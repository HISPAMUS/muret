package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Notation;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Renderer;
import es.ua.dlsi.grfia.im3ws.muret.entity.Document;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.entity.Symbol;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticExporter;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticToken;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.HorizontalSeparator;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.VerticalSeparator;
import es.ua.dlsi.im3.omr.encoding.semantic.*;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.Collection;

import static es.ua.dlsi.grfia.im3ws.muret.controller.ClassifierModelsController.AGNOSTIC2SEMANTIC_TRANSDUCER;

public class SemanticRepresentationModel {

    private final DocumentModel documentModel;
    private final RegionRepository regionRepository;
    private NotationModel notationModel;
    private final ClassifierClient classifierClient;

    public SemanticRepresentationModel(MURETConfiguration muretConfiguration, DocumentModel documentModel, RegionRepository regionRepository) {
        this.documentModel = documentModel;
        this.regionRepository = regionRepository;
        this.notationModel = new NotationModel();
        this.classifierClient = new ClassifierClient(muretConfiguration.getBaseIIIFImagesURI(), muretConfiguration.getPythonclassifiers());
    }

    public static String region2AgnosticString(Region region, boolean includeAgnosticContext, AgnosticToken lastAgnosticClef) throws IM3Exception {
        AgnosticEncoding agnostic = SemanticRepresentationModel.region2Agnostic(region, true);
        if (includeAgnosticContext) {
            lastAgnosticClef = agnostic.insertContextInSequence(lastAgnosticClef);
        }

        AgnosticExporter agnosticExporter = new AgnosticExporter(AgnosticVersion.v2);
        String agnosticSequence = agnosticExporter.export(agnostic);
        return agnosticSequence;
    }


    public static AgnosticEncoding region2Agnostic(Region staff, boolean addSeparator) throws IM3Exception {
        AgnosticEncoding agnosticEncoding = new AgnosticEncoding();

        /*ArrayList<Symbol> symbols = new ArrayList<>(staff.getSymbols());
        symbols.sort(Symbol.getHorizontalPositionComparator());*/

        Collection<Symbol> symbols = staff.getSortedSymbols();

        int i=0;
        Symbol lastSymbol = null;
        for (Symbol symbol: symbols) {
            symbol.getAgnosticSymbol().setId(symbol.getId()); // associate the symbol ID to the agnostic symbol

            if (lastSymbol != null && lastSymbol.isVerticallyStacked(symbol)) {
                agnosticEncoding.add(new VerticalSeparator(AgnosticVersion.v2));
            }

            agnosticEncoding.add(symbol.getAgnosticSymbol());
            if (addSeparator && i < symbols.size() - 1) {
                agnosticEncoding.add(new HorizontalSeparator(AgnosticVersion.v2));
            }
            i++;
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
    public Notation computeAndSaveSemanticFromAgnostic(String classifierModelID, Document document, String partName, Region staff, boolean mensurstrich, Renderer renderer) throws FileNotFoundException, IM3Exception, IM3WSException {
        AgnosticEncoding agnosticEncoding = region2Agnostic(staff, false);
        NotationType notationType = document.getNotationType();

        String kernExport = null;
        if (classifierModelID.equals(AGNOSTIC2SEMANTIC_TRANSDUCER)) {
            SemanticTransduction semanticTransduction = new TranslationModel().computeSemanticFromAgnostic(agnosticEncoding, notationType);
            KernSemanticExporter kernSemanticExporter = new KernSemanticExporter();
            kernExport = kernSemanticExporter.export(semanticTransduction.getSemanticEncoding());
        } else {
            String agnosticString = region2AgnosticString(staff, false, null);
            kernExport = classifierClient.translateAgnostic2Semantic(classifierModelID, agnosticString);

        }
        Notation result = null;
        //documentModel.addSemanticEncoding(document, partName, staff.getId(), staff.getBoundingBox(), semantic.getSemanticEncoding());
        sendSemanticEncoding(document, partName, staff, mensurstrich, renderer, kernExport);
        result = notationModel.getNotation(document, partName, staff, mensurstrich, renderer);
        return result;
    }

    /**
     * If not saved, create and save it in document folder
     * @param document
     * @return
     */
    private DocumentScoreSong getScoreSong(Document document) throws IM3WSException {
        return documentModel.getDocumentScoreSong(document);
    }


    public Notation sendSemanticEncoding(Document document, String partName, Region region, boolean mensustriche, Renderer renderer, String semanticEncoding) throws IM3WSException, IM3Exception {
        //documentModel.addSemanticEncoding(document, partName, region.getId(), region.getBoundingBox(), semanticEncoding);
        //TODO Ahora sólo lo guardo en la región
        region.setSemanticEncoding(semanticEncoding);
        regionRepository.save(region);
        return notationModel.getNotation(document, partName, region, mensustriche, renderer);
    }
}
