package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IStem;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 29/10/2020
 */
public interface IStemmed extends IDurationalSingle {
    Optional<IStem> getStem();
}
