package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IDurational;
import es.ua.dlsi.grfia.moosicae.core.IDurationalComposite;
import es.ua.dlsi.grfia.moosicae.core.IMixedMeter;

import java.util.LinkedList;
import java.util.List;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class IDurationalCompositeBuilder<T extends IDurationalComposite> extends CoreObjectBuilder<T> {
    protected List<IDurational> children;

    public IDurationalCompositeBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
        children = new LinkedList<>();
    }

    public IDurationalCompositeBuilder add(IDurational child) {
        this.children.add(child);
        return this;
    }
}
