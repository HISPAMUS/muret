package es.ua.dlsi.grfia.moosicae.core.properties;

import es.ua.dlsi.grfia.moosicae.core.ICoreObject;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IPitchClass extends ICoreObject {
    IDiatonicPitch getDiatonicPitch();
    Optional<IAccidentalSymbol> getAccidental();
}
