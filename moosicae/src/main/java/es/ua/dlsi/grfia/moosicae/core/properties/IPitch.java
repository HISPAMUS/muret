package es.ua.dlsi.grfia.moosicae.core.properties;

import es.ua.dlsi.grfia.moosicae.core.ICoreProperty;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public interface IPitch extends ICoreProperty {
    IOctave getOctave();
    Optional<IAlteration> getAlteration();
    IDiatonicPitch getDiatonicPitch();
}
