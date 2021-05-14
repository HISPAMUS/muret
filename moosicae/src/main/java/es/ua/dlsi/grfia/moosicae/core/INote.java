package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IGraceNoteType;
import es.ua.dlsi.grfia.moosicae.core.properties.INoteHead;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface INote extends IPitchedDurationalSingle {
    INoteHead getNoteHead();
}
