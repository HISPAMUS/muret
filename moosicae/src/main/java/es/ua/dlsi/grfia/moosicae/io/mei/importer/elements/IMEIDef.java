package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.ICommonAlterationKeySignature;
import es.ua.dlsi.grfia.moosicae.core.IMeter;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public interface IMEIDef {
    Optional<ICommonAlterationKeySignature> getCommonAlterationKey();
    Optional<IMeter> getMeter();
}
