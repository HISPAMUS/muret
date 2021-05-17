package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.IVoicedSingle;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public interface IMxmlPartItem extends IVoicedSingle {
    IVoicedSingle[] getItems();
}
