package es.ua.dlsi.grfia.moosicae.core;

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
    void export(EDiatonicPitches diatonicPitch, InputOutputType inputOutput);
    void export(EAccidentals accidental, InputOutputType inputOutput);
    void export(EAlterationDisplayType alterationDisplayType, InputOutputType inputOutput);
    void export(IAlteration alteration, InputOutputType inputOutput);
    void export(IPitchClass pitchClass, InputOutputType inputOutput);
    void export(IPitch pitch, InputOutputType inputOutput);
    void export(IDots dots, InputOutputType inputOutput);
    void export(EFigures figures, InputOutputType inputOutput);
}
