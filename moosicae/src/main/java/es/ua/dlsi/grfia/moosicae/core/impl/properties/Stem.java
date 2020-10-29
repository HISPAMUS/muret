package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IStem;
import es.ua.dlsi.grfia.moosicae.core.properties.IStemDirection;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 29/10/2020
 */
public class Stem extends CoreProperty implements IStem {
    private final IStemDirection stemDirection;

    public Stem(IId id, @NotNull IStemDirection stemDirection) {
        super(id);
        this.stemDirection = stemDirection;
    }

    @Override
    public Stem clone() {
        return new Stem(null, stemDirection);
    }

    @Override
    public IStemDirection getStemDirection() {
        return stemDirection;
    }
}
