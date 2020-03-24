package es.ua.dlsi.grfia.moosicae.io.musicxml.importer;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.*;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.*;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;
import es.ua.dlsi.grfia.moosicae.io.musicxml.MusicXMLExporterVisitor;
import es.ua.dlsi.grfia.moosicae.io.musicxml.MusicXMLPartBuilder;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterVisitorParam;

import javax.xml.stream.events.Attribute;
import java.util.Iterator;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class MusicXMLImporterVisitor implements IImporterVisitor<XMLImporterVisitorParam> {
    private final ICoreAbstractFactory coreAbstractFactory;
    private Integer currentDivisions;

    public MusicXMLImporterVisitor(ICoreAbstractFactory coreAbstractFactory) {
        this.coreAbstractFactory = coreAbstractFactory;
    }

    @Override
    public void importKeySignature(IKeySignatureBuilder iKeySignatureBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importPartBuilder(IPartBuilder partBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {
        if (xmlImporterVisitorParam.getAttributeIterator().isPresent()) {
            for (Iterator<Attribute> iterator = xmlImporterVisitorParam.getAttributeIterator().get(); iterator.hasNext(); ) {
                Attribute attribute = iterator.next();
                switch (attribute.getName().getLocalPart()) {
                    case "id":
                        partBuilder.from(coreAbstractFactory.createId(attribute.getValue()));
                        break;
                }
            }
        }
    }

    @Override
    public void importAlterationDisplayType(IAlterationDisplayTypeBuilder iAlterationDisplayTypeBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importCustos(ICustosBuilder iCustosBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importMensuration(IMensurationBuilder iMensurationBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importMode(IModeBuilder iModeBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {
        if (xmlImporterVisitorParam.getCharacters().isPresent()) {
            iModeBuilder.from(EModes.valueOf(xmlImporterVisitorParam.getCharacters().get()));
        }
    }

    @Override
    public void importClefSign(IClefSignBuilder iClefSignBuilder, XMLImporterVisitorParam xmlImporterVisitorParam)  {
        if (xmlImporterVisitorParam.getCharacters().isPresent()) {
            iClefSignBuilder.from(EClefSigns.valueOf(xmlImporterVisitorParam.getCharacters().get()));
        }
    }

    @Override
    public void importClef(IClefBuilder iClefBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importPitchClass(IPitchClassBuilder iPitchClassBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importAccidentalSymbol(IAccidentalSymbolBuilder iAccidentalSymbolBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) throws IMException {
    }

    @Override
    public void importDiatonicPitch(IDiatonicPitchBuilder iDiatonicPitchBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {
        if (xmlImporterVisitorParam.getCharacters().isPresent()) {
            iDiatonicPitchBuilder.from(EDiatonicPitches.valueOf(xmlImporterVisitorParam.getCharacters().get()));
        }
    }

    @Override
    public void importPitch(IPitchBuilder iPitchBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importAlteration(IAlterationBuilder iAlterationBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) throws IMException {
        if (xmlImporterVisitorParam.getCharacters().isPresent()) {
            iAlterationBuilder.from(EAccidentalSymbols.fromSemitonesAlteration(Integer.parseInt(xmlImporterVisitorParam.getCharacters().get())));
        }

    }

    @Override
    public void importBarlineType(IBarlineTypeBuilder iBarlineTypeBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importRest(IRestBuilder iRestBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importNote(INoteBuilder iNoteBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {
    }

    @Override
    public void importMutimeasureRest(IMultimeasureRestBuilder iMultimeasureRestBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importKeyFromAccidentalCount(IKeyFromAccidentalCountBuilder iKeyFromAccidentalCountBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importMetronome(IMetronomeMarkBuilder iMetronomeMarkBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importFigure(IFigureBuilder iFigureBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) throws IMException {
        if (xmlImporterVisitorParam.getCharacters().isPresent()) {
            int meterUnit = Integer.parseInt(xmlImporterVisitorParam.getCharacters().get()) / MusicXMLExporterVisitor.MAX_DUR;
            //TODO - meter unit ¿cuando tiene puntillos? - mejor buscar type... --- ¿es obligatorio type?
            EFigures figure = EFigures.findMeterUnit(meterUnit, ENotationTypes.eModern);
            iFigureBuilder.from(figure);
        }
    }

    @Override
    public void importBarline(IBarlineBuilder iBarlineBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {
        if (xmlImporterVisitorParam.getAttributeIterator().isPresent()) {
            for (Iterator<Attribute> iterator = xmlImporterVisitorParam.getAttributeIterator().get(); iterator.hasNext(); ) {
                Attribute attribute = iterator.next();
                switch (attribute.getName().getLocalPart()) {
                    case "number":
                        iBarlineBuilder.from(coreAbstractFactory.createNumber(coreAbstractFactory.createId(), Integer.parseInt(attribute.getValue())));
                        break;
                }
            }
        }
    }

    @Override
    public void importFractionalTimeSignature(IFractionalTimeSignatureBuilder iFractionalTimeSignatureBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) throws IMException {
        if (xmlImporterVisitorParam.getAttributeIterator().isPresent()) {
            for (Iterator<Attribute> iterator = xmlImporterVisitorParam.getAttributeIterator().get(); iterator.hasNext(); ) {
                Attribute attribute = iterator.next();
                switch (attribute.getName().getLocalPart()) {
                    case "symbol":
                        switch (attribute.getValue()) {
                            case "common":
                                iFractionalTimeSignatureBuilder.from(ETimeSignatureSymbols.common);
                                break;
                            case "cut":
                                iFractionalTimeSignatureBuilder.from(ETimeSignatureSymbols.cut);
                                break;
                            default:
                                throw new IMException("Unkown time signature symbol: '" + attribute.getValue() + "'");
                        }
                        break;
                }
            }
        }
    }

    @Override
    public void importKey(IKeyBuilder iKeyBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importNotationType(INotationTypeBuilder iNotationTypeBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importChord(IChordBuilder iChordBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importName(INameBuilder iNameBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {
        if (xmlImporterVisitorParam.getCharacters().isPresent()) {
            iNameBuilder.from(xmlImporterVisitorParam.getCharacters().get());
        }
    }

    @Override
    public void importKeyAccidentalCount(IKeyAccidentalCountBuilder iKeyAccidentalCountBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {
    }


    @Override
    public void importTimeSignatureNumerator(ITimeSignatureNumeratorBuilder iTimeSignatureNumeratorBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {
        if (xmlImporterVisitorParam.getCharacters().isPresent()) {
            iTimeSignatureNumeratorBuilder.from(Integer.parseInt(xmlImporterVisitorParam.getCharacters().get()));
        }
    }

    @Override
    public void importNumber(INumberBuilder iNumberBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importTimeSignatureDenominator(ITimeSignatureDenominatorBuilder iTimeSignatureDenominatorBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {
        if (xmlImporterVisitorParam.getCharacters().isPresent()) {
            iTimeSignatureDenominatorBuilder.from(Integer.parseInt(xmlImporterVisitorParam.getCharacters().get()));
        }
    }

    @Override
    public void importOctave(IOctaveBuilder iOctaveBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {
        if (xmlImporterVisitorParam.getCharacters().isPresent()) {
            iOctaveBuilder.from(Integer.parseInt(xmlImporterVisitorParam.getCharacters().get()));
        }
    }

    @Override
    public void importMetronomeMarkValue(IIMetronomeMarkValueBuilder iiMetronomeMarkValueBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importMultimeasureRestCount(IMultimeasureRestCountBuilder iMultimeasureRestCountBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importDots(IDotsBuilder iDotsBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importClefLine(IClefLineBuilder iClefLineBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {
        if (xmlImporterVisitorParam.getCharacters().isPresent()) {
            iClefLineBuilder.from(Integer.parseInt(xmlImporterVisitorParam.getCharacters().get()));
        }
    }

    public void setDivisions(int divisions) {
        this.currentDivisions = divisions;
    }

    public void importPartContent(MusicXMLPartBuilder musicXMLPartBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    public void importMusicXMLPartBuilder(MusicXMLPartBuilder musicXMLPartBuilder, XMLImporterVisitorParam xmlImporterVisitorParam) {
        if (xmlImporterVisitorParam.getAttributeIterator().isPresent()) {
            for (Iterator<Attribute> iterator = xmlImporterVisitorParam.getAttributeIterator().get(); iterator.hasNext(); ) {
                Attribute attribute = iterator.next();
                switch (attribute.getName().getLocalPart()) {
                    case "id":
                        musicXMLPartBuilder.from(coreAbstractFactory.createId(attribute.getValue()));
                        break;
                }
            }
        }
    }
}
