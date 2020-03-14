package es.ua.dlsi.grfia.moosicae.core;

import java.util.Optional;

/**
 * The alteration applied to the diatonic pitch that comes from the key signature, by a previous note or an accidental sign
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IAlteration extends ISymbolProperty {
    EAccidentals getAccidental();
    Optional<EAlterationDisplayType> getAlterationDisplayType();
}
