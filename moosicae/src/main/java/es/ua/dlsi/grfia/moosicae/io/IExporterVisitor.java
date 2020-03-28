package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IOctaveTransposition;
import es.ua.dlsi.grfia.moosicae.core.properties.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IExporterVisitor<InputOutputType>  {
    void exportClef(IClef clef, InputOutputType inputOutput) throws IMException;
    void exportClefSign(IClefSign clefSign, InputOutputType inputOutput) throws IMException;
    void exportClefOctaveTransposition(IOctaveTransposition octaveTransposition, InputOutputType inputOutput) throws IMException;
    void exportNote(INote note, InputOutputType inputOutput) throws IMException;
    void exportRest(IRest rest, InputOutputType inputOutput) throws IMException;
    void exportMultimeasureRest(IMultimeasureRest mrest, InputOutputType inputOutput) throws IMException;
    void exportFractionalTimeSignature(IFractionalTimeSignature meter, InputOutputType inputOutput) throws IMException;
    void exportCutTime(ICutTime meter, InputOutputType inputOutputOutput) throws IMException;
    void exportCommonTime(ICommonTime meter, InputOutputType inputOutputOutput) throws IMException;
    void exportChord(IChord chord, InputOutputType inputOutputOutput) throws IMException;
    void exportCustos(ICustos custos, InputOutputType inputOutputOutput) throws IMException;
    void exportKey(IKey key, InputOutputType inputOutputOutput) throws IMException;
    void exportCommonAlterationKey(ICommonAlterationKey commonAlterationKey, InputOutputType inputOutputOutput) throws IMException;

    void exportMode(IMode mode, InputOutputType inputOutput);

    void exportKeySignature(IKeySignature keySignature, InputOutputType inputOutputOutput) throws IMException;
    void exportVoice(IVoice voice, InputOutputType inputOutput) throws IMException;
    void exportDiatonicPitch(IDiatonicPitch diatonicPitch, InputOutputType inputOutput) throws IMException;
    void exportAccidentalSymbol(IAccidentalSymbol accidental, InputOutputType inputOutput) throws IMException;
    void exportAlterationDisplayType(IAlterationDisplayType alterationDisplayType, InputOutputType inputOutput) throws IMException;
    void exportAlteration(IAlteration alteration, InputOutputType inputOutput) throws IMException;
    void exportPitchClass(IPitchClass pitchClass, InputOutputType inputOutput) throws IMException;
    void exportPitch(IPitch pitch, InputOutputType inputOutput) throws IMException;
    void exportNoteHead(INoteHead noteHead, InputOutputType inputOutput) throws IMException;
    void exportDots(IDots dots, InputOutputType inputOutput) throws IMException;
    void exportOctave(IOctave octave, InputOutputType inputOutput) throws IMException;
    void exportFigure(IFigure figures, InputOutputType inputOutput) throws IMException;
    void exportMetronomeMark(IMetronomeMark metronomeMark, InputOutputType inputOutput) throws IMException;

    void exportBarline(IBarline barline, InputOutputType inputOutput) throws IMException;
    void exportBarlineType(IBarlineType barlineType, InputOutputType inputOutput) throws IMException;

    void exportPageBeginning(IPageBeginning pageBeginning, InputOutputType inputOutput);
    void exportSystemBeginning(ISystemBeginning systemBeginning, InputOutputType inputOutput);
}
