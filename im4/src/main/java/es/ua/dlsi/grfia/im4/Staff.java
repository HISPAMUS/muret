package es.ua.dlsi.grfia.im4;

import es.ua.dlsi.grfia.im4.io.IExporterContext;
import es.ua.dlsi.grfia.im4.io.IExporterVisitor;
import es.ua.dlsi.grfia.im4.utils.ArrangedList;

import java.util.Iterator;

public class Staff implements IStavesComponent, IContainer {
    ArrangedList<Layer> layers;

    @Override
    public Iterator<? extends IComponent> getChildrenIterator() {
        return layers.iterator();
    }


    @Override
    public void export(IExporterVisitor exporterVisitor, IExporterContext context) {
        exporterVisitor.export(this, context);
    }
}
