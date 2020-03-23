package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IKeySignature extends INonDurational {
    IPitchClass[] getPitchClasses();
}
