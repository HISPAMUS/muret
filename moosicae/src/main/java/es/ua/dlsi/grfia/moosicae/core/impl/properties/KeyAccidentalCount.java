package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IKeyAccidentalCount;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class KeyAccidentalCount extends IntegerCoreCoreProperty implements IKeyAccidentalCount {


    public KeyAccidentalCount(@NotNull IId id, @NotNull Integer value) {
        super(id, value);
    }

    @Override
    public KeyAccidentalCount clone() {
        return new KeyAccidentalCount(id, value);
    }
}
