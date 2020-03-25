package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.ICoreItem;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public interface IMxmlPartItem extends ICoreItem {
    ICoreItem[] getItems();
}
