package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.builders.properties.IOctaveTransposition;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.ITupletActual;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/05/2021
 */
public class TupletActual extends IntegerCoreCoreProperty implements ITupletActual {

    public TupletActual(IId id, @NotNull Integer value) {
        super(id, value);
    }

    @Override
    public TupletActual clone() {
        return new TupletActual(null, value);
    }
}
