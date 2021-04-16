package es.ua.dlsi.grfia.im3ws.muret.model.trainingsets;

import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.*;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.io.ExportException;
import es.ua.dlsi.im3.core.utils.FileCompressors;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticExporter;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticToken;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import es.ua.dlsi.im3.omr.encoding.semantic.KernSemanticExporter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It exports a set of json files, one for each document
 */
public class AgnosticSemanticTrainingSetExporter extends AbstractTrainingSetExporter {
    private final DocumentModel documentModel;
    protected boolean includeAgnosticContext = false;

    public AgnosticSemanticTrainingSetExporter(int id, DocumentModel documentModel, boolean includeAgnosticContext) {
        super(id,includeAgnosticContext?"Agnostic with context-semantic":"Agnostic-semantic",
                "Exports pairs agnostic-semantic in JSON files (one for each document) "
                + (includeAgnosticContext ? " including context in agnostic": ""), false);
        this.documentModel = documentModel;
        this.includeAgnosticContext = includeAgnosticContext;
    }

    public AgnosticSemanticTrainingSetExporter(int id, DocumentModel documentModel) {
        this(id, documentModel, false);
    }

    @Override
    public Path generate(Path muretFolder, Collection<Document> documentCollection) throws ExportException {
        try {
            Path directory = Files.createTempDirectory("json_agnostic_semantic_pairs");

            for (Document document : documentCollection) {
                File jsonFile = new File(directory.toFile(), document.getPath() + ".json");
                //DocumentScoreSong documentScoreSong = documentModel.getDocumentScoreSong(document);
                //export(documentScoreSong, jsonFile);
                export(document, jsonFile);
            }

            File resultTGZ = File.createTempFile("json_agnostic_semantic_pairs", ".tar.gz");
            FileCompressors fileCompressors = new FileCompressors();
            fileCompressors.tgzFolder(resultTGZ.toPath(), directory);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Generated tgz {0}", resultTGZ);
            return resultTGZ.toPath();

        } catch (Exception e) {
            throw new ExportException(e);
        }
    }

    /**
     * @param
     * @param outputJSonFile
     * @throws IOException
     * @throws IM3Exception
     */
    /*private void export(DocumentScoreSong documentScoreSong, File outputJSonFile) throws IOException, IM3Exception {
        JSONObject documentJSON = new JSONObject();
        JSONArray jsonSystems = new JSONArray();

        for (DocumentScoreSongPart documentScoreSongPart: documentScoreSong.getScoreParts()) {
            //TODO esto va sólo para un pentagrama
            if (documentScoreSongPart.getScorePart().getStaves().size() > 1) {
                throw new IM3Exception("Cannot work yet with multiple staff parts");
            }
            if (!documentScoreSongPart.getScorePart().getStaves().isEmpty()) {
                JSONObject systemJSON = new JSONObject();
                Staff scoreStaff = documentScoreSongPart.getScorePart().getStaves().get(0);
                for (DocumentScoreSongSystem documentScoreSongSystem : documentScoreSongPart.getSystems()) {
                    Encoder encoder = new Encoder(AgnosticVersion.v2, false);
                    encoder.encode(scoreStaff, new Segment(documentScoreSongSystem.getFrom(), documentScoreSongSystem.getTo()));
                    AgnosticExporter agnosticExporter = new AgnosticExporter(AgnosticVersion.v2);
                    SemanticExporter semanticExporter = new SemanticExporter();

                    systemJSON.put("region_id", documentScoreSongSystem.getSystemBeginning().getFacsimileElementID());
                    systemJSON.put("agnostic", agnosticExporter.export(encoder.getAgnosticEncoding()));
                    systemJSON.put("semantic", semanticExporter.export(encoder.getSemanticEncoding()));
                    jsonSystems.add(systemJSON);
                }
            }
        }
        documentJSON.put("systems", jsonSystems);


        FileWriter file = new FileWriter(outputJSonFile);
        String jsonString = documentJSON.toJSONString();
        file.write(jsonString);
        file.close();
    }*/

    /**
     * @param document
     * @param outputJSonFile
     * @throws IOException
     * @throws IM3Exception
     */
    public void export(Document document, File outputJSonFile) throws IOException, IM3Exception {
        JSONObject documentJSON = new JSONObject();
        JSONArray jsonSystems = new JSONArray();

        for (Image image: document.computeAllImagesSorted()) {
            for (Page page: image.getSortedPages()) {
                exportPage(jsonSystems, page);
            }
        }
        documentJSON.put("regions", jsonSystems);

        FileWriter file = new FileWriter(outputJSonFile);
        String jsonString = documentJSON.toString();
        file.write(jsonString);
        file.close();
    }

    //TODO A otro sitio (se usa también en semantic representation model)

    public void exportPage(JSONArray jsonSystems, Page page) throws IM3Exception {


        AgnosticToken lastAgnosticClef = null; // used for the agnostic format including the context
        for (Region region: page.getSortedStaves()) {
            if (region.getSymbols() != null && !region.getSymbols().isEmpty() && region.getSemanticEncoding() != null) {

                /*if (page.getImage().getFilename().equals("[C14-15] 10.jpg")) {
                    System.out.println("Region Y: " + region.getBoundingBox().getFromY());
                }*/

                JSONObject systemJSON = new JSONObject();

                ArrayList<Symbol> symbolArrayList = new ArrayList<>(region.getSymbols());
                symbolArrayList.sort(Symbol.getHorizontalPositionComparator());

                String agnosticSequence = SemanticRepresentationModel.region2AgnosticString(region, includeAgnosticContext, lastAgnosticClef);
                systemJSON.put("image_id", region.getPage().getImage().getId());
                systemJSON.put("image_name", region.getPage().getImage().getFilename());
                systemJSON.put("region_id", region.getId());
                JSONTagging.putBoundingBox(systemJSON, region.getBoundingBox());
                systemJSON.put("agnostic", agnosticSequence);
                systemJSON.put("semantic", removeIDS(region.getSemanticEncoding()));
                jsonSystems.put(systemJSON);

            }
        }
    }

    private String removeIDS(String semanticWithIDS) {
        StringBuilder stringBuilder = new StringBuilder();
        String [] tokens = semanticWithIDS.split(Character.toString(KernSemanticExporter.TOKEN_SEPARATOR));
        for (String tokenWithID: tokens) {
            String [] elements = tokenWithID.split(KernSemanticExporter.IDS_SEPARATOR);
            stringBuilder.append(elements[0]);
            stringBuilder.append(KernSemanticExporter.TOKEN_SEPARATOR);
        }
        return stringBuilder.toString();
    }
}
