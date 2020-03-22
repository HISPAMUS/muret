package es.ua.dlsi.grfia.moosicae.io.musicxml;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporter;

import javax.xml.stream.events.*;

/**
 * Use StAX for parsing
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 19/03/2020
 */
public class MusicXMLImporter extends XMLImporter<MusicXMLImporterVisitor> {
    public MusicXMLImporter(ICoreAbstractFactory abstractFactory) {
        super(abstractFactory, new MusicXMLImporterVisitor(abstractFactory));
        coreObjectBuilderSuppliers.add("score-part", IPartBuilder::new);
        coreObjectBuilderSuppliers.add("part-name", INameBuilder::new);
        coreObjectBuilderSuppliers.add("measure", IBarlineBuilder::new);

        coreObjectBuilderSuppliers.add("key", IKeyFromAccidentalCountBuilder::new);
        coreObjectBuilderSuppliers.add("mode", IModeBuilder::new);

        coreObjectBuilderSuppliers.add("note", INoteBuilder::new);
        coreObjectBuilderSuppliers.add("pitch", IPitchBuilder::new);
    }

    @Override
    protected boolean handleSpecialStartElement(StartElement startElement) {
        return false;
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
}
