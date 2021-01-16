package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.IIntegerCoreProperty;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class IIntegerPropertyBuilder<T extends IIntegerCoreProperty> extends CoreObjectBuilder<T> {
    protected Integer value;

    public IIntegerPropertyBuilder() {}

    public IIntegerPropertyBuilder<T> from(Integer value) {
        this.value = value;
        return this;
    }
}
