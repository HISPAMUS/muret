package es.ua.dlsi.grfia.im3ws.scripts.specificExperiments.specialIssueWorms2021;

import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.DocumentModel;
import es.ua.dlsi.grfia.im3ws.muret.model.trainingsets.AgnosticSemanticTrainingSetExporter;
import es.ua.dlsi.grfia.im3ws.muret.model.trainingsets.AgnosticWithContextSemanticTrainingSetExporter;
import es.ua.dlsi.grfia.im3ws.muret.repository.CollectionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.DocumentRepository;
import es.ua.dlsi.grfia.im3ws.scripts.AuthenticateForScripts;
import es.ua.dlsi.im3.core.IM3Exception;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;

// import javax.transaction.Transactional; it does not support readOnly
import org.springframework.transaction.annotation.Transactional;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Training sets are generated for the corpora FMT and Zaragoza. The training set contains JSON files with agnostic and semantic encoding.
 * 10-folds are generated assigning randomly each image to a fold: all the documents are shuffled randomly, then they are assigned to each fold
 * using a Round Robin scheme.
 * It creates a folder named spIssueWORMS2021 with the data
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 20/11/20
 */
@ComponentScan("es.ua.dlsi.grfia.im3ws")
@EnableJpaRepositories("es.ua.dlsi.grfia.im3ws.muret.repository")
@EntityScan("es.ua.dlsi.grfia.im3ws.muret.entity")
@Transactional(readOnly = true)
public class Worms2021MuRETDatasets implements CommandLineRunner {
    public static final int FOLDS = 10;
    public static final String AGNOSTIC_SEMANTIC = "agnostic_semantic";
    public static final String CONTEXTUAL_AGNOSTIC_SEMANTIC = "contextual-agnostic_semantic";

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    DocumentModel documentModel;

    private void doExport(String collectionName, File outputFolder) throws Exception {
        Optional<Collection> collection = collectionRepository.findByName(collectionName);

        if (!collection.isPresent()) {
            throw new Exception("Cannot find collection '" + collectionName + "'");
        }

        doExportCollection(collection.get(), outputFolder);
        if (collection.get().getSubcollections() != null && !collection.get().getSubcollections().isEmpty()) {
            throw new UnsupportedOperationException("Subcollections in " + collectionName);
        }
        /*for (Collection subcollection: collection.get().getSubcollections()) {
            doExportCollection(subcollection, outputFolder); // We should create folds here as well
        }*/
    }

    protected void doExportCollection(AgnosticSemanticTrainingSetExporter exporter, File outputFolder, List<Page>[] folds) throws IOException, IM3Exception {
        outputFolder.mkdirs();

        for (int fold = 0; fold < folds.length; fold ++) {
            System.out.println("Generating " + outputFolder.getName() + ", fold #" + fold);
            File outputJSonFile = new File(outputFolder, "fold_" + fold + ".json");
            JSONObject documentJSON = new JSONObject();
            JSONArray jsonSystems = new JSONArray();

            for (Page page: folds[fold]) {
                exporter.exportPage(jsonSystems, page);
            }
            documentJSON.put("regions", jsonSystems);

            System.out.println("\t#" + jsonSystems.size() + " regions");
            FileWriter file = new FileWriter(outputJSonFile);
            String jsonString = documentJSON.toJSONString();
            file.write(jsonString);
            file.close();
        }

        /*for (Document document: collection.getDocuments()) {
            File outputFile = new File(outputFolder, prefix + "_" + document.getPath()  + ".json");
            System.out.println("Generating " + outputFile + "...");
            exporter.export(document, outputFile);
        }*/
    }

    private List<Page>[] createFolds(Collection collection) {
        ArrayList<Page> allPages = new ArrayList<>();
        List<Page> [] folds = new List[FOLDS];
        for (int i=0; i<folds.length; i++) {
            folds[i] = new ArrayList<>();
        }
        for (Document document: collection.getDocuments()) {
            //if (!document.getName().equals("mision02")) { // skip it because it's not complete
            if (!document.getName().startsWith("M")) { // skip it because it's not complete
                for (Image image : document.getImages()) {
                    for (Page page : image.getSortedPages()) {
                        List<Region> staves = page.getSortedStaves();
                        if (!staves.isEmpty()) {
                            boolean empty = true;
                            for (Region region: staves) {
                                if (region.getSemanticEncoding() != null && !region.getSymbols().isEmpty()) {
                                    empty = false;
                                    break;
                                }
                            }
                            if (empty) {
                                System.out.println("Discarding " + document.getName() + " " + image.getFilename() + ", it's empty (semantic or no regions)");
                            } else {
                                allPages.add(page);
                            }
                        }
                    }
                }
            }
        }

        Collections.shuffle(allPages);
        for (int i=0; i<allPages.size(); i++) {
            folds[i % FOLDS].add(allPages.get(i));
        }

        System.out.println("\nCollection: " + collection.getName());
        for (int i=0; i<folds.length; i++) {
            System.out.println("\nFold #" + i + " of size " + folds[i].size());
            int nstavesTotal = 0;
            for (Page page: folds[i]) {
                int nstaves = page.getSortedStaves().size();
                System.out.println("\t\tPage in " + page.getImage().getFilename() + " " + page.getImage().getDocument().getName() + ": #" + nstaves + " staves");
                nstavesTotal += nstaves;
            }
            System.out.println("\tTotal staves: #" + nstavesTotal);
        }
        System.out.println("-----------");

        return folds;

    }

    private void doExportCollection(Collection collection, File outputFolder) throws IOException, IM3Exception {
        List<Page>[] folds = createFolds(collection);

        doExportCollection(new AgnosticSemanticTrainingSetExporter(0, documentModel), new File(outputFolder, AGNOSTIC_SEMANTIC), folds);
        // important this order (first without context, then with context) because we are working with @Transactional, and the notes are modified with the context
        doExportCollection(new AgnosticWithContextSemanticTrainingSetExporter(0, documentModel), new File(outputFolder, CONTEXTUAL_AGNOSTIC_SEMANTIC), folds);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length != 1) {
            throw new Exception("Missing output folder path");
        }

        new AuthenticateForScripts(authenticationManager).consoleAuthenticate();

        //doExport("Zaragoza", new File(args[0], "zaragoza"));
        doExport("Música tradicional", new File(args[0], "FMT"));
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Worms2021MuRETDatasets.class, args);
        SpringApplication.exit(ctx);
    }

}
