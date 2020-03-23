package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IMetronomeMarkValue;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class MetronomeMarkValue extends IntegerCoreCoreProperty implements IMetronomeMarkValue {
    public MetronomeMarkValue(@NotNull IId id, @NotNull Integer value) {
        super(id, value);
    }

    @Override
    public MetronomeMarkValue clone() {
        return new MetronomeMarkValue(getId(), value);
    }
}
