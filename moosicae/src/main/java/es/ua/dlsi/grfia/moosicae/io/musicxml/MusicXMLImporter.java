package es.ua.dlsi.grfia.moosicae.io.musicxml;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.*;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.impl.CoreItem;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.*;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporter;

import javax.xml.stream.events.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Use StAX for parsing
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 19/03/2020
 */
public class MusicXMLImporter extends XMLImporter<MusicXMLImporterVisitor> {
    private List<MusicXMLImportedPart> musicXMLImportedParts;
    private IScore score;

    public MusicXMLImporter(ICoreAbstractFactory abstractFactory) {
        super(abstractFactory, new MusicXMLImporterVisitor(abstractFactory));
        coreObjectBuilderSuppliers.add("score-partwise", IScoreBuilder::new);
        coreObjectBuilderSuppliers.add("score-part", IPartBuilder::new);
        coreObjectBuilderSuppliers.add("part-name", INameBuilder::new);
        coreObjectBuilderSuppliers.add("part", MusicXMLPartBuilder::new);
        coreObjectBuilderSuppliers.add("measure", IBarlineBuilder::new);
        coreObjectBuilderSuppliers.add("attributes", MusicXMLAttributesBuilder::new);

        coreObjectBuilderSuppliers.add("clef", IClefBuilder::new);
        coreObjectBuilderSuppliers.add("sign", IClefSignBuilder::new);
        coreObjectBuilderSuppliers.add("line", IClefLineBuilder::new);

        coreObjectBuilderSuppliers.add("key", IKeyFromAccidentalCountBuilder::new);
        coreObjectBuilderSuppliers.add("mode", IModeBuilder::new);

        coreObjectBuilderSuppliers.add("time", IFractionalTimeSignatureBuilder::new);
        coreObjectBuilderSuppliers.add("beats", ITimeSignatureNumeratorBuilder::new);
        coreObjectBuilderSuppliers.add("beat-type", ITimeSignatureDenominatorBuilder::new);

        coreObjectBuilderSuppliers.add("note", MusicXMLNoteBuilder::new);
        coreObjectBuilderSuppliers.add("pitch", IPitchBuilder::new);
        coreObjectBuilderSuppliers.add("octave", IOctaveBuilder::new);
        coreObjectBuilderSuppliers.add("step", IDiatonicPitchBuilder::new);
        coreObjectBuilderSuppliers.add("alter", IAlterationBuilder::new);

        coreObjectBuilderSuppliers.add("duration", IFigureBuilder::new);

        musicXMLImportedParts = new LinkedList<>();
    }

    @Override
    protected boolean handleSpecialStartElement(StartElement startElement) {
        boolean consumed = true;
        switch (startElement.getName().getLocalPart()) {
            default:
                consumed = false;
        }
        return consumed;
    }

    @Override
    protected boolean handleSpecialCharactersElement(String elementName, String data) {
        boolean consumed = true;
        switch (elementName) {
            case "divisions":
                xmlImporterVisitor.setDivisions(Integer.parseInt(data));
                break;
            case "fifths":
                handleFifths(data);
                break;
            default:
                consumed = false;
        }
        return consumed;
    }

    private void handleFifths(String data) {
        int fifths = Integer.parseInt(data);
        IKeyAccidentalCount keyAccidentalCount = null;
        IAccidentalSymbol accidentalSymbol = null;
        if (fifths < 0) {
            fifths = -fifths;
            accidentalSymbol = coreAbstractFactory.createAccidentalSymbol(coreAbstractFactory.createId(), EAccidentalSymbols.FLAT);
        } else if (fifths > 0) {
            accidentalSymbol = coreAbstractFactory.createAccidentalSymbol(coreAbstractFactory.createId(), EAccidentalSymbols.SHARP);
        }
        keyAccidentalCount = coreAbstractFactory.createKeyAccidentalCount(coreAbstractFactory.createId(), fifths);
        importingContexts.addObjectToPool(keyAccidentalCount);
        if (accidentalSymbol != null) {
            importingContexts.addObjectToPool(accidentalSymbol);
        }
    }

    @Override
    protected boolean handleSpecialEndElement(EndElement endElement) {
        return false;
    }

    @Override
    protected void onEndElement(String elementName, Object coreObject) {
        switch (elementName) {
            case "part":
                MusicXMLImportedPart part = (MusicXMLImportedPart) coreObject;
                insertPartItems(part);
                break;
            case "score-partwise":
                score = (IScore) coreObject;
                break;
        }
    }

    private void insertPartItems(MusicXMLImportedPart part) {
        musicXMLImportedParts.add(part);
    }


    @Override
    protected IScore buildScore() throws IMException {
        // now build the score from all parts

        HashMap<IId, IPart> partHashMap = new HashMap<>();
        for (IPart part: score.getParts()) {
            partHashMap.put(part.getId(), part);
        }

        for (MusicXMLImportedPart musicXMLImportedPart: musicXMLImportedParts) {
            IPart part = partHashMap.get(musicXMLImportedPart.getId());
            if (part == null) {
                throw new IMException("There is a <part> with id='" + musicXMLImportedPart.getId() + "' not defined in part-list");
            }

            //TODO voices, staves
            IVoice defaultVoice = coreAbstractFactory.createVoice(part, coreAbstractFactory.createId(), null);
            IStaff defaultStaff = coreAbstractFactory.createStaff(score, coreAbstractFactory.createId());
            for (IMusicXMLPartItem iMusicXMLPartItem: musicXMLImportedPart.getItems()) {
                ICoreItem[] subitems = iMusicXMLPartItem.getItems(); //TODO sacar los datos adicionales del MusicXMLNote como es la staff...
                for (ICoreItem coreItem: subitems) {
                    System.out.println("Adding " + coreItem);
                    score.add(defaultVoice, defaultStaff, coreItem);
                }
            }

        }

        return score;
    }
}
