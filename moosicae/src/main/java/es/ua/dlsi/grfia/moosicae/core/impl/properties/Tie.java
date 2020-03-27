package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.ITie;
import es.ua.dlsi.grfia.moosicae.core.properties.ITieOrientation;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class Tie extends CoreProperty implements ITie {
    private ITieOrientation tieOrientation;

    public Tie(IId id, ITieOrientation tieOrientation) {
        super(id);
        this.tieOrientation = tieOrientation;
    }

    @Override
    public CoreProperty clone() {
        return new Tie(null, tieOrientation);
    }


    @Override
    public Optional<ITieOrientation> getOrientation() {
        return Optional.ofNullable(tieOrientation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tie)) return false;

        Tie tie = (Tie) o;

        return tieOrientation != null ? tieOrientation.equals(tie.tieOrientation) : tie.tieOrientation == null;
    }

    @Override
    public int hashCode() {
        return tieOrientation != null ? tieOrientation.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Tie{" +
                "tieOrientation=" + tieOrientation +
                "} " + super.toString();
    }
}
