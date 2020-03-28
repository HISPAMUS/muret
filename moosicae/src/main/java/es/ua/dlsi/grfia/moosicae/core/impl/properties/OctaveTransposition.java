package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.builders.properties.IOctaveTransposition;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 28/03/2020
 */
public class OctaveTransposition extends IntegerCoreCoreProperty implements IOctaveTransposition {

    public OctaveTransposition(IId id, @NotNull Integer value) {
        super(id, value);
    }

    @Override
    public OctaveTransposition clone() {
        return new OctaveTransposition(null, value);
    }
}
