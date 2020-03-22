package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IIntegerCoreProperty;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class IIntegerPropertyBuilder<T extends IIntegerCoreProperty> extends CoreObjectBuilder<T> {
    protected Integer value;

    public IIntegerPropertyBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
