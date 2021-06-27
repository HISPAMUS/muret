package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IOctave;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class Octave extends IntegerCoreCoreProperty implements IOctave {

    public Octave(IId id, @NotNull Integer value) {
        super(id, value);
    }

    @Override
    public Octave clone() {
        return new Octave(null, value);
    }

    @Override
    public String toString() {
        return "Octave{" +
                "number=" + value +
                '}';
    }
}