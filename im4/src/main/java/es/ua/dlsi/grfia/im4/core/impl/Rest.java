package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IExporterVisitor;
import es.ua.dlsi.grfia.im4.core.IRest;

public class Rest extends DurationalSingle implements IRest {
    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }
}
