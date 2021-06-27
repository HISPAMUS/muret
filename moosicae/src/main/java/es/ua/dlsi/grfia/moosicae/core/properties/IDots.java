package es.ua.dlsi.grfia.moosicae.core.properties;

import es.ua.dlsi.grfia.moosicae.core.ICoreProperty;

/**
 * The sequence of dots after a note or rest
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IDots extends ICoreProperty {
    IDot[] getDots();
}