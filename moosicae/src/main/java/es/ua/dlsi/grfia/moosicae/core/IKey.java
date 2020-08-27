package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IMode;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IKey extends INonDurational {
    IPitchClass getPitchClass();
    IMode getMode();
    Optional<IKeySignature> getKeySignature();
}
