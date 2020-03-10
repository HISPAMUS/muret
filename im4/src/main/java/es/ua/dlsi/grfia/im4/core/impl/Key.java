package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IExportVisitor;
import es.ua.dlsi.grfia.im4.core.IKey;

public class Key implements IKey {
    @Override
    public <InputOutputType> void export(IExportVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }
}
