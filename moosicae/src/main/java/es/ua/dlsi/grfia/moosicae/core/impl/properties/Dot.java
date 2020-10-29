package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IDot;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Dot extends CoreProperty implements IDot {
    public Dot(IId id) {
        super(id);
    }
    @Override
    public Dot clone() {
        return new Dot(null);
    }

    @Override
    public String toString() {
        return "Dot";
    }
}
