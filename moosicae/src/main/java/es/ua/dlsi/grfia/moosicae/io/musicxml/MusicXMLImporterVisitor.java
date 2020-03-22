package es.ua.dlsi.grfia.moosicae.io.musicxml;

import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EModes;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;
import es.ua.dlsi.grfia.moosicae.io.xml.IXMLImporterVisitorParam;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterVisitorAtrributes;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterVisitorCharacters;

import javax.xml.stream.events.Attribute;
import java.util.Iterator;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class MusicXMLImporterVisitor implements IImporterVisitor<IXMLImporterVisitorParam> {
    private final ICoreAbstractFactory coreAbstractFactory;
    private Integer currentDivisions;

    public MusicXMLImporterVisitor(ICoreAbstractFactory coreAbstractFactory) {
        this.coreAbstractFactory = coreAbstractFactory;
    }

    @Override
    public void importKeySignature(IKeySignatureBuilder iKeySignatureBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importPartBuilder(IPartBuilder partBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {
        if (xmlImporterVisitorParam instanceof XMLImporterVisitorAtrributes) {
            for (Iterator<Attribute> iterator = ((XMLImporterVisitorAtrributes) xmlImporterVisitorParam).getAttributeIterator(); iterator.hasNext(); ) {
                Attribute attribute = iterator.next();
                switch (attribute.getName().getLocalPart()) {
                    case "id":
                        partBuilder.setId(coreAbstractFactory.createId(attribute.getValue()));
                        break;
                }
            }
        }
    }

    @Override
    public void importAlterationDisplayType(IAlterationDisplayTypeBuilder iAlterationDisplayTypeBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importMeterSymbol(IMeterSymbolBuilder iMeterSymbolBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importCustos(ICustosBuilder iCustosBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importMensuration(IMensurationBuilder iMensurationBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importMode(IModeBuilder iModeBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {
        if (xmlImporterVisitorParam instanceof XMLImporterVisitorCharacters) {
            iModeBuilder.setMode(EModes.valueOf(((XMLImporterVisitorCharacters)xmlImporterVisitorParam).getCharacters().toLowerCase()));
        }
    }

    @Override
    public void importClefSign(IClefSignBuilder iClefSignBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importClef(IClefBuilder iClefBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importPitchClass(IPitchClassBuilder iPitchClassBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importAccidentalSymbol(IAccidentalSymbolBuilder iAccidentalSymbolBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importDiatonicPitch(IDiatonicPitchBuilder iDiatonicPitchBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importPitch(IPitchBuilder iPitchBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importAlteration(IAlterationBuilder iAlterationBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importBarlineType(IBarlineTypeBuilder iBarlineTypeBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importRest(IRestBuilder iRestBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importNote(INoteBuilder iNoteBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importMutimeasureRest(IMultimeasureRestBuilder iMultimeasureRestBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importKeyFromAccidentalCount(IKeyFromAccidentalCountBuilder iKeyFromAccidentalCountBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importMetronome(IMetronomeMarkBuilder iMetronomeMarkBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importFigure(IFigureBuilder iFigureBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importBarline(IBarlineBuilder iBarlineBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {
        if (xmlImporterVisitorParam instanceof XMLImporterVisitorAtrributes) {
            for (Iterator<Attribute> iterator = ((XMLImporterVisitorAtrributes) xmlImporterVisitorParam).getAttributeIterator(); iterator.hasNext(); ) {
                Attribute attribute = iterator.next();
                switch (attribute.getName().getLocalPart()) {
                    case "number":
                        iBarlineBuilder.setBarNumber(coreAbstractFactory.createNumber(coreAbstractFactory.createId(), Integer.parseInt(attribute.getValue())));
                        break;
                }
            }
        }
    }

    @Override
    public void importFractionalTimeSignature(IFractionalTimeSignatureBuilder iFractionalTimeSignatureBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importKey(IKeyBuilder iKeyBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importNotationType(INotationTypeBuilder iNotationTypeBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importChord(IChordBuilder iChordBuilder, IXMLImporterVisitorParam xmlImporterVisitorParam) {

    }

    @Override
    public void importName(INameBuilder iNameBuilder, IXMLImporterVisitorParam ixmlImporterVisitorParam) {
        if (ixmlImporterVisitorParam instanceof XMLImporterVisitorCharacters) {
            iNameBuilder.setValue(((XMLImporterVisitorCharacters)ixmlImporterVisitorParam).getCharacters());
        }
    }

    @Override
    public void importKeyAccidentalCount(IKeyAccidentalCountBuilder iKeyAccidentalCountBuilder, IXMLImporterVisitorParam ixmlImporterVisitorParam) {
    }

    public void setDivisions(int divisions) {
        this.currentDivisions = divisions;
    }
}
