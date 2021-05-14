package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IGraceNoteType;

import java.util.Optional;

/**
 * Decorator pattern
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 13/5/21
 */
public interface IGrace extends IPitchedDurationalSingle {
    IGraceNoteType getGraceNoteType();
    IPitchedDurationalSingle getDecoratesTo();
}
