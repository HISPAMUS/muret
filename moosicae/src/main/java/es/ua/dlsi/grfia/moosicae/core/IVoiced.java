package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IVoiced extends ICoreObject {
    <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException;
}
