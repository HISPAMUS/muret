package es.ua.dlsi.grfia.moosicae.core.prototypes;

import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IKey;
import es.ua.dlsi.grfia.moosicae.core.IKeySignature;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;

import java.util.Arrays;
import java.util.Optional;


/**
 * Both the conventional and theoretical keys
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class Keys extends Prototypes<IKey> {
    /**
     * Instantiate it using PrototypesAbstractBuilder
     */
    Keys() {
        for (EConventionalKeys conventionalKey: EConventionalKeys.values()) {
            this.add(conventionalKey.name(), ICoreAbstractFactory.getInstance().createConventionalKey(null, conventionalKey, null));
        }

        for (ETheoreticalKeys theoreticalKey: ETheoreticalKeys.values()) {
            this.add(theoreticalKey.name(), ICoreAbstractFactory.getInstance().createTheoreticalKey(null, theoreticalKey, null));
        }
    }

    /**
     * It locates a existing key signature that has the sequence of the given pitch classes
     * @param pitchClasses
     * @return A copy of the prototype
     */
    public Optional<IKeySignature> findExistingKeySignature(IPitchClass[] pitchClasses) {
        for (IKey key: this.prototypes.values()) {
            Optional<IKeySignature> keySignature = key.getKeySignature();
            if (keySignature.isPresent()) {
                if (Arrays.deepEquals(keySignature.get().getPitchClasses(), pitchClasses)) {
                    return Optional.of((IKeySignature)keySignature.get().clone());
                }
            }
        }
        return Optional.empty();
    }
}
