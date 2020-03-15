package es.ua.dlsi.grfia.moosicae.core.enums;

import es.ua.dlsi.grfia.moosicae.IMException;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public enum EDiatonicPitches {
    C (0,0),
    D (2,1),
    E (4,2),
    F (5,3),
    G (7,4),
    A (9,5),
    B (11,6);

    private final int semitonesFromC;
    private final int order; // from 0

    EDiatonicPitches(int semitonesFromC, int order) {
        this.semitonesFromC = semitonesFromC;
        this.order = order;
    }
    /**
     * @return the semitonesFromC
     */
    public final int getSemitonesFromC() {
        return semitonesFromC;
    }
    /**
     * @return the order (from C=0 to B=6. -1=rest)
     */
    public final int getOrder() {
        return order;
    }
    
    /**
     * @return the base7Name, 0 is the rest, 1 is C, 7 is B
     */
    public final int getBase7Name() {
        return order+1;
    }
    /**
     *
     * @param order
     * @return
     * @throws IMException
     */
    public static EDiatonicPitches noteFromOrder(int order) throws IMException {
        for (EDiatonicPitches nn : EDiatonicPitches.values()) {
            if (nn.getOrder() == order) {
                return nn;
            }
        }
        throw new IMException("Order " + order + " not found among the orders in diatonic pitches");
    }

    public static EDiatonicPitches noteFromName(String name) throws IMException {
        for (EDiatonicPitches acc : EDiatonicPitches.values()) {
            if (acc.name().equals(name)) {
                return acc;
            }

        }
        throw new IMException("Cannot find an diatonic pitch for " + name);
    }

    public static EDiatonicPitches noteFromName(char c) throws IMException {
        return noteFromName(Character.toString(c));
    }

}
