package es.ua.dlsi.grfia.im4.core;

public interface IVoiced {
    <InputOutputType> void export(IExportVisitor exportVisitor, InputOutputType inputOutput);
}
