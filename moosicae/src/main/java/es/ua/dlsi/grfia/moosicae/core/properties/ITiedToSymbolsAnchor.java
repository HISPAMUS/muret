package es.ua.dlsi.grfia.moosicae.core.properties;

import es.ua.dlsi.grfia.moosicae.core.IVoicedSingle;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/1/21
 */
public interface ITiedToSymbolsAnchor extends IHorizontalAnchor {
    IVoicedSingle[] getLinkedTo();
}
