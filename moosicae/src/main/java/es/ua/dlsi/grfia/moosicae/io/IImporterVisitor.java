package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.core.builders.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IImporterVisitor<InputOutputType>  {
    void importKeySignature(IKeySignatureBuilder iKeySignatureBuilder, InputOutputType inputOutputType);

    void importPartBuilder(IPartBuilder partBuilder, InputOutputType inputOutputType);

    void importAlterationDisplayType(IAlterationDisplayTypeBuilder iAlterationDisplayTypeBuilder, InputOutputType inputOutputType);

    void importMeterSymbol(IMeterSymbolBuilder iMeterSymbolBuilder, InputOutputType inputOutputType);

    void importCustos(ICustosBuilder iCustosBuilder, InputOutputType inputOutputType);

    void importMensuration(IMensurationBuilder iMensurationBuilder, InputOutputType inputOutputType);

    void importMode(IModeBuilder iModeBuilder, InputOutputType inputOutputType);

    void importClefSign(IClefSignBuilder iClefSignBuilder, InputOutputType inputOutputType);

    void importClef(IClefBuilder iClefBuilder, InputOutputType inputOutputType);

    void importPitchClass(IPitchClassBuilder iPitchClassBuilder, InputOutputType inputOutputType);

    void importAccidentalSymbol(IAccidentalSymbolBuilder iAccidentalSymbolBuilder, InputOutputType inputOutputType);

    void importDiatonicPitch(IDiatonicPitchBuilder iDiatonicPitchBuilder, InputOutputType inputOutputType);

    void importPitch(IPitchBuilder iPitchBuilder, InputOutputType inputOutputType);

    void importAlteration(IAlterationBuilder iAlterationBuilder, InputOutputType inputOutputType);

    void importBarlineType(IBarlineTypeBuilder iBarlineTypeBuilder, InputOutputType inputOutputType);

    void importRest(IRestBuilder iRestBuilder, InputOutputType inputOutputType);

    void importNote(INoteBuilder iNoteBuilder, InputOutputType inputOutputType);

    void importMutimeasureRest(IMultimeasureRestBuilder iMultimeasureRestBuilder, InputOutputType inputOutputType);

    void importKeyFromAccidentalCount(IKeyFromAccidentalCountBuilder iKeyFromAccidentalCountBuilder, InputOutputType inputOutputType);

    void importMetronome(IMetronomeMarkBuilder iMetronomeMarkBuilder, InputOutputType inputOutputType);

    void importFigure(IFigureBuilder iFigureBuilder, InputOutputType inputOutputType);

    void importBarline(IBarlineBuilder iBarlineBuilder, InputOutputType inputOutputType);

    void importFractionalTimeSignature(IFractionalTimeSignatureBuilder iFractionalTimeSignatureBuilder, InputOutputType inputOutputType);

    void importKey(IKeyBuilder iKeyBuilder, InputOutputType inputOutputType);

    void importNotationType(INotationTypeBuilder iNotationTypeBuilder, InputOutputType inputOutputType);

    void importChord(IChordBuilder iChordBuilder, InputOutputType inputOutputType);

    void importName(INameBuilder iNameBuilder, InputOutputType inputOutputType);

    void importKeyAccidentalCount(IKeyAccidentalCountBuilder iKeyAccidentalCountBuilder, InputOutputType inputOutputType);
}
