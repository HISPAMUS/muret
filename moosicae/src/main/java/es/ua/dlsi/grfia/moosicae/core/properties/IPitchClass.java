package es.ua.dlsi.grfia.moosicae.core.properties;

import es.ua.dlsi.grfia.moosicae.core.IMooObject;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IPitchClass extends IMooObject {
    IDiatonicPitch getDiatonicPitch();
    Optional<IAccidentalSymbol> getAccidental();
}
