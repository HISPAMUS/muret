package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IMarkAnchor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/1/21
 */
public interface IDurationalMark extends IMark {
    IMarkAnchor getEnd();
}
