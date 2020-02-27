package es.ua.dlsi.grfia.im3ws.scripts;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.entity.Collection;
import es.ua.dlsi.grfia.im3ws.muret.repository.CollectionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.SymbolRepository;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.mensural.ligature.LigaturaCumOppositaPropietate;
import es.ua.dlsi.im3.core.score.mensural.meters.Perfection;
import es.ua.dlsi.im3.core.utils.FileUtils;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolType;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolTypeFactory;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.NoteFigures;
import es.ua.dlsi.im3.omr.encoding.enums.ClefNote;
import es.ua.dlsi.im3.omr.encoding.enums.MeterSigns;
import es.ua.dlsi.im3.omr.encoding.semantic.MensSemanticImporter;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticEncoding;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbolType;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;

import javax.transaction.Transactional;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Used to import the Fondo de Música Tradicional MEI files that have been obtained from Sibelius and Finale and have
 * been processed by adding system breaks as they appear in the manuscripts
 * @author drizo
 */
@ComponentScan("es.ua.dlsi.grfia.im3ws")
@EnableJpaRepositories("es.ua.dlsi.grfia.im3ws.muret.repository")
@EntityScan("es.ua.dlsi.grfia.im3ws.muret.entity")
@Transactional
public class ImportFMT implements CommandLineRunner {
    private static final String GROUNDTRUTH_PATH = "/Users/drizo/GCLOUDUA/HISPAMUS/repositorios/musicatradicional/misiones/hispamus/sibelius_finale/alineados/";

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    SymbolRepository symbolRepository;

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    public ImportFMT(MURETConfiguration muretConfiguration) {
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ImportFMT.class, args);
        SpringApplication.exit(ctx);
    }

    @Override
    public void run(String... args) throws Exception {
        new AuthenticateForScripts(authenticationManager).consoleAuthenticate("davidrizo");

        String path = GROUNDTRUTH_PATH;
        if (args.length == 1) {
            path = args[0];
        }

        ArrayList<File> meiFiles = new ArrayList<>();
        FileUtils.readFiles(new File(path), meiFiles, "mei");

        HashMap<String, File> meiFileMap = new HashMap<>();
        for (File meiFile: meiFiles) {
            meiFileMap.put(meiFile.getName(), meiFile);
        }
        System.out.println("Using path: " + path);

        System.out.println("Importing ...");
        Optional<Collection> collection = collectionRepository.findById(4);
        if (!collection.isPresent()) {
            throw new Exception("Cannot find collection");
        }

        for (Document document : collection.get().getDocuments()) {
            for (Image image: document.getImages()) {
                // now search for which images do we have the transcription
                String expectedMEIFileName = image.getFilename() + ".mei";
                File file = meiFileMap.get(expectedMEIFileName);
                if (file == null) {
                    System.err.println("No MEI for image " + image.getFilename());
                } else {
                    System.out.println("Found MEI file for image " + image.getFilename());
                }

            }
        }
    }

}
