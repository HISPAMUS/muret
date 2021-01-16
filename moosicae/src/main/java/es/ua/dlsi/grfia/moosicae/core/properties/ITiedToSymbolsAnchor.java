package es.ua.dlsi.grfia.moosicae.core.properties;

import es.ua.dlsi.grfia.moosicae.core.IVoicedItem;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/1/21
 */
public interface ITiedToSymbolsAnchor extends IHorizontalAnchor {
    IVoicedItem[] getLinkedTo();
}
