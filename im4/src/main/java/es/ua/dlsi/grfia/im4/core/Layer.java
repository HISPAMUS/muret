package es.ua.dlsi.grfia.im4.core;

import es.ua.dlsi.grfia.im4.io.IExporterContext;
import es.ua.dlsi.grfia.im4.io.IExporterVisitor;

import java.util.Iterator;

/**
 * Elements will be traversed using an iterator of those ILayerComponent symbols
 */
public class Layer implements IContainer {
    @Override
    public Iterator<? extends IComponent> getChildrenIterator() {
        return null;
    }


    @Override
    public void export(IExporterVisitor exporterVisitor, IExporterContext context) {
        exporterVisitor.export(this, context);
    }
}
