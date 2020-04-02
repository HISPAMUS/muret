package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.IConventionalKeySignature;
import es.ua.dlsi.grfia.moosicae.core.IKey;
import es.ua.dlsi.grfia.moosicae.core.IMeter;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public interface IMEIDef {
    Optional<IKey> getKey();
    Optional<IConventionalKeySignature> getConventionalKeySignature();
    Optional<IMeter> getMeter();
}
