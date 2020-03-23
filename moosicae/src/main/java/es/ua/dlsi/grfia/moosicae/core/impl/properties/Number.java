package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.INumber;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class Number extends IntegerCoreCoreProperty implements INumber {


    public Number(@NotNull IId id, @NotNull Integer value) {
        super(id, value);
    }

    @Override
    public Number clone() {
        return new Number(id, value);
    }
}
