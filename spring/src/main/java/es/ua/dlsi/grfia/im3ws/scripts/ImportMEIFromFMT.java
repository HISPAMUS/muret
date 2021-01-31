package es.ua.dlsi.grfia.im3ws.scripts;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.entity.Collection;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.io.mei.MEISongImporter;
import es.ua.dlsi.im3.core.utils.FileUtils;
import es.ua.dlsi.im3.omr.encoding.Encoder;
import es.ua.dlsi.im3.omr.encoding.Sequence;
import es.ua.dlsi.im3.omr.encoding.agnostic.*;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.AgnosticSystemBreak;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Digit;
import es.ua.dlsi.im3.omr.encoding.semantic.MensSemanticImporter;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticEncoding;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticSystemBreak;
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
import java.util.*;
import java.util.logging.Logger;

// Use a different port (as environment variable) when launching it simultaneously to the web server
// --server.port=8181

/**
 * Used to import the Fondo de Música Tradicional dataset https://musicatradicional.eu/es/home from files already encoded in Sibelius or Finale.
 * In Sibelius, MEI files are exported to be imported here.
 * It imports the semantic encoding and the agnostic (deduced from the semantic). It assigns a MuRET part (instrument) named "Voz" to each image.
 * Requirements:
 * - the name of the document must be the same as the name of the folder
 * - the filename of the MEI file must match the image name in MuRET
 * - either the GROUNDTRUTH_PATH or COLLECTION can be used or provided using parameters (first ground-truth, second collection)
 * @author drizo
 */
@ComponentScan("es.ua.dlsi.grfia.im3ws")
@EnableJpaRepositories("es.ua.dlsi.grfia.im3ws.muret.repository")
@EntityScan("es.ua.dlsi.grfia.im3ws.muret.entity")
@Transactional
public class ImportMEIFromFMT implements CommandLineRunner {
    private static final String GROUNDTRUTH_PATH = System.getProperty("user.home") + "/GCLOUDUA/HISPAMUS/repositorios/musicatradicional/misiones/hispamus/sibelius_finale/alineados";
    private static final String [] DOCUMENTS = {"C5", "C14", "M16", "M38"};
    //private static final String [] DOCUMENTS = {"M16"};
    private static final HashSet<String> DOCUMENTS_WITHOUT_CLEF_KEYSIG_IN_ALL_STAVES = new HashSet<>(); { // these works have contain the clef and key signature just in the first staff
        DOCUMENTS_WITHOUT_CLEF_KEYSIG_IN_ALL_STAVES.add("C5");
        DOCUMENTS_WITHOUT_CLEF_KEYSIG_IN_ALL_STAVES.add("C14");
    }
            //private static final String [] DOCUMENTS = {"M16"};

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    SymbolRepository symbolRepository;

