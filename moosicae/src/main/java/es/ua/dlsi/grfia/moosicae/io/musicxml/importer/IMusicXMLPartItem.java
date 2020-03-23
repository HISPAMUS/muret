package es.ua.dlsi.grfia.moosicae.io.musicxml.importer;

import es.ua.dlsi.grfia.moosicae.core.ICoreItem;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public interface IMusicXMLPartItem extends ICoreItem {
    ICoreItem[] getItems();
}
