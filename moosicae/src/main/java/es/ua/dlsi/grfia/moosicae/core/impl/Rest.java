package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IRest;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Rest extends DurationalSingle implements IRest {
    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public DurationalSingle clone() {
        return null;
    }
}
