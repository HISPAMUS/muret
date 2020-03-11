package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IExporterVisitor;
import es.ua.dlsi.grfia.im4.core.IVoice;
import es.ua.dlsi.grfia.im4.core.IVoiced;

import java.util.LinkedList;

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
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }
}
