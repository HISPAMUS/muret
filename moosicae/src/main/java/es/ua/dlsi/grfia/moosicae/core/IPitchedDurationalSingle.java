package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IGraceNoteType;
import es.ua.dlsi.grfia.moosicae.core.properties.IStem;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 13/5/21
 */
public interface IPitchedDurationalSingle extends IDurationalSingle, IPitched {
    Optional<IStem> getStem();
    Optional<IGraceNoteType> getGraceNoteType();
}
