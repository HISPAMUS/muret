package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.IEnumCoreProperty;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class IEnumPropertyBuilder<TEnum extends Enum<TEnum>, TCoreObject extends IEnumCoreProperty<TEnum>> extends CoreObjectBuilder<TCoreObject> {
    protected TEnum value;

    public IEnumPropertyBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public IEnumPropertyBuilder<TEnum, TCoreObject> from(TEnum value) {
        this.value = value;
        return this;
    }
}
