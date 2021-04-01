package es.ua.dlsi.grfia.im3ws.scripts.specificExperiments.specialIssueWorms2021;

import java.io.File;

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
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This class loads all MEI files in CameraPrIMuS 2020. It transforms them into agnostic, contextual agnostic,
 * and semantic, and finally exports them into sets of 10 JSON files. Each JSON file contains a fold.
 * Each set contains different size corpora.
 * (100, 500, .... , 10k, 20k, 30k..., 80k).
 *
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/11/20
 */
public class Worms2021PrIMUS {
    private static final int [] SIZES = {100, 500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000,
            10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000};
    public static final void main(String [] args) throws Exception {

        if (args.length == 0) {
            System.out.println("Using default parameters");
            args = new String[] {System.getProperty("user.home") + "/cmg/experiments/primusKern/CameraPrIMuS_2020/Corpus", "/tmp/worms2021/primus"};
            //args = new String[] {System.getProperty("user.home") + "/cmg/experiments/primusKern/CameraPrIMuS_2020/Corpus/230005168-1_3_1", "/tmp/worms2021/primus"};
        } else if (args.length != 2) {
            throw new Exception("Use: <input path> <output path>");
        }

        System.out.println("Listing files ....");
        List<File> files = (List<File>) FileUtils.listFiles(new File(args[0]), new String [] {"mei"}, true);

        // now they are shuffled
        System.out.println("Reordering # " + files.size() + "....");
        Collections.shuffle(files);

        System.out.println("Assigning to folds ....");
        // then assigned to folds
        List<File>[] folds = new List[Worms2021MuRETDatasets.FOLDS];
        for (int i=0; i<folds.length; i++) {
            folds[i] = new LinkedList<>();
        }
        long idx=0;
        //StringBuilder errors = new StringBuilder();
        for (File file: files) {
            int fold = (int) (idx % Worms2021MuRETDatasets.FOLDS);
            folds[fold].add(file);
            idx++;

            /*try {
                importFile(file);
            } catch (Throwable t) {
                errors.append(file.getAbsolutePath());
                errors.append('\n');
            }*/
        }

        /*if (errors.length() > 0) {
            System.out.println("ERRORS on files ");
            System.out.println(errors.toString());
            return;
        }*/

        for (int i=0; i<folds.length; i++) {
            System.out.println("Fold #" + i + " with #" + folds[i].size() + " files");
        }

        System.out.println("Converting and generating JSONS ....");

        File outputFolder = new File(args[1]);

        for (int s=0; s<SIZES.length; s++) {
            int maximumFoldSize = SIZES[s] / folds.length;
            System.out.println("\n\n\nRunning for size " + SIZES[s] + ", max fold size = " + maximumFoldSize + "..........");
            for (int i = 0; i < folds.length; i++) {
                File outFolderSize = new File(outputFolder, "size_" + SIZES[s]);
                exportFold(i, maximumFoldSize, folds[i], new File(outFolderSize, Worms2021MuRETDatasets.AGNOSTIC_SEMANTIC), new File(outFolderSize, Worms2021MuRETDatasets.CONTEXTUAL_AGNOSTIC_SEMANTIC));
            }
        }
    }

    private static void exportFold(int foldNumber, int maximumFoldSize, List<File> fold, File outputFolderAgnosticSemantic, File outputFolderContextualAgnosticSemantic) throws IM3Exception, IOException {
        outputFolderAgnosticSemantic.mkdirs();
        outputFolderContextualAgnosticSemantic.mkdirs();
        System.out.println("Generating fold #" + foldNumber);
        File outputJSonFileAngnosticSemantic = new File(outputFolderAgnosticSemantic, "fold_" + foldNumber + ".json");
        File outputJSonFileContextualAngnosticSemantic = new File(outputFolderContextualAgnosticSemantic, "fold_" + foldNumber + ".json");
        JSONObject documentJSONAgnosticSemantic = new JSONObject();
        JSONObject documentJSONContextualAgnosticSemantic = new JSONObject();
        JSONArray jsonSystemsAgnosticSemantic = new JSONArray();
        JSONArray jsonSystemsContextualAgnosticSemantic = new JSONArray();
        for (int i=0; i<fold.size() && i<maximumFoldSize; i++) {
            File file = fold.get(i);
            String filename = FilenameUtils.getBaseName(file.getName());
            System.out.println("\tFILE: " + filename);
            try {
                Encoder encoder = importFile(file);
                AgnosticEncoding agnosticEncoding = encoder.getAgnosticEncoding();
                SemanticEncoding semanticEncoding = encoder.getSemanticEncoding();

                generateJSONRegionContent(filename, jsonSystemsAgnosticSemantic, agnosticEncoding, semanticEncoding);
                documentJSONAgnosticSemantic.put("regions", jsonSystemsAgnosticSemantic);

                agnosticEncoding.insertContextInSequence(null);
                generateJSONRegionContent(filename, jsonSystemsContextualAgnosticSemantic, agnosticEncoding, semanticEncoding);
                documentJSONContextualAgnosticSemantic.put("regions", jsonSystemsContextualAgnosticSemantic);
            } catch (Exception e) {
                System.err.println("Skipping file: " + e.getMessage());
            }
        }

        writeJSON(outputJSonFileAngnosticSemantic, documentJSONAgnosticSemantic);
        writeJSON(outputJSonFileContextualAngnosticSemantic, documentJSONContextualAgnosticSemantic);
    }

    private static void writeJSON(File outputJSonFile, JSONObject documentJSON) throws IOException {
        FileWriter file = new FileWriter(outputJSonFile);
        String jsonString = documentJSON.toString();
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
        jsonSystems.put(systemJSON);
    }

    private static Encoder importFile(File file) throws IM3Exception {
        try {
            MEISongImporter importer = new MEISongImporter();
            importer.setAllowErrors(true);

            ScoreSong scoreSong = importer.importSong(file);
            Encoder encoder = new Encoder(true, false, false);
            encoder.encode(scoreSong);
            return encoder;
        } catch (Exception e) {
            System.err.println("Error in file " + file.getAbsolutePath());
            throw e;
        }
    }

}
