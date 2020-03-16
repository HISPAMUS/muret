package es.ua.dlsi.grfia.moosicae.io.mei;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.core.enums.EMeterSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EModes;
import es.ua.dlsi.grfia.moosicae.io.AbstractImporter;
import es.ua.dlsi.grfia.moosicae.io.builders.*;
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

            parse(nList.item(0), score, voice); //TODO quitar voice y staff
            return score;
        } catch (SAXException | IOException e) {
            throw new IMException("Cannot parse string", e);
        }
    }

    private void parse(Node node, IScore score, IVoice voice) throws IMException {
        switch (node.getNodeName()) { // removing this switch makes it much more difficult
            case "scoreDef":
                processScoreDef(node, score);
                break;
            case "staffDef":
                processStaffDef(node, score, voice);
                break;
        }
        NodeList children = node.getChildNodes();
        if (children != null) {
            for (int i=0; i< children.getLength(); i++) {
                parse(children.item(i), score, voice);
            }
        }
    }

    private void processScoreDef(Node node, IScore score) throws IMException {
        Optional<String> keySig = getAttrValue(node, "key.sig");
        if (keySig.isPresent()) {
            processScoreDefKeySig(node, keySig);
        }
        Optional<String> meterSym = getAttrValue(node, "meter.sym");
        if (meterSym.isPresent()) {
            processScoreDefMeterSym(node, meterSym);
        }
    }

    private Optional<String> getAttrValue(Node node, String name) {
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

    private void processStaffDef(Node node, IScore score, IVoice voice) throws IMException {
        IStaff staff = coreAbstractFactory.createStaff(score);

        Optional<String> clefShape = getAttrValue(node, "clef.shape");
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

        Optional<String> modeString = getAttrValue(node, "key.mode");
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
        Optional<String> clefLine = getAttrValue(node, "clef.line");
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
