package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.ICustos;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;

public class Custos extends Pitched implements ICustos {
    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }
}