    @Autowired
    PartRepository partRepository;

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    public ImportMEIFromFMT(MURETConfiguration muretConfiguration) {
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ImportMEIFromFMT.class, args);
        SpringApplication.exit(ctx);
    }

    @Override
    public void run(String... args) throws Exception {
        new AuthenticateForScripts(authenticationManager).consoleAuthenticate("davidrizo");

        String path = GROUNDTRUTH_PATH;
        if (args.length == 1) {
            path = args[0];
        } else if (args.length != 0) {
            throw new Exception("Use: <MEI folders path>");
        }

        StringBuilder filesWithErrors = new StringBuilder();
        for (String documentName: DOCUMENTS) {
            System.out.println("Importing " + documentName + " using path '" + path + "'");
            boolean propagateClefAndKeySignature = !DOCUMENTS_WITHOUT_CLEF_KEYSIG_IN_ALL_STAVES.contains(documentName);
            System.out.println("\tPropagating clef and key signature between staves? " + propagateClefAndKeySignature);
            Optional<Document> document = documentRepository.findByName(documentName);
            if (!document.isPresent()) {
                throw new Exception("Cannot find collection");
            }
            File collectionFolder = new File(path, documentName);
            if (!collectionFolder.exists()) {
                throw new Exception("Cannot find collection folder " + collectionFolder.getAbsolutePath());
            }

            Part voz = null; // the same part is assigned to each document

            ArrayList<File> meiFiles = new ArrayList<>();
            FileUtils.readFiles(collectionFolder, meiFiles, "mei");
            for (File file : meiFiles) {
                try {
                    System.out.println("\n------------------------\nImporting MEI file " + file.getName());
                    // look for the image file
                    String jpg = FileUtils.getFileWithoutPathOrExtension(file) + ".jpg";
                    Optional<Image> image = imageRepository.findByFilename(jpg);
                    if (!image.isPresent()) {
                        throw new Exception("Cannot find image in MuRET named " + jpg);
                    }

                    if (image.get().getDocument().getId() != document.get().getId()) {
                        throw new Exception("Filename does not belong to the document");
                    }

                    if (image.get().getPages().size() != 1) {
                        throw new Exception("Expected 1 page and found " + image.get().getPages().size());
                    }

                    Page page = image.get().getPages().get(0);

                    // import MEI file
                    MEISongImporter meiSongImporter = new MEISongImporter();
                    ScoreSong scoreSong = meiSongImporter.importSong(file);
                    if (scoreSong.getParts().size() != 1) {
                        throw new Exception("Expected 1 part and found " + scoreSong.getParts().size());
                    }
                    ScorePart part = scoreSong.getParts().get(0);
                    PageSystemBeginnings pageSystemBeginnings = part.getPageSystemBeginnings();

                    if (pageSystemBeginnings == null) {
                        throw new Exception("Cannot find page system beginnings");
                    }

                    // assign a voice / part / instrument
                    if (image.get().getPart() == null) {
                        Logger.getLogger(this.getClass().getName()).info("Image " + image.get().getFilename() + " did not contain a part yet");
                        if (document.get().getParts() != null && document.get().getParts().size() > 0) {
                            voz = document.get().getParts().get(0);
                            Logger.getLogger(this.getClass().getName()).info("There were "+ document.get().getParts().size() + " voices in document " + document.get().getName() + ", using the first one namned '" + voz.getName() + "'");
                        } else {
                            voz = new Part("Voz", null, document.get());
                            partRepository.save(voz);
                            document.get().getParts().add(voz);
                            documentRepository.save(document.get());
                            Logger.getLogger(this.getClass().getName()).info("There were no voices for "+ document.get().getName() + ", creating a new one named '" + voz.getName() + "'");
                        }
                        image.get().setPart(voz);
                        imageRepository.save(image.get());
                    } else {
                        Logger.getLogger(this.getClass().getName()).info("Image " + image.get().getFilename() + " already contain a voice named '" + image.get().getPart().getName() + "'");
                    }


                    // check the number of staves in MuRET matches the number of staves in MEI file
                    TreeMap<Time, SystemBeginning> pageSystemBeginningsMap = pageSystemBeginnings.getSystemBeginnings();
                    List<Region> staves = page.getSortedStaves();
                    if (staves.size() != pageSystemBeginningsMap.size()) {
                        throw new Exception("MuRET has " + staves.size() + "staves  and MEI file has " + pageSystemBeginnings.getSystemBeginnings().size());
                    }

                    // encode agnostic and semantic
                    Encoder encoder = new Encoder(true, propagateClefAndKeySignature, propagateClefAndKeySignature);
                    encoder.encode(scoreSong);
                    AgnosticEncoding agnosticEncoding = encoder.getAgnosticEncoding();
                    SemanticEncoding semanticEncoding = encoder.getSemanticEncoding();

                    // split the encoding into systems
                    List<Sequence<AgnosticToken>> agnosticSystems = new LinkedList<>();
                    Sequence<AgnosticToken> agnosticTokenSequence = null;
                    for (AgnosticToken agnosticToken : agnosticEncoding.getSymbolsWithoutSeparators()) {
                        if (agnosticToken instanceof AgnosticSystemBreak) {
                            agnosticTokenSequence = new Sequence<>(); // new sequence
                            agnosticSystems.add(agnosticTokenSequence);
                        } else {
                            if (agnosticTokenSequence == null) {
                                throw new Exception("Expected a page beginning in MEI that generates an agnostic system beginning");
                            }
                            agnosticTokenSequence.add(agnosticToken);
                        }
                    }

                    if (agnosticSystems.size() != staves.size()) {
                        throw new Exception("The number of agnostic systems (" + agnosticSystems.size() + ") != MuRET staves size (" + staves.size() + ")");
                    }

                    List<SemanticEncoding> semanticSystems = new LinkedList<>();
                    SemanticEncoding semanticTokenSequence = null;
                    for (SemanticSymbol semanticSymbol : semanticEncoding.getSymbols()) {
                        if (semanticSymbol instanceof SemanticSystemBreak) {
                            semanticTokenSequence = new SemanticEncoding();
                            semanticSystems.add(semanticTokenSequence);
                        } else {
                            if (semanticTokenSequence == null) {
                                throw new Exception("Expected a page beginning in MEI that generates an semantic system beginning");
                            }

                            semanticTokenSequence.add(semanticSymbol);
                        }
                    }

                    // remove last one if empty
                    if (semanticTokenSequence.size() == 0) {
                        semanticSystems.remove(semanticSystems.size() - 1);
                    }

                    if (semanticSystems.size() != staves.size()) {
                        throw new Exception("The number of sematic systems (" + agnosticSystems.size() + ") != MuRET staves size (" + staves.size() + ")");
                    }

                    for (int i = 0; i < staves.size(); i++) {
                        importStaffContent(i, staves.get(i), agnosticSystems.get(i), semanticSystems.get(i));
                    }
                } catch (Exception e) {
                    filesWithErrors.append(file.getName());
                    filesWithErrors.append(':');
                    filesWithErrors.append(e.toString());
                    filesWithErrors.append('\n');
                    e.printStackTrace();
                }
            }
        }

        if (filesWithErrors.toString().trim().isEmpty()) {
            System.err.println("NO ERRORS FOUND");
        } else {
            System.err.println("ERRORS FOUND IN FILES");
            System.err.println(filesWithErrors);
        }
    }

    private void importStaffContent(int regionNumber, Region region, Sequence<AgnosticToken> agnosticTokenSequence, SemanticEncoding semanticEncoding) throws Exception {
        if (agnosticTokenSequence.size() == 0) {
            throw new Exception("Agnostic sequence for region #" + regionNumber + " is empty");
        }

        if (semanticEncoding.size() == 0) {
            throw new Exception("Semantic sequence for region #" + regionNumber + " is empty");
        }

        // first clean it
        region.getSymbols().clear();
        region.setSemanticEncoding(null);

        // now insert all values
        // we consider each agnostic symbol takes the same space
        int symbolWidth = region.getBoundingBox().getWidth() / (agnosticTokenSequence.size() + 1);
        int currentApproxX = region.getBoundingBox().getFromX() + symbolWidth;
        List<Symbol> agnosticSymbols = new LinkedList<>();
        for (int i=0; i < agnosticTokenSequence.getSymbols().size(); i++) {
            AgnosticToken token = agnosticTokenSequence.getSymbols().get(i);
            PositionInStaff positionInStaff = null;
            AgnosticSymbolType agnosticSymbolType = null;
            if ((token instanceof AgnosticSymbol)) {
                positionInStaff = ((AgnosticSymbol) token).getPositionInStaff();
                agnosticSymbolType = ((AgnosticSymbol) token).getSymbol();
                AgnosticSymbol agnosticSymbol = new AgnosticSymbol(AgnosticVersion.v2, agnosticSymbolType, positionInStaff);
                Symbol symbol = new Symbol(region, agnosticSymbol, null, null, null, null, currentApproxX);
                // patch to fix positions on fractional meters
                if (!(agnosticSymbol.getSymbol() instanceof Digit && symbol.getPositionInStaff().equals("L4"))) {
                    currentApproxX += symbolWidth;
                }

                region.getSymbols().add(symbol);
            } else {
                throw new Exception("Not an agnostic symbol: " + token);
            }
        }

        region.getSymbols().addAll(agnosticSymbols);
        regionRepository.save(region);


        // semantic
        String semanticString = semanticEncoding.generateKernSemanticString(NotationType.eModern);
        System.out.println("Semantic string: " + semanticString);
        region.setSemanticEncoding(semanticString);
        regionRepository.save(region);
    }
}
