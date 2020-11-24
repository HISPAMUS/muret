package es.ua.dlsi.grfia.im3ws.scripts.specificExperiments.specialIssueWorms2021;

import java.io.File;

import es.ua.dlsi.grfia.im3ws.muret.model.trainingsets.JSONTagging;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.ScoreSong;
import es.ua.dlsi.im3.core.score.io.mei.MEISongImporter;
import es.ua.dlsi.im3.omr.encoding.Encoder;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticExporter;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticEncoding;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This class loads all MEI files in CameraPrIMuS 2020. It transforms them into agnostic, contextual agnostic,
 * and semantic, and finally exports them into 10 JSON files
 *
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/11/20
 */
public class Worms2021PrIMUS {
    public static final void main(String [] args) throws Exception {
        if (args.length != 2) {
            throw new Exception("Use: <input path> <output path>");
        }

        System.out.println("Listing files ....");
        List<File> files = (List<File>) FileUtils.listFiles(new File(args[0]), new String [] {"mei"}, true);

        // now they are shuffled
        System.out.println("Reordering ....");
        Collections.shuffle(files);

        System.out.println("Assigning to folds ....");
        // then assigned to folds
        List<File>[] folds = new List[Worms2021MuRETDatasets.FOLDS];
        for (int i=0; i<folds.length; i++) {
            folds[i] = new LinkedList<>();
        }
        long idx=0;
        for (File file: files) {
            int fold = (int) (idx % Worms2021MuRETDatasets.FOLDS);
            folds[fold].add(file);
            idx++;
        }

        for (int i=0; i<folds.length; i++) {
            System.out.println("Fold #" + i + " with #" + folds[i].size() + " files");
        }

        System.out.println("Converting and generating JSONS ....");

        File outputFolder = new File(args[1]);

        for (int i=0; i<folds.length; i++) {
            exportFold(i, folds[i], new File(outputFolder, Worms2021MuRETDatasets.AGNOSTIC_SEMANTIC), new File(outputFolder, Worms2021MuRETDatasets.CONTEXTUAL_AGNOSTIC_SEMANTIC));
        }

    }

    private static void exportFold(int foldNumber, List<File> fold, File outputFolderAgnosticSemantic, File outputFolderContextualAgnosticSemantic) throws IM3Exception, IOException {
        outputFolderAgnosticSemantic.mkdirs();
        outputFolderContextualAgnosticSemantic.mkdirs();
        System.out.println("Generating fold #" + foldNumber);
        File outputJSonFileAngnosticSemantic = new File(outputFolderAgnosticSemantic, "fold_" + foldNumber + ".json");
        File outputJSonFileContextualAngnosticSemantic = new File(outputFolderContextualAgnosticSemantic, "fold_" + foldNumber + ".json");
        JSONObject documentJSONAgnosticSemantic = new JSONObject();
        JSONObject documentJSONContextualAgnosticSemantic = new JSONObject();
        JSONArray jsonSystemsAgnosticSemantic = new JSONArray();
        JSONArray jsonSystemsContextualAgnosticSemantic = new JSONArray();
        for (File file: fold) {
            String filename = FilenameUtils.getBaseName(file.getName());
            System.out.println("\tFILE: " + filename);
            Encoder encoder = importFile(file);
            AgnosticEncoding agnosticEncoding = encoder.getAgnosticEncoding();
            SemanticEncoding semanticEncoding = encoder.getSemanticEncoding();

            generateJSONRegionContent(filename, jsonSystemsAgnosticSemantic, agnosticEncoding, semanticEncoding);
            documentJSONAgnosticSemantic.put("regions", jsonSystemsAgnosticSemantic);

            agnosticEncoding.insertContextInSequence(null);
            generateJSONRegionContent(filename, jsonSystemsContextualAgnosticSemantic, agnosticEncoding, semanticEncoding);
            documentJSONContextualAgnosticSemantic.put("regions", jsonSystemsContextualAgnosticSemantic);
        }

        writeJSON(outputJSonFileAngnosticSemantic, documentJSONAgnosticSemantic);
        writeJSON(outputJSonFileContextualAngnosticSemantic, documentJSONContextualAgnosticSemantic);
    }

    private static void writeJSON(File outputJSonFile, JSONObject documentJSON) throws IOException {
        FileWriter file = new FileWriter(outputJSonFile);
        String jsonString = documentJSON.toJSONString();
        file.write(jsonString);
        file.close();
    }

    private static void generateJSONRegionContent(String filename, JSONArray jsonSystems, AgnosticEncoding agnosticEncoding, SemanticEncoding semanticEncoding) throws IM3Exception {
        JSONObject systemJSON = new JSONObject();

        AgnosticExporter agnosticExporter = new AgnosticExporter(AgnosticVersion.v2);
        String agnosticSequence = agnosticExporter.export(agnosticEncoding);

        systemJSON.put("image_name", filename);
        systemJSON.put("agnostic", agnosticSequence);
        systemJSON.put("semantic", semanticEncoding.generateKernSemanticString(NotationType.eModern));
        jsonSystems.add(systemJSON);
    }

    private static Encoder importFile(File file) throws IM3Exception {
        try {
            MEISongImporter importer = new MEISongImporter();

            ScoreSong scoreSong = importer.importSong(file);
            Encoder encoder = new Encoder(true);
            encoder.encode(scoreSong);
            return encoder;
        } catch (Exception e) {
            System.err.println("Error in file " + file.getAbsolutePath());
            throw e;
        }
    }

}
