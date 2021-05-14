package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IStem;

import java.util.Optional;

/**
 * Decarator pattern - it just adds the stem if there is a specific information about it such as its direction
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 29/10/2020
 */
public interface IStemmed extends IPitchedDurationalSingle {
    IStem getStem();
    IPitchedDurationalSingle getDecoratesTo();
}
