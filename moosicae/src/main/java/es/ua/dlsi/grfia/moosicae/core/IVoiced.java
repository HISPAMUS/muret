package es.ua.dlsi.grfia.moosicae.core;

public interface IVoiced {
    <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput);
}
