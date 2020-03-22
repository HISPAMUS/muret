package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.IKeyAccidentalCount;
import org.jetbrains.annotations.NotNull;

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
