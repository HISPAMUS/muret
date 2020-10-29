package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.ICoreProperty;
import es.ua.dlsi.grfia.moosicae.core.properties.IDot;
import es.ua.dlsi.grfia.moosicae.core.properties.IDots;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Dots extends CoreProperty implements IDots {
    IDot[] dots;

    public Dots(IId id, @NotNull IDot [] dots) {
        super(id);
        if (dots.length == 0) {
            throw new IllegalArgumentException("The number of dots should be > 0");
        }
        this.dots = dots.clone();
    }
    @Override
    public Dots clone() {
        return new Dots(null, this.dots);
    }

    @Override
    public String toString() {
        return "Dots{" +
                "count=" + this.dots.length +
                '}';
    }

    @Override
    public IDot[] getDots() {
        return dots;
    }
}
