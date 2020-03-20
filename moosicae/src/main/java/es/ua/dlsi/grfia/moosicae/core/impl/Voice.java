package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IVoice;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;

import java.util.LinkedList;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Voice implements IVoice {
    private final LinkedList<IVoiced> items;

    public Voice() {
        items = new LinkedList<>();
    }

    @Override
    public IVoiced[] getItems() {
        return items.toArray(new IVoiced[items.size()]);
    }

    @Override
    public void addItem(IVoiced item) {
        this.items.add(item);
    }

    @Override
    public IVoiced clone() {
        return null;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.export(this, inputOutput);
    }
}
