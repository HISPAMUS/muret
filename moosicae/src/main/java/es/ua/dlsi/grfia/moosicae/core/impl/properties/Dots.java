package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IDots;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Dots extends IntegerCoreCoreProperty implements IDots {
    public Dots(IId id, @NotNull Integer count) {
        super(id, count);
    }
    @Override
    public Dots clone() {
        return new Dots(null, value);
    }

    @Override
    public String toString() {
        return "Dots{" +
                "count=" + value +
                '}';
    }
}
