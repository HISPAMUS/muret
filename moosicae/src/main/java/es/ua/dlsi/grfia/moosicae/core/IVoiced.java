package es.ua.dlsi.grfia.moosicae.core;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IVoiced extends ICoreObject {
    <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput);
}
