package es.ua.dlsi.grfia.moosicae.core;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IExporterVisitor<InputOutputType>  {
    void export(IClef clef, InputOutputType inputOutput);
    void export(INote note, InputOutputType inputOutput);
    void export(IRest rest, InputOutputType inputOutput);
    void export(IMultimeasureRest mrest, InputOutputType inputOutput);
    void export(IMeter meter, InputOutputType inputOutputOutput);
    void export(IChord chord, InputOutputType inputOutputOutput);
    void export(ICustos custos, InputOutputType inputOutputOutput);
    void export(IKey key, InputOutputType inputOutputOutput);
    void export(IKeySignature keySignature, InputOutputType inputOutputOutput);
    void export(IVoice exportVisitor, InputOutputType inputOutput);
}
