package es.ua.dlsi.grfia.moosicae.core;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IPitchClass {
    EDiatonicPitches getDiatonicPitch();
    Optional<EAccidentals> getAccidental();
}
