package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.ICautionaryKeySignatureAccidentals;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;

import java.util.Optional;

/**
 * In the case of using a conventional key signature, the IConventionalKeySignature should be used.
 * If the key signature corresponds to a key, the IKey should be used rather than IKeySignature alone
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IKeySignature extends INonDurational {
    IPitchClass[] getPitchClasses();
    Optional<ICautionaryKeySignatureAccidentals> getCautionaryAccidentals();
}
