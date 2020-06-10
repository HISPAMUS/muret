package es.ua.dlsi.grfia.im3ws.scripts;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.entity.Collection;
import es.ua.dlsi.grfia.im3ws.muret.repository.CollectionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.SymbolRepository;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.io.ImportException;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.io.mei.MEISongImporter;
import es.ua.dlsi.im3.core.score.mensural.ligature.LigaturaCumOppositaPropietate;
import es.ua.dlsi.im3.core.score.mensural.meters.Perfection;
import es.ua.dlsi.im3.core.utils.FileUtils;
import es.ua.dlsi.im3.omr.encoding.Encoder;
import es.ua.dlsi.im3.omr.encoding.agnostic.*;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.AgnosticSystemBreak;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Digit;
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

// use a different port when launching it simultaneously to the web server
// --server.port=8181
/**
 * Used to import the Fondo de Música Tradicional MEI files that have been obtained from Sibelius and Finale and have
 * been processed by adding system breaks as they appear in the manuscripts
 * @author drizo
 * @deprecated Use ImportMEIFromFMT
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
        if (args.length == 2) { // the first is --server.port=8181
            path = args[1];
        }

        ArrayList<File> meiFiles = new ArrayList<>();
        FileUtils.readFiles(new File(path), meiFiles, "mei");

        HashMap<String, File> meiFileMap = new HashMap<>();
        for (File meiFile: meiFiles) {
            meiFileMap.put(FileUtils.getFileWithoutPathOrExtension(meiFile.getName()), meiFile);
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
                String expectedMEIFileName = FileUtils.getFileWithoutPathOrExtension(image.getFilename());
                File file = meiFileMap.get(expectedMEIFileName);
                if (file == null) {
                   //System.err.println("No MEI for image " + image.getFilename());
                } else {
                    System.out.println("Found MEI file for image " + image.getFilename());
                    try {
                        importFile(image, file);
                    } catch (Exception e) {
                        System.err.println("-----------");
                        System.err.println("Cannot process " + expectedMEIFileName);
                        e.printStackTrace();
                        System.err.println("-----------");
                        throw e;
                    }
                }
            }
        }
    }

    private void importFile(Image image, File meiFile) throws IM3Exception {
        MEISongImporter importer = new MEISongImporter();
        ScoreSong scoreSong = importer.importSong(meiFile);
        if (scoreSong.getStaves().size() != 1) {
            throw new ImportException("Expected 1 staff and found " + scoreSong.getStaves().size());
        }

        if (image.getPages().size() != 1) {
            throw new ImportException("Expected 1 page and found " + image.getPages().size());
        }

        Staff staff = scoreSong.getStaves().get(0);
        List<ITimedElementInStaff> symbols = staff.getCoreSymbolsOrdered();
        TreeMap<Time, SystemBeginning> systemBeginnings = staff.getParts().get(0).getPageSystemBeginnings().getSystemBeginnings();
        int nsystems = systemBeginnings.size();

        List<Region> regions = image.getPages().get(0).getSortedStaves();
        if (regions.size() != nsystems) {
            throw new ImportException("MEI file has " + nsystems + " systems  and there are " + regions.size() + " regions");
        }

        // obtain the segments of each system
        ArrayList<Segment> systems = new ArrayList<>();
        Time prev = Time.TIME_ZERO;
        for (Time systemBeginningTime: systemBeginnings.keySet()) {
            if (!systemBeginningTime.isZero()) {
                systems.add(new Segment(prev, systemBeginningTime));
            }
            prev = systemBeginningTime;
        }
        // last
        systems.add(new Segment(prev, scoreSong.getSongDuration()));
        if (systems.size() != nsystems) {
            throw new ImportException("MEI file has " + nsystems + " systems  and there are " + systems.size() + " segments");
        }


        // now convert all staves
        for (int i=0; i<systems.size(); i++) {
            Encoder encoder = new Encoder(AgnosticVersion.v2, false);
            encoder.encode(staff, systems.get(i));
            System.out.println("Region ID #" + regions.get(i).getId());

            if (encoder.getAgnosticEncoding().size() == 0) {
                throw new ImportException("The agnostic encoding has generated 0 symbols");
            }
            importSemanticEncoding(encoder.getSemanticEncoding(), regions.get(i));

            regions.get(i).getSymbols().clear();
            regionRepository.save(regions.get(i));
            importAgnosticEncoding(encoder.getAgnosticEncoding(), regions.get(i));

        }


        System.out.println(">>>>>>> " + meiFile.getName() + " successfully imported <<<<<");
    }

    private void importSemanticEncoding(SemanticEncoding semanticEncoding, Region region) throws IM3Exception {
        String skern = semanticEncoding.generateKernSemanticString(NotationType.eModern);
        region.setSemanticEncoding(skern);
        System.out.println(skern);
        System.out.println("------");
    }

    private void importAgnosticEncoding(AgnosticEncoding agnosticEncoding, Region region) throws IM3Exception {
        List<AgnosticToken> symbols = agnosticEncoding.getSymbolsWithoutSeparators();
        int symbolWidth = region.getBoundingBox().getWidth() / (symbols.size() + 1); // +1 for the margin
        int nextX = region.getBoundingBox().getFromX() + symbolWidth / 2; // a small margin left

        for (AgnosticToken agnosticToken: symbols) {


            AgnosticSymbol agnosticSymbol = AgnosticSymbol.parseAgnosticString(AgnosticVersion.v2, agnosticToken.getAgnosticString());
            Symbol symbol = new Symbol(region, agnosticSymbol, null, null, null, null, nextX);
            symbolRepository.save(symbol);
            /// region.getSymbols().add(symbol); - avoid adding twice

            // patch to fix positions on fractional meters
            if (!(agnosticToken.getSymbol() instanceof Digit && symbol.getPositionInStaff().equals("L4"))) {
                nextX += symbolWidth;
            } // else don't advance for meter numerator)
        }
    }

}
