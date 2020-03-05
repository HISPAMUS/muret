package es.ua.dlsi.grfia.im4;

import es.ua.dlsi.grfia.im4.io.IExporterContext;
import es.ua.dlsi.grfia.im4.io.IExporterVisitor;

import java.util.Iterator;
import java.util.LinkedList;

public class Voice implements IContainer {
    LinkedList<ISymbol> symbols;

    @Override
    public Iterator<? extends IComponent> getChildrenIterator() {
        return symbols.iterator();
    }

    @Override
    public void export(IExporterVisitor exporterVisitor, IExporterContext context) {
        exporterVisitor.export(this, context);
    }
}
