package es.ua.dlsi.grfia.im4.core;

import es.ua.dlsi.grfia.im4.io.IExporterContext;
import es.ua.dlsi.grfia.im4.io.IExporterVisitor;

import java.util.Iterator;
import java.util.LinkedList;

public class Part implements IContainer {
    LinkedList<Voice> voices;

    @Override
    public Iterator<? extends IComponent> getChildrenIterator() {
        return voices.iterator();
    }


    @Override
    public void export(IExporterVisitor exporterVisitor, IExporterContext context) {
        exporterVisitor.export(this, context);
    }
}
