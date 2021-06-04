package es.ua.dlsi.grfia.im3ws.scripts;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Notation;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Renderer;
import es.ua.dlsi.grfia.im3ws.muret.entity.Document;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.entity.Page;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.model.NotationModel;
import es.ua.dlsi.grfia.im3ws.muret.repository.DocumentRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.utils.StreamGobbler;
import es.ua.dlsi.im3.core.IM3Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;

/**
 * It generates a TSV with the PAEC code from the MuRET transcription. Cannot use commas to separate columns. e.g: @data:8-6,G6G8G6G6A8'C8,B4-/8-6'D6D8,B3B6'C8D/
 * We don't use Javascript for loading Verovio into Java because we are getting some troubles.
 * It's easier for us to use the command line from here
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 4/6/21
 */
@ComponentScan("es.ua.dlsi.grfia.im3ws")
@EnableJpaRepositories("es.ua.dlsi.grfia.im3ws.muret.repository")
@EntityScan("es.ua.dlsi.grfia.im3ws.muret.entity")
@Transactional
public class GenerateMalagaTSV implements CommandLineRunner {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    ResourceLoader resourceLoader;


    private final MURETConfiguration muretConfiguration;


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(GenerateMalagaTSV.class, args);
        SpringApplication.exit(ctx);
    }


    @Autowired
    public GenerateMalagaTSV(MURETConfiguration muretConfiguration) {
        this.muretConfiguration = muretConfiguration;
    }

    @Override
    public void run(String... args) throws Exception {
        new AuthenticateForScripts(authenticationManager).consoleAuthenticate("davidrizo");

        Optional<Document> document = documentRepository.findById(290); // Catedral de Málaga Vol.2
        if (!document.isPresent()) {
            throw new IM3Exception("Cannot find document");
        }

        String lastReference = null;
        int suborden = 1;
        NotationModel notationModel = new NotationModel();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("orden\tsuborden\tincipitmusical\tclave\tarmadura\tcompas\n");
        LinkedList<Region> regionsToSave = new LinkedList<>();
        boolean started = false;
        for (Image image: document.get().computeAllImagesSorted()) {
            if (image.getId() == 4759) {
                started = true;
            }
            if (started) {
                System.out.println("Exporting image " + image.getFilename());
                for (Page page : image.computeSortedPages()) {
                    int nregion = 1;
                    for (Region region : page.computeSortedStaves()) {
                        if (region.getSemanticEncoding() != null) {
                            Notation notation = notationModel.getNotation(document.get(), "Single", region, false, Renderer.verovio);
                            if (region.getExternalReference() == null) {
                                stringBuilder.append("Falta pentagrama " + nregion + " en " + image.getFilename());
                            } else {
                                stringBuilder.append(region.getExternalReference());
                            }

                            if (lastReference == null || !lastReference.equals(region.getExternalReference())) {
                                suborden = 1;
                            } else {
                                suborden++;
                            }
                            stringBuilder.append('\t');
                            stringBuilder.append(suborden);
                            stringBuilder.append('\t');
                            addPAE(notation, stringBuilder);
                            stringBuilder.append('\n');

                            lastReference = region.getExternalReference();
                        }
                        nregion++;
                    }
                }
            }
        }
        Files.write(Paths.get("/tmp", "malaga_madueno.tsv"), stringBuilder.toString().getBytes());
    }

    /**
     * It adds the three columns (clef, timesignature, data) from Verovio output
     * @param notation
     * @param stringBuilder
     * @throws IOException
     * @throws InterruptedException
     */
    private void addPAE(Notation notation, StringBuilder stringBuilder) throws Exception {
        // first write to MEI file
        String pathStr = "/tmp/_malaga.mei";
        Path path = Paths.get(pathStr);
        byte[] strToBytes = notation.getContent().getBytes();
        Files.write(path, strToBytes);

        // next generate the PAEC code
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("verovio", "-t", "pae", pathStr);
        Process process = builder.start();
        StreamGobbler streamGobbler =
                new StreamGobbler(process.getInputStream(), System.out::println);

        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assert exitCode == 0;

        // now, read the output
        List<String> paecLines = Files.readAllLines(Paths.get("/tmp", "_malaga.pae"));
        if (paecLines == null || paecLines.isEmpty()) {
            throw new Exception("Empty lines");
        }


        String clef = "";
        String timeSig = "";
        String keySig = "";
        String incipit = "";

        for (String line: paecLines) {
            if (line.startsWith("@data:")) {
                if (line.indexOf('\t') >= 0) {
                    throw new IM3Exception("The incipit contains the comma character: '" + line + "'");
                }
                incipit = line.substring(6);
            } else if (line.startsWith("@keysig:")) {
                keySig = line.substring(8);
            } else if (line.startsWith("@timesig:")) {
                timeSig = line.substring(9);
            } else if (line.startsWith("@clef:")) {
                clef = line.substring(6);
            } else {
                throw new IM3Exception("Invalid prefix: " + line);
            }
        }
        stringBuilder.append(incipit);
        stringBuilder.append('\t');
        stringBuilder.append(clef);
        stringBuilder.append('\t');
        stringBuilder.append(keySig);
        stringBuilder.append('\t');
        stringBuilder.append(timeSig);
    }
}
