package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMetronomeMark;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IExporterVisitor<InputOutputType>  {
    void export(IClef clef, InputOutputType inputOutput);
    void export(INote note, InputOutputType inputOutput);
    void export(IRest rest, InputOutputType inputOutput);
    void export(IMultimeasureRest mrest, InputOutputType inputOutput);
    void export(IFractionalTimeSignature meter, InputOutputType inputOutput);
    void export(ICutTime meter, InputOutputType inputOutputOutput);
    void export(ICommonTime meter, InputOutputType inputOutputOutput);
    void export(IChord chord, InputOutputType inputOutputOutput);
    void export(ICustos custos, InputOutputType inputOutputOutput);
    void export(IKey key, InputOutputType inputOutputOutput);
    void export(IKeySignature keySignature, InputOutputType inputOutputOutput);
    void export(IVoice voice, InputOutputType inputOutput);
    void export(IDiatonicPitch diatonicPitch, InputOutputType inputOutput);
    void export(IAccidentalSymbol accidental, InputOutputType inputOutput);
    void export(IAlterationDisplayType alterationDisplayType, InputOutputType inputOutput);
    void export(IAlteration alteration, InputOutputType inputOutput);
    void export(IPitchClass pitchClass, InputOutputType inputOutput);
    void export(IPitch pitch, InputOutputType inputOutput);
    void export(IDots dots, InputOutputType inputOutput);
    void export(IFigure figures, InputOutputType inputOutput);
    void export(IMetronomeMark metronomeMark, InputOutputType inputOutput) throws IMException;
}
