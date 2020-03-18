package es.ua.dlsi.grfia.moosicae.io.mei;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.io.AbstractImporter;
import es.ua.dlsi.grfia.moosicae.core.builders.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.Optional;

/**
 * Use DOM for importing, maybe a little bit slower than STAX or SAX but we have more control
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class MEIImporter extends AbstractImporter {

    private IMeterSymbolBuilder meterSymbolBuilder;
    private IKeyFromAccidentalCountBuilder keyFromAccidentalCountBuilder;
    private IAccidentalSymbolBuilder accidentalSymbolBuilder;
    private IDiatonicPitchBuilder diatonicPitchBuilder;
    private IFigureBuilder figureBuilder;
    private INoteBuilder noteBuilder;
    private IPitchBuilder pitchBuilder;
    private Integer octave; // no need of a builder

    /**
     * It uses the default core factory
     */
    public MEIImporter() {
    }

    public MEIImporter(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);
    }

    @Override
    public IScore importScore(String input) throws IMException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new IMException("Cannot configure DOM parser", e);
        }

        try {
            Document doc = db.parse(new InputSource( new StringReader( input )));
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("mei");
            if (nList == null || nList.getLength() != 1) {
                int count = nList == null ? 0 : nList.getLength();
                throw new IMException("Expected one top element named 'mei' and found '" + count);
            }
            IScore score = coreAbstractFactory.createScore();

            //TODO quitar la inicialización a pelo
            IPart part = coreAbstractFactory.createPart(score, "TODO");
            IVoice voice = coreAbstractFactory.createVoice(part);
            IStaff staff = coreAbstractFactory.createStaff(score);

            parse(nList.item(0), score, voice, staff); //TODO quitar voice y staff
            return score;
        } catch (SAXException | IOException e) {
            throw new IMException("Cannot parse string", e);
        }
    }

    private void parse(Node node, IScore score, IVoice voice, IStaff staff) throws IMException {
        NodeList children = node.getChildNodes();
        if (children != null) {
            for (int i=0; i< children.getLength(); i++) {
                parse(children.item(i), score, voice, staff);
            }
        }
        switch (node.getNodeName()) { // removing this switch makes it much more difficult
            case "scoreDef":
                processScoreDef(node, score);
                break;
            case "staffDef":
                processStaffDef(node, score, voice);
                break;
            case "accid":
                processAccid(node);
                break;
            case "note":
                processNote(node, score, voice, staff);
                break;
        }
    }

    private void processNote(Node node, IScore score, IVoice voice, IStaff staff) throws IMException {
        noteBuilder = new INoteBuilder(coreAbstractFactory);
        processPitch(node);
        processFigure(node);
        noteBuilder.setPitch(pitchBuilder.build());
        noteBuilder.setFigure(figureBuilder.build());
        //TODO dots
        INote note = noteBuilder.build();
        score.add(voice, staff, note);

        // set to null all used values
        this.diatonicPitchBuilder = null;
        this.accidentalSymbolBuilder = null;
        this.figureBuilder = null;
        this.octave = null;

    }

    private void processPitch(Node node) throws IMException {
        pitchBuilder = new IPitchBuilder(coreAbstractFactory);
        processDiatonicPitch(node);
        //TODO process Accid si aparece como parámetro
        processOctave(node);
        if (octave != null) {
            pitchBuilder.setOctave(octave);
        }
        if (diatonicPitchBuilder != null) {
            pitchBuilder.setDiatonicPitch(diatonicPitchBuilder.build());
        }
    }

    private void processOctave(Node node) {
        Optional<String> oct = getOptionalAttrValue(node, "oct");
        if (oct.isPresent()) {
            octave = Integer.parseInt(oct.get());
        }
    }

    private void processAccid(Node node) throws IMException {
        //TODO hidden, editorial...
        Optional<String> accidGes = getOptionalAttrValue(node, "accid.ges");
        if (accidGes.isPresent()) {
            processAccidentalSymbol(accidGes.get()); //TODO procesarlo como ges
        }         
    }

    private void processDiatonicPitch(Node node) {
        Optional<String> pname = getOptionalAttrValue(node, "pname");
        if (pname.isPresent()) {
            diatonicPitchBuilder = new IDiatonicPitchBuilder(coreAbstractFactory);
            diatonicPitchBuilder.setDiatonicPitch(EDiatonicPitches.valueOf(pname.get().toUpperCase()));
        }
    }

    private void processFigure(Node node) throws IMException {
        String dur = getRequiredAttrValue(node, "dur");
        EFigures eFigure;
        switch (dur) {
            case "maxima":
                eFigure = EFigures.MAXIMA;
                break;
            case "longa":
                eFigure = EFigures.LONGA;
                break;
            case "brevis":
                eFigure = EFigures.BREVE;
                break;
            case "semibrevis":
                eFigure = EFigures.SEMIBREVE;
                break;
            case "minima":
                eFigure = EFigures.MINIM;
                break;
            case "semiminima":
                eFigure = EFigures.SEMIMINIM;
                break;
            case "fusa":
                eFigure = EFigures.FUSA;
                break;
            case "semifusa":
                eFigure = EFigures.SEMIFUSA;
                break;
            case "long":
                eFigure = EFigures.QUADRUPLE_WHOLE;
                break;
            case "breve":
                eFigure = EFigures.DOUBLE_WHOLE;
                break;
            default:
                eFigure = EFigures.findMeterUnit(Integer.parseInt(dur), ENotationTypes.eModern);
        }
        figureBuilder = new IFigureBuilder(coreAbstractFactory);
        figureBuilder.setFigure(eFigure);
    }

    private void processAccidentalSymbol(String accidentalValue) throws IMException {
        accidentalSymbolBuilder = new IAccidentalSymbolBuilder(coreAbstractFactory);
        EAccidentalSymbols eAccidentalSymbol;
        switch (accidentalValue) {
            case "fff":
                eAccidentalSymbol = EAccidentalSymbols.TRIPLE_FLAT;
                break;
            case "ff":
                eAccidentalSymbol = EAccidentalSymbols.DOUBLE_FLAT;
                break;
            case "f":
                eAccidentalSymbol = EAccidentalSymbols.FLAT;
                break;
            case "n":
                eAccidentalSymbol = EAccidentalSymbols.NATURAL;
                break;
            case "s":
                eAccidentalSymbol = EAccidentalSymbols.SHARP;
                break;
            case "ss":
                eAccidentalSymbol = EAccidentalSymbols.DOUBLE_SHARP;
                break;
            default:
                throw new IMException("Unkown accidental symbol '" + accidentalValue + "'");
        }

        accidentalSymbolBuilder.setAccidentalSymbol(eAccidentalSymbol);
    }

    private void processScoreDef(Node node, IScore score) throws IMException {
        Optional<String> keySig = getOptionalAttrValue(node, "key.sig");
        if (keySig.isPresent()) {
            processScoreDefKeySig(node, keySig);
        }
        Optional<String> meterSym = getOptionalAttrValue(node, "meter.sym");
        if (meterSym.isPresent()) {
            processScoreDefMeterSym(node, meterSym);
        }
    }

    private Optional<String> getOptionalAttrValue(Node node, String name) {
        if (node.getAttributes() == null) {
            return Optional.empty();
        } else {
            Node attribute = node.getAttributes().getNamedItem(name);
            if (attribute != null) {
                return Optional.ofNullable(attribute.getNodeValue());
            } else {
                return Optional.empty();
            }

        }
    }

    private String getRequiredAttrValue(Node node, String name) throws IMException {
        if (node.getAttributes() == null) {
            throw new IMException("Expected an attribute '" + name + "' at node " + node.toString());
        } else {
            Node attribute = node.getAttributes().getNamedItem(name);
            if (attribute != null) {
                return attribute.getNodeValue();
            } else {
                throw new IMException("Expected an attribute '" + name + "' at node " + node.toString());
            }

        }
    }

    private void processStaffDef(Node node, IScore score, IVoice voice) throws IMException {
        IStaff staff = coreAbstractFactory.createStaff(score);

        Optional<String> clefShape = getOptionalAttrValue(node, "clef.shape");
        if (clefShape.isPresent()) {
            processStaffDefClef(node, voice, staff, clefShape);
        }

        if (keyFromAccidentalCountBuilder != null) {
            IKey key = keyFromAccidentalCountBuilder.build();
            staff.put(key);
            voice.addItem(key);
        }
        if (meterSymbolBuilder != null) {
            IMeterSymbol meterSymbol = meterSymbolBuilder.build();
            staff.put(meterSymbol);
            voice.addItem(meterSymbol);
        }

    }

    private void processScoreDefMeterSym(Node node, Optional<String> meterSym) throws IMException {
        meterSymbolBuilder = new IMeterSymbolBuilder(coreAbstractFactory);
        switch (meterSym.get()) {
            case "common":
                meterSymbolBuilder.setMeterSymbols(EMeterSymbols.commonTime);
                break;
            case "cut":
                meterSymbolBuilder.setMeterSymbols(EMeterSymbols.cutTime);
                break;
            default:
                throw new IMException("Unsupported meter symbol '" + meterSym.get() + "'");
        }
    }

    private void processScoreDefKeySig(Node node, Optional<String> keySig) throws IMException {
        //TODO quizás habrá que hacer que IKeyFromAccidentalCountBuilder herede de un IKeyBuilder para poder generalizar las formas de crear keys
        keyFromAccidentalCountBuilder = new IKeyFromAccidentalCountBuilder(coreAbstractFactory);

        if (keySig.get().length() != 2) {
            throw new IMException("Expected 2 characters for keySig value: '" + keySig.get() + "'");
        }
        int nAccidentals = Integer.parseInt(keySig.get().substring(0, 1));
        keyFromAccidentalCountBuilder.setAccidentalCount(nAccidentals);

        char accidental = keySig.get().charAt(1);
        IAccidentalSymbol accidentalSymbol;
        if (accidental == 'f') {
            accidentalSymbol = coreAbstractFactory.createAccidentalSymbol(EAccidentalSymbols.FLAT);
        } else if (accidental == 's') {
            accidentalSymbol = coreAbstractFactory.createAccidentalSymbol(EAccidentalSymbols.SHARP);
        } else {
            throw new IMException("Unkown accidental: '" + accidental + "'");
        }
        keyFromAccidentalCountBuilder.setAccidentalSymbol(accidentalSymbol);

        Optional<String> modeString = getOptionalAttrValue(node, "key.mode");
        if (modeString.isPresent()) {
            IModeBuilder modeBuilder = new IModeBuilder(coreAbstractFactory);
            modeBuilder.setMode(EModes.valueOf(modeString.get().toLowerCase()));
            IMode mode = modeBuilder.build();

            keyFromAccidentalCountBuilder.setMode(mode);
        } else {
            throw new UnsupportedOperationException("TODO-crear keysignature");
        }
    }

    private void processStaffDefClef(Node node, IVoice voice, IStaff staff, Optional<String> clefShape) throws IMException {
        IClefBuilder clefBuilder = new IClefBuilder(coreAbstractFactory);
        clefBuilder.setClefSign(coreAbstractFactory.createClefSign(EClefSigns.valueOf(clefShape.get())));
        Optional<String> clefLine = getOptionalAttrValue(node, "clef.line");
        if (clefLine.isPresent()) {
            clefBuilder.setLine(Integer.parseInt(clefLine.get()));
        }

        IClef clef = clefBuilder.build();
        voice.addItem(clef);
        staff.put(clef);

        if (meterSymbolBuilder != null) {
            IMeterSymbol meterSymbol = meterSymbolBuilder.build();
            voice.addItem(meterSymbol);
            staff.put(meterSymbol);
            meterSymbolBuilder = null;
        }
    }
}
