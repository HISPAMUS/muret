package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IPitch;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface ICustos extends INonDurational, IPitched {
    IPitch getPitch();
}
