package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IMultimeasureRestCount;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class MultimeasureRestCount extends IntegerCoreCoreProperty implements IMultimeasureRestCount {
    public MultimeasureRestCount(@NotNull IId id, @NotNull Integer value) {
        super(id, value);
    }

    @Override
    public MultimeasureRestCount clone() {
        return new MultimeasureRestCount(getId(), value);
    }
}
