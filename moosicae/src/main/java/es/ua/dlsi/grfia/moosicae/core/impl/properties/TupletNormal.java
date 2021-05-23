package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.builders.properties.ITupletNormal;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/05/2021
 */
public class TupletNormal extends IntegerCoreCoreProperty implements ITupletNormal {

    public TupletNormal(IId id, @NotNull Integer value) {
        super(id, value);
    }

    @Override
    public TupletNormal clone() {
        return new TupletNormal(null, value);
    }
}
