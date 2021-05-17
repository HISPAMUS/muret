package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.IPageBeginning;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class PageBeginning extends VoicedSingle implements IPageBeginning {
    public PageBeginning(IId id) {
        super(id);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportPageBeginning(this, inputOutput);
    }

    @Override
    public PageBeginning clone() {
        return new PageBeginning(null);
    }
}
