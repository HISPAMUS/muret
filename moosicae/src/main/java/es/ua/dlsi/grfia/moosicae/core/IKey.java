package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IMode;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IKey extends INonDurational {
    IPitchClass getPitchClass();
    IMode getMode();
    IKeySignature getKeySignature();
}
