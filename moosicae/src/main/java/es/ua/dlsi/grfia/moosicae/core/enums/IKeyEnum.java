package es.ua.dlsi.grfia.moosicae.core.enums;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public interface IKeyEnum {
    EDiatonicPitches getDiatonicPitch();
    Optional<EAccidentalSymbols> getAccidentalSymbol();

}
