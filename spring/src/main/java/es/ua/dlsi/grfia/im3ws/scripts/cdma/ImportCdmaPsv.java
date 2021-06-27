package es.ua.dlsi.grfia.im3ws.scripts.cdma;

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
import es.ua.dlsi.grfia.im3ws.scripts.AuthenticateForScripts;
import es.ua.dlsi.grfia.im3ws.utils.StreamGobbler;
import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.core.IStaff;
import es.ua.dlsi.grfia.moosicae.core.IStaffGroup;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreGraphContentNode;
import es.ua.dlsi.grfia.moosicae.core.scoregraph.IScoreStaffSubgraph;
import es.ua.dlsi.grfia.moosicae.io.kern.KernExporter;
import es.ua.dlsi.grfia.moosicae.io.mei.MEIImporter;
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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

class Incipit {
    String orden;
    String suborden;
    String incipitmusical;
    String clave;
    String armadura;
    String compas;
}
/**
 * It imports a Pipe separated values file (PSV) with PAEC from Centro de Documentación de Andalucía. We'll have in MuRET the document analysis already done.
 * The meaning of the the external reference is:
 * Number: equal to the TSV orden
 * +: it increments the previous number
 * -: it maintains the previous orden, but increments suborden
 * end: stops the importing
 * Empty: use the TSV
 * We'll add several values of external reference to check the TSV is compatible with the MuRET content.
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 8/6/21
 */
@ComponentScan("es.ua.dlsi.grfia.im3ws")
@EnableJpaRepositories("es.ua.dlsi.grfia.im3ws.muret.repository")
@EntityScan("es.ua.dlsi.grfia.im3ws.muret.entity")
@Transactional
public class ImportCdmaPsv implements CommandLineRunner {
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
        ConfigurableApplicationContext ctx = SpringApplication.run(ImportCdmaPsv.class, args);
        SpringApplication.exit(ctx);
    }


    @Autowired
    public ImportCdmaPsv(MURETConfiguration muretConfiguration) {
        this.muretConfiguration = muretConfiguration;
    }

    @Override
    public void run(String... args) throws Exception {
        String path = "/Users/drizo/GCLOUDUA/HISPAMUS/repositorios/catedrales_andalucia/granada/catedral-granada-vol1.psv";
        long documentID = 293;
        if (args.length != 2) {
            System.err.println("Using local path: " + path + " and document " + documentID);
        } else {
            path = args[0];
        }

        // first parse the input file
        List<String> lines = Files.readAllLines(Paths.get(path));

        // Número de orden que comienza en 10000.... son de la Capilla Real.
        for (String line: lines) {
            System.out.println("\n\nLine: " + line);
            String [] cols = line.split(Pattern.quote("|"));
            if (cols.length > 6 ) {
                System.err.println("Line with " + cols.length + " cols: " + line);
            } else  {
                if (!cols[0].equals("orden")) {
                    handleIncipit(cols);
                    return;
                }
            }
        }

        if (true) {
            return;
        }


        new AuthenticateForScripts(authenticationManager).consoleAuthenticate("davidrizo");

        Optional<Document> document = documentRepository.findById(290); // Catedral de Málaga Vol.2
        if (!document.isPresent()) {
            throw new Exception("Cannot find document");
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

    private LinkedList<String> runCommand(String ... commandAndParameters) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command(commandAndParameters);
        Process process = builder.start();
        StreamGobbler streamGobbler =
                new StreamGobbler(process.getInputStream(), System.out::println);

        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assert exitCode == 0;
        return streamGobbler.getLines();

    }
    private File generateMEI(String[] cols) throws IOException, InterruptedException {
        System.out.println("Generating " + cols[0] + ", " + cols[1]);
        String paec =
                "@clef:" + cols[3] + "\n" +
                        "@keysig:" + cols[4] + "\n" +
                        "@timesig:" + cols[5] + "\n" +
                        "@data:" + cols[2];

        Path file = Paths.get("/tmp", "import.paec");
        Files.write(file, paec.getBytes());

        runCommand("verovio", "-t", "mei", file.toFile().getAbsolutePath());
        return new File("/tmp/import.mei");
    }

    private void handleIncipit(String[] cols) throws Exception {
        File file = generateMEI(cols);
        System.out.println("Importing " + cols[0] + ", " + cols[1]);
        MEIImporter importer = new MEIImporter();
        IScore score = importer.importScore(file);
        String semanticEncoding = generateSemanticEncoding(score);
        System.out.println(semanticEncoding);
        generateAgnosticEncoding(score);
    }

    private void generateAgnosticEncoding(IScore score) throws IMException, IOException, InterruptedException {
        // Generate the kern, with verovioomr generate the agnostic encoding, then parse it and import it
        KernExporter kernExporter = new KernExporter(false, false);
        String kern = kernExporter.exportScore(score);
        String tmpFile = "/tmp/imported.kern";
        Files.write(Paths.get("/tmp/imported.kern"), kern.getBytes());
        //TODO Parametrizar
        LinkedList<String> commandOutput = runCommand("/Users/drizo/apps/veroviomr/tools/verovio", "/tmp/imported.kern");
        System.out.println("Lines=" + commandOutput.toString());

        /*IScoreStaffSubgraph[] stavesSubgraphs = score.getScoreGraph().getStavesSubgraphs();

        if (stavesSubgraphs.length != 1) {
            throw new Exception("Incipit has generated " + score.getSystemElements() + " systems");
        }

        IStaff staff = stavesSubgraphs[0].getStaff();
        System.out.println(staff.getNotationType());

        IScoreGraphContentNode[] next = score.getScoreGraph().getStartNode().getNextNodes(stavesSubgraphs[0]);
        while (next != null && next.length > 0) {
            if (next.length > 1) {
                throw new IMException("Not supported several voices in import, found #" + next.length);
            }

            System.out.println(next[0].getContent());
            next = next[0].getNextNodes(stavesSubgraphs[0]);
        }*/
    }

    private String generateSemanticEncoding(IScore score) throws IMException {
        KernExporter kernExporter = new KernExporter(false, true);
        String ekern = kernExporter.exportScore(score);
        return ekern;
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
                    throw new Exception("The incipit contains the comma character: '" + line + "'");
                }
                incipit = line.substring(6);
            } else if (line.startsWith("@keysig:")) {
                keySig = line.substring(8);
            } else if (line.startsWith("@timesig:")) {
                timeSig = line.substring(9);
            } else if (line.startsWith("@clef:")) {
                clef = line.substring(6);
            } else {
                throw new Exception("Invalid prefix: " + line);
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
