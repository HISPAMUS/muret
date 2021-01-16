package es.ua.dlsi.grfia.moosicae.core.properties;

import es.ua.dlsi.grfia.moosicae.core.IVoicedItem;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/1/21
 */
public interface ITiedToSymbolAnchor extends IHorizontalAnchor {
    IVoicedItem getLinkedTo();
}
