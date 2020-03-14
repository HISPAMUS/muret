package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Meter extends NonDurational implements IMeter {
    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public NonDurational clone() {
        return null;
    }
}
