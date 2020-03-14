package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.EFigures;
import es.ua.dlsi.grfia.moosicae.core.IMultimeasureRest;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class MultimeasureRest extends DurationalComposite implements IMultimeasureRest {
    @Override
    public EFigures getFigure() {
        return null;
    }

    @Override
    public MultimeasureRest clone() {
        return null;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }
}
