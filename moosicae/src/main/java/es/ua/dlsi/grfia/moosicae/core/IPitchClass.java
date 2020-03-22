package es.ua.dlsi.grfia.moosicae.core;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IPitchClass extends ICoreObject {
    IDiatonicPitch getDiatonicPitch();
    Optional<IAccidentalCore> getAccidental();
}
