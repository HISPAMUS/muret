package es.ua.dlsi.grfia.im3ws.scripts;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.repository.CollectionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.SymbolRepository;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.mensural.ligature.LigaturaCumOppositaPropietate;
import es.ua.dlsi.im3.core.score.mensural.meters.Perfection;
import es.ua.dlsi.im3.core.utils.FileUtils;
import es.ua.dlsi.im3.omr.encoding.agnostic.*;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Used to import the SEILS dataset: https://github.com/SEILSdataset/SEILSdataset/tree/master/SEILSdataset/SEILS_diplomatic_OMRgroundTruth/particellas_original
 * @author drizo
 */
@ComponentScan("es.ua.dlsi.grfia.im3ws")
@EnableJpaRepositories("es.ua.dlsi.grfia.im3ws.muret.repository")
@EntityScan("es.ua.dlsi.grfia.im3ws.muret.entity")
@Transactional
public class ImportAgnosticStaticLauro implements CommandLineRunner {
    private static final String GROUNDTRUTH_PATH = "/Users/drizo/GCLOUDUA/HISPAMUS/repositorios/illauroseco/ISMIR2019-dataset/particellas_OMRgroundTruth_tratados_david";

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    SymbolRepository symbolRepository;

    @Autowired
    AuthenticationManager authenticationManager;



