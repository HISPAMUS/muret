package es.ua.dlsi.grfia.im4.core;

import es.ua.dlsi.grfia.im4.io.IExporterContext;
import es.ua.dlsi.grfia.im4.io.IExporterVisitor;

import java.util.Iterator;
import java.util.LinkedList;

public class StaffGroup implements IStavesComponent, IContainer {
    LinkedList<Staff> staves;

    @Override
    public Iterator<? extends IComponent> getChildrenIterator() {
        return staves.iterator();
    }


    @Override
    public void export(IExporterVisitor exporterVisitor, IExporterContext context) {
        exporterVisitor.export(this, context);
    }
}
