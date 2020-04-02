package es.ua.dlsi.grfia.moosicae.core.utils;

import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 02/04/2020
 */
public interface ICircleOfFifths {
    /**
     * Order of sharp alterations F, C, G, D, A, E, B
     */
    EDiatonicPitches KEY_SIGNATURE_STAFF_SHARPS[] = { EDiatonicPitches.F, EDiatonicPitches.C, EDiatonicPitches.G, EDiatonicPitches.D,
            EDiatonicPitches.A, EDiatonicPitches.E, EDiatonicPitches.B };
    /**
     * Order of flat alterations B, E, A, D, G, C, F
     */
    EDiatonicPitches KEY_SIGNATURE_STAFF_FLATS[] = { EDiatonicPitches.B, EDiatonicPitches.E, EDiatonicPitches.A, EDiatonicPitches.D,
            EDiatonicPitches.G, EDiatonicPitches.C, EDiatonicPitches.F }; // the inverse of sharps
}
