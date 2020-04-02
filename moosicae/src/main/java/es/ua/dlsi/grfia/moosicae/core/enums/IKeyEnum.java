package es.ua.dlsi.grfia.moosicae.core.enums;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 01/04/2020
 */
public interface IKeyEnum {
    EDiatonicPitches getDiatonicPitch();

    Optional<EAccidentalSymbols> getPitchAccidentalSymbol();

    EModes getMode();
}
