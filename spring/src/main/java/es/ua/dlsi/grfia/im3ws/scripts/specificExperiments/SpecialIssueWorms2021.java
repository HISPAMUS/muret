package es.ua.dlsi.grfia.im3ws.scripts.specificExperiments;

import es.ua.dlsi.grfia.im3ws.muret.entity.Collection;
import es.ua.dlsi.grfia.im3ws.muret.entity.Document;
import es.ua.dlsi.grfia.im3ws.muret.model.DocumentModel;
import es.ua.dlsi.grfia.im3ws.muret.model.trainingsets.AgnosticSemanticTrainingSetExporter;
import es.ua.dlsi.grfia.im3ws.muret.model.trainingsets.AgnosticWithContextSemanticTrainingSetExporter;
import es.ua.dlsi.grfia.im3ws.muret.repository.CollectionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.DocumentRepository;
import es.ua.dlsi.grfia.im3ws.scripts.AuthenticateForScripts;
import es.ua.dlsi.im3.core.IM3Exception;
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
import java.io.IOException;
import java.util.Optional;

/**
 * Training sets are generated for the corpora FMT and Zaragoza. The training set contains JSON files with agnostic and semantic encoding.
 * JSON 10-folds are generated assigning randomly each image to a fold.
 * It creates a folder named spIssueWORMS2021 with the data
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 20/11/20
 */
@ComponentScan("es.ua.dlsi.grfia.im3ws")
@EnableJpaRepositories("es.ua.dlsi.grfia.im3ws.muret.repository")
@EntityScan("es.ua.dlsi.grfia.im3ws.muret.entity")
@Transactional(readOnly = true)
public class SpecialIssueWorms2021 implements CommandLineRunner {
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
        for (Collection subcollection: collection.get().getSubcollections()) {
            doExportCollection(subcollection, outputFolder);
        }
    }

    protected void doExportCollection(AgnosticSemanticTrainingSetExporter exporter, String prefix, File outputFolder, Collection collection) throws IOException, IM3Exception {
        outputFolder.mkdirs();
        for (Document document: collection.getDocuments()) {
            File outputFile = new File(outputFolder, prefix + "_" + document.getPath()  + ".json");
            System.out.println("Generating " + outputFile + "...");
            exporter.export(document, outputFile);
        }
    }

    private void doExportCollection(Collection collection, File outputFolder) throws IOException, IM3Exception {
        doExportCollection(new AgnosticSemanticTrainingSetExporter(0, documentModel), "agnostic_semantic", new File(outputFolder, "agnostic_semantic"), collection);
        // important this order (first without context, then with context) because we are working with @Transactional, and the notes are modified with the context
        doExportCollection(new AgnosticWithContextSemanticTrainingSetExporter(0, documentModel), "contextual-agnostic_semantic", new File(outputFolder, "contextual-agnostic_semantic"), collection);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length != 1) {
            throw new Exception("Missing output folder path");
        }

        new AuthenticateForScripts(authenticationManager).consoleAuthenticate();

        doExport("Zaragoza", new File(args[0], "zaragoza"));
        doExport("Música tradicional", new File(args[0], "FMT"));
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpecialIssueWorms2021.class, args);
        SpringApplication.exit(ctx);
    }

}
