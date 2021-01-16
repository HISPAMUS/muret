package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.IBooleanCoreProperty;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class IBooleanPropertyBuilder<T extends IBooleanCoreProperty> extends CoreObjectBuilder<T> {
    protected Boolean value;

    public IBooleanPropertyBuilder() {}

    public IBooleanPropertyBuilder<T> from(Boolean value) {
        this.value = value;
        return this;
    }
}
