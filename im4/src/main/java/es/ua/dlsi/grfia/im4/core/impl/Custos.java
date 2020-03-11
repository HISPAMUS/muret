package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.ICustos;
import es.ua.dlsi.grfia.im4.core.IExporterVisitor;

public class Custos extends Pitched implements ICustos {
    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }
}