    @Autowired
    public ImportAgnosticStaticLauro(MURETConfiguration muretConfiguration) {
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ImportAgnosticStaticLauro.class, args);
        SpringApplication.exit(ctx);
    }

    @Override
    public void run(String... args) throws Exception {
        new AuthenticateForScripts(authenticationManager).consoleAuthenticate("davidrizo");

        String path = GROUNDTRUTH_PATH;
        if (args.length == 1) {
            path = args[0];
        }
        System.out.println("Using path: " + path);

        System.out.println("Importing ...");
        Optional<Collection> collection = collectionRepository.findById(5);
        if (!collection.isPresent()) {
            throw new Exception("Cannot find collection");
        }

        for (Document document : collection.get().getDocuments()) {
            for (Image image: document.getImages()) {
                // we know each image contains just a page with regions
                for (Page page: image.getPages()) {
                    if (!page.getRegions().isEmpty()) {
                        System.out.println("Importing " + image.getFilename() + "...");
                        String name = FileUtils.getFileNameWithoutExtension(image.getFilename());
                        File fileAgnostic = new File(path, name + ".agnostic");
                        try {
                            if (fileAgnostic.exists()) {
                                List<Region> sortedRegions = page.getSortedStaves(); /*page.getRegions().stream().filter(
                                        region -> region.getRegionType().getName().equals("staff")).
                                        sorted(Region.getVerticalPositionComparator()).collect(Collectors.toList());*/


                                List<String> agnosticLines = Collections.emptyList();
                                agnosticLines = Files.readAllLines(fileAgnostic.toPath(), StandardCharsets.UTF_8).stream().
                                        filter(line -> !line.trim().isEmpty()).collect(Collectors.toList());

                                if (agnosticLines.size() > sortedRegions.size()) {
                                    throw new Exception("The number of agnostic lines " + agnosticLines.size() + " > number of staves " + sortedRegions.size() + " in file ");
                                }

                                File fileSemantic = new File(path, name + ".semantic");
                                if (!fileSemantic.exists()) {
                                    throw new Exception("Cannot find " + fileSemantic.getAbsolutePath());
                                }

                                List<String> semanticLines = Collections.emptyList();
                                semanticLines = Files.readAllLines(fileSemantic.toPath(), StandardCharsets.UTF_8).stream().
                                        filter(line -> !line.trim().isEmpty()).collect(Collectors.toList());

                                if (semanticLines.size() > sortedRegions.size()) {
                                    throw new Exception("The number of semantic lines " + semanticLines.size() + " > number of staves " + sortedRegions.size());
                                }

                                if (semanticLines.size() != agnosticLines.size()) {
                                    throw new Exception("The number of agnostic lines " + agnosticLines.size() + " != number of semanticLines " + semanticLines.size());
                                }

                                // just in case empty staves have been tagged as "staff" rather than "empty_staff"
                                List<SemanticEncoding> semanticEncodings = new ArrayList<>();
                                for (int i = 0; i < agnosticLines.size(); i++) {
                                    Region region = sortedRegions.get(i);
                                    String semanticLine = semanticLines.get(i);
                                    String agnosticLine = agnosticLines.get(i);

                                    for (Symbol symbol : region.getSymbols()) {
                                        symbolRepository.delete(symbol);
                                    }
                                    region.getSymbols().clear();
                                    regionRepository.save(region);

                                    List<Symbol> symbols = importAgnostic(region, agnosticLine);
                                    SemanticEncoding semanticEncoding = importSemantic(semanticLine);
                                    semanticEncodings.add(semanticEncoding);

                                    for (Symbol symbol : symbols) {
                                        symbolRepository.save(symbol);
                                    }
                                }

                                // fix custos and save
                                SemanticNote lastNote = null;
                                for (int i = agnosticLines.size() - 1; i >= 0; i--) {
                                    SemanticEncoding semanticEncoding = semanticEncodings.get(i);
                                    List<SemanticSymbol> symbols = semanticEncoding.getSymbols();
                                    for (int j = symbols.size() - 1; j >= 0; j--) {
                                        SemanticSymbolType semanticSymbolType = symbols.get(j).getSymbol();
                                        if (semanticSymbolType instanceof SemanticNote) {
                                            lastNote = (SemanticNote) semanticSymbolType;
                                        } else if (semanticSymbolType instanceof SemanticCustos) {
                                            if (lastNote == null) {
                                                throw new IM3Exception("Cannot find the next note for the custos");
                                            }
                                            SemanticCustos custos = (SemanticCustos) semanticSymbolType;
                                            custos.getCoreSymbol().setScientificPitch(lastNote.getCoreSymbol().getPitch());
                                        }
                                    }

                                    Region region = sortedRegions.get(i);

                                    String semanticString = semanticEncoding.generateKernSemanticString(NotationType.eMensural);
                                    System.out.println("Semantic string: " + semanticString);

                                    MensSemanticImporter semanticImporter = new MensSemanticImporter();
                                    semanticImporter.importString(NotationType.eMensural, semanticString); // just check it is correct before saving it
                                    region.setSemanticEncoding(semanticString);
                                    regionRepository.save(region);

                                }
                            }
                        } catch (Throwable e) {
                            e.printStackTrace();
                            throw new IM3Exception("Error in file " +fileAgnostic.getName());
                        }
                    }
                }
            }
        }
    }

    private List<Symbol> importAgnostic(Region region, String line) throws Exception {
        List<Symbol> result = new ArrayList<>();
        System.out.println("AGNOSTIC");
        String [] sequence = line.split("\t");
        //TODO stem arriba y abajo
        int width = region.getBoundingBox().getWidth() / sequence.length;
        int currentApproxX = region.getBoundingBox().getFromX();
        for (String token: sequence) {
            String [] subtokens = token.split(":");
            if (subtokens.length != 2) {
                throw new Exception("Expected 2 subtokens in " + token);
            }

            PositionInStaff positionInStaff = PositionInStaff.parseString(subtokens[1]);

            boolean stemUp = false;
            boolean isNote = false;
            String [] subsubtokens = subtokens[0].split("\\.");
            if (subsubtokens[0].equals("note")) {
                isNote = true;
                stemUp = positionInStaff.getLineSpace() <= PositionsInStaff.LINE_3.getLineSpace();
                if (subsubtokens[1].endsWith("/")) {
                    stemUp = true;
                    subtokens[0] = subtokens[0].substring(0, subtokens[0].length()-1); // remove it
                } else if (subsubtokens[1].endsWith("\\")) {
                    stemUp = false;
                    subtokens[0] = subtokens[0].substring(0, subtokens[0].length()-1); // remove it
                }
            }

            String symbolType;
            switch (subtokens[0]) {
                case "barline":
                    symbolType = "verticalLine";
                    break;
                case "note.brevis":
                    symbolType = "note.breve";
                    break;
                case "note.semibrevis":
                    symbolType = "note.whole";
                    break;
                case "note.minima":
                    symbolType = "note.half";
                    break;
                case "note.semiminima":
                    symbolType = "note.quarter";
                    break;
                case "note.fusa":
                    symbolType = "note.eighth";
                    break;
                case "note.semifusa":
                    symbolType = "note.sixteenth";
                    break;
                case "rest.brevis":
                    symbolType = "rest.breve";
                    break;
                case "rest.minima":
                    symbolType = "rest.half";
                    break;
                case "rest.semibrevis":
                    symbolType = "rest.whole";
                    break;
                case "rest.semiminima":
                    symbolType = "rest.seminima";
                    break;
                case "note.brevis~":
                    symbolType = "note.breveBlack";
                    break;
                case "note.semibrevis~":
                    symbolType = "note.wholeBlack";
                    break;
                case "ligature~.end":
                    symbolType = "ligature.end";
                    break;
                case "rest.longa":
                    symbolType = "rest.longa2";
                    break;
                default:
                    symbolType = subtokens[0];
            }

            if (isNote) {
                String [] sst = symbolType.split("\\.");

                if (sst.length != 2) {
                    throw new Exception("Note has not 2 subtokens: " + symbolType);
                }
                NoteFigures noteFigure = NoteFigures.valueOf(sst[1]);
                if (noteFigure == null) {
                    throw new Exception("Cannot find note figure " + subsubtokens[1]);
                }

                if (noteFigure.isUsesStem()) {
                    if (stemUp) {
                        symbolType += "_up";
                    } else {
                        symbolType += "_down";
                    }
                }
            }

            AgnosticSymbolType agnosticSymbolType = AgnosticSymbolTypeFactory.parseString(symbolType);
            AgnosticSymbol agnosticSymbol = new AgnosticSymbol(AgnosticVersion.v2, agnosticSymbolType, positionInStaff);
            Symbol symbol = new Symbol(region, agnosticSymbol, null, null, null, null, currentApproxX);
            result.add(symbol);
            //region.getSymbols().add(symbol);

            System.out.println("Adding " + agnosticSymbol.getAgnosticString() + ", id=" + symbol.getId());
            currentApproxX += width;
        }
        return result;
    }

    private SemanticEncoding importSemantic(String line) throws Exception {
        SemanticEncoding semanticEncoding = new SemanticEncoding();

        String [] sequence = line.split("\t");
        SemanticSymbolType semanticSymbolType = null;
        String ligatureStart = null;
        for (String token: sequence) {

            switch (token) {
                case "barline":
                    semanticSymbolType = new SemanticBarline();
                    break;
                case "clef:C1":
                    semanticSymbolType = new SemanticClef(NotationType.eMensural, ClefNote.C, 1);
                    break;
                case "clef:C2":
                    semanticSymbolType = new SemanticClef(NotationType.eMensural, ClefNote.C, 2);
                    break;
                case "clef:C3":
                    semanticSymbolType = new SemanticClef(NotationType.eMensural, ClefNote.C, 3);
                    break;
                case "clef:C4":
                    semanticSymbolType = new SemanticClef(NotationType.eMensural, ClefNote.C, 4);
                    break;
                case "clef:F3":
                    semanticSymbolType = new SemanticClef(NotationType.eMensural, ClefNote.F, 3);
                    break;
                case "clef:F4":
                    semanticSymbolType = new SemanticClef(NotationType.eMensural, ClefNote.F, 4);
                    break;
                case "clef:G2":
                    semanticSymbolType = new SemanticClef(NotationType.eMensural, ClefNote.G, 2);
                    break;
                case "custos":
                    semanticSymbolType = new SemanticCustos(new Custos(null));
                    break;
                case "keySignature:durus":
                    // C Major ??? - ... modal? - key signature without accidentals
                    break;
                case "keySignature:mollis":
                    // F Major ??? - ... modal? - key signature with 1 flat
                    semanticSymbolType = new SemanticKeySignature(NotationType.eMensural, DiatonicPitch.F, null, MajorMinor.major);
                    break;
                case "timeSignature:3":
                    semanticSymbolType = new SemanticProportioTimeSignature(NotationType.eMensural, 3);
                    break;
                case "timeSignature:C":
                    semanticSymbolType = new SemanticMeterSignTimeSignature(NotationType.eMensural, MeterSigns.C);
                    break;
                case "timeSignature:C/":
                    semanticSymbolType = new SemanticMeterSignTimeSignature(NotationType.eMensural, MeterSigns.Ccut);
                    break;
                case "timeSignature:C32":
                    semanticSymbolType = new SemanticMeterSignTimeSignature(NotationType.eMensural, MeterSigns.CZ);
                    break;
                case "rest_brevis_imperfect":
                    semanticSymbolType = new SemanticRest(Figures.BREVE, 0, false, false);
                    break;
                case "rest_brevis_perfect":
                    semanticSymbolType = new SemanticRest(Figures.BREVE, 0, false, true);
                    break;
                case "rest_longa_imperfect":
                    semanticSymbolType = new SemanticRest(Figures.LONGA, 0, false, false);
                    break;
                case "rest_longa_perfect":
                    semanticSymbolType = new SemanticRest(Figures.LONGA, 0, false, true);
                    break;
                case "rest_minima_imperfect":
                    semanticSymbolType = new SemanticRest(Figures.MINIM, 0, false, false);
                    break;
                case "rest_semibrevis_imperfect":
                    semanticSymbolType = new SemanticRest(Figures.SEMIBREVE, 0, false, false);
                    break;
                case "rest_semibrevis_perfect":
                    semanticSymbolType = new SemanticRest(Figures.SEMIBREVE, 0, false, true);
                    break;
                case "rest_semiminima_imperfect":
                    semanticSymbolType = new SemanticRest(Figures.SEMIMINIM, 0, false, false);
                    break;

                default:
                    String [] subtokens = token.split(":");
                    switch (subtokens[0]) {
                        case "ligature":
                        case "ligatureColorata":
                            if (subtokens[1].indexOf("start") >= 0) {
                                ligatureStart = subtokens[1];
                            } else if (subtokens[1].indexOf("end") >= 0) {
                                semanticSymbolType = processLigature(ligatureStart, subtokens[1]);
                                ligatureStart = null;
                            } else {
                                throw new IM3Exception("Invalid ligature: " + subtokens[1]);
                            }
                            break;
                        case "note":
                            semanticSymbolType = processNote(subtokens[1]);;
                            break;
                        default:
                            throw new IM3Exception("Unkown semantic symbol: " + token);
                    }
            }
            if (semanticSymbolType != null) {
                semanticEncoding.add(semanticSymbolType);
            } else if (ligatureStart == null) {
                throw new IM3Exception("No semantic symbol in " + token);
            }
        }
        return semanticEncoding;
    }

    private SemanticNote processNote(String subtoken) throws IM3Exception {
        String [] subsubtokens = subtoken.split("_");
        ScientificPitch scientificPitch = ScientificPitch.parse(subsubtokens[0]);
        Figures figures;
        boolean colored = false;
        int dots = 0;
        if (subsubtokens[1].endsWith(".")) {
            dots = 1;
            subsubtokens[1] = subsubtokens[1].substring(0, subsubtokens[1].length()-1);
        }
        switch (subsubtokens[1]) {
            case "longa":
                figures = Figures.LONGA;
                break;
            case "brevisColorata":
                figures = Figures.BREVE;
                colored = true;
                break;
            case "brevis":
                figures = Figures.BREVE;
                break;
            case "semibrevis":
                figures = Figures.SEMIBREVE;
                break;
            case "semibrevisColorata":
                figures = Figures.SEMIBREVE;
                colored = true;
                break;
            case "minima":
                figures = Figures.MINIM;
                break;
            case "semiminima":
                figures = Figures.SEMIMINIM;
                break;
            case "fusa":
                figures = Figures.FUSA;
                break;
            case "semifusa":
                figures = Figures.SEMIFUSA;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + subsubtokens[1]);
        }

        Perfection perfection;
        if (subsubtokens[2].equals("imperfect")) {
            perfection = Perfection.imperfectum;
        } else if (subsubtokens[2].equals("perfect")) {
            perfection = Perfection.perfectum;
        } else {
            throw new IM3Exception("Invalid perfection: " + subsubtokens[2]);
        }

        SemanticNote semanticNote = new SemanticNote(false, scientificPitch, null, figures, dots, false, false, null, colored, perfection);
        scientificPitch.setOctave(scientificPitch.getOctave()+1); // everything is set an octave below
        return semanticNote;
    }

    private SemanticLigature processLigature(String ligatureStart, String ligatureEnd) throws IM3Exception {
        //LigaturaCumOppositaPropietate
        String [] subsubtokensStart = ligatureStart.split("_");
        ScientificPitch scientificPitchStart = ScientificPitch.parse(subsubtokensStart[0]);
        String startType = subsubtokensStart[2];

        String [] subsubtokensEnd = ligatureEnd.split("_");
        ScientificPitch scientificPitchEnd = ScientificPitch.parse(subsubtokensEnd[0]);
        String endType = subsubtokensEnd[2];

        //TODO
        Ligature ligature;
        if (startType.equals("imperfect") && startType.equals("imperfect")) {
            ligature = new LigaturaCumOppositaPropietate(scientificPitchStart, 0, scientificPitchEnd, 0, LigatureType.recta);
        } else if (startType.equals("imperfect") && startType.equals("imperfect")) {
            ligature = new LigaturaCumOppositaPropietate(scientificPitchStart, 0, scientificPitchEnd, 0, LigatureType.recta);
        } else {
            throw new IM3Exception("Unkown ligature: " + ligatureStart + " " + ligatureEnd);
        }
        return new SemanticLigature(ligature);
    }
}
