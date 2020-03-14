package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.IMException;

/**
 * The visual sign of chromatic alteration
 * @author David Rizo - drizo@dlsi.ua.es
 */
public enum EAccidentals {
    TRIPLE_FLAT (-3, "bbb"),
    DOUBLE_FLAT (-2, "bb"),
    FLAT (-1, "b"),
    NATURAL (0, "n"),
    SHARP (1, "#"),
    DOUBLE_SHARP (2, "x");
    /**
     * Alteration that the accidental adds
     */
    private final int alteration;
    /**
     * Name, print tempo
     */
    private final String name;

    /**
     * @return the alteration
     */
    public final int getAlteration() {
        return alteration;
    }

    EAccidentals(int alter, String aname) {
        this.alteration = alter;
        this.name = aname;
    }

    public static EAccidentals fromSemitonesAlteration(int value) throws IMException {
        switch (value) {
            case -3:
                return TRIPLE_FLAT;
            case -2:
                return DOUBLE_FLAT;
            case -1:
                return FLAT;
            case 0:
                return NATURAL;
            case 1:
                return SHARP;
            case 2:
                return DOUBLE_SHARP;
            default:
                throw new IMException("Invalid number of accidentals: " + value);
        }
    }

    @Override
    public String toString() {
        if (alteration == 0) {
            return "";
        } else {
            return this.name;
        }
    }

    public String getAbbrName() {
        return this.name;
    }


    public static EAccidentals fromName(String name) throws IMException {
        for (EAccidentals acc : EAccidentals.values()) {
            if (acc.name.equals(name)) {
                return acc;
            }

        }
        throw new IMException("Cannot find an accidental for " + name);
    }
}
