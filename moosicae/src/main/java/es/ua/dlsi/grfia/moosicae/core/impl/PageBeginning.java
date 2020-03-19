package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IPageBeginning;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class PageBeginning implements IPageBeginning {
    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public PageBeginning clone() {
        return new PageBeginning();
    }
}
