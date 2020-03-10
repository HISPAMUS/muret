package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.ICustos;
import es.ua.dlsi.grfia.im4.core.IExportVisitor;

public class Custos extends Pitched implements ICustos {
    @Override
    public <InputOutputType> void export(IExportVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }
}
