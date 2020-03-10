package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IExportVisitor;
import es.ua.dlsi.grfia.im4.core.INote;

public class Note extends DurationalSingle implements INote {
    @Override
    public <InputOutputType> void export(IExportVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }
}
