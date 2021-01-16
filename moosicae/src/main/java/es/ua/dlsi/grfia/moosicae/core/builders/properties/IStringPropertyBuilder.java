package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.IStringCoreProperty;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class IStringPropertyBuilder<T extends IStringCoreProperty> extends CoreObjectBuilder<T> {
    protected String value;

    public IStringPropertyBuilder<T> from(String value) {
        this.value = value;
        return this;
    }
}
