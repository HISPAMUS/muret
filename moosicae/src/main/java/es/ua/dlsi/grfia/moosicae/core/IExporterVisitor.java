package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.IMException;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IExporterVisitor<InputOutputType>  {
    void export(IClef clef, InputOutputType inputOutput) throws IMException;
    void export(IClefSign clefSign, InputOutputType inputOutput) throws IMException;
    void export(INote note, InputOutputType inputOutput) throws IMException;
    void export(IRest rest, InputOutputType inputOutput) throws IMException;
    void export(IMultimeasureRest mrest, InputOutputType inputOutput) throws IMException;
    void export(IFractionalTimeSignature meter, InputOutputType inputOutput) throws IMException;
    void export(ICutTime meter, InputOutputType inputOutputOutput) throws IMException;
    void export(ICommonTime meter, InputOutputType inputOutputOutput) throws IMException;
    void export(IChord chord, InputOutputType inputOutputOutput) throws IMException;
    void export(ICustos custos, InputOutputType inputOutputOutput) throws IMException;
    void export(IKey key, InputOutputType inputOutputOutput) throws IMException;
    void export(ICommonAlterationKey commonAlterationKey, InputOutputType inputOutputOutput) throws IMException;

    void export(IMode mode, InputOutputType inputOutput);

    void export(IKeySignature keySignature, InputOutputType inputOutputOutput) throws IMException;
    void export(IVoice voice, InputOutputType inputOutput) throws IMException;
    void export(IDiatonicPitch diatonicPitch, InputOutputType inputOutput) throws IMException;
    void export(IAccidentalSymbol accidental, InputOutputType inputOutput) throws IMException;
    void export(IAlterationDisplayType alterationDisplayType, InputOutputType inputOutput) throws IMException;
    void export(IAlteration alteration, InputOutputType inputOutput) throws IMException;
    void export(IPitchClass pitchClass, InputOutputType inputOutput) throws IMException;
    void export(IPitch pitch, InputOutputType inputOutput) throws IMException;
    void export(IDots dots, InputOutputType inputOutput) throws IMException;
    void export(IFigure figures, InputOutputType inputOutput) throws IMException;
    void export(IMetronomeMark metronomeMark, InputOutputType inputOutput) throws IMException;

    void export(IBarline barline, InputOutputType inputOutput) throws IMException;
    void export(IBarlineType barlineType, InputOutputType inputOutput) throws IMException;

    void export(IPageBeginning pageBeginning, InputOutputType inputOutput);
    void export(ISystemBeginning systemBeginning, InputOutputType inputOutput);
}
