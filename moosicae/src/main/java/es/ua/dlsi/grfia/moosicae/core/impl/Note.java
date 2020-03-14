package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.INote;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Note extends DurationalSingle implements INote {
    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public DurationalSingle clone() {
        return null;
    }
}
