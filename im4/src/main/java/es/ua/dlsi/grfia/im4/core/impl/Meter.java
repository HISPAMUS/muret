package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IExportVisitor;
import es.ua.dlsi.grfia.im4.core.IMeter;

public class Meter extends NonDurational implements IMeter {
    @Override
    public <InputOutputType> void export(IExportVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }
}
