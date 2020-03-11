package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IExporterVisitor;
import es.ua.dlsi.grfia.im4.core.IFigure;
import es.ua.dlsi.grfia.im4.core.IMultimeasureRest;

public class MultimeasureRest extends DurationalComposite implements IMultimeasureRest {
    @Override
    public IFigure getFigure() {
        return null;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }
}
