package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.properties.IBarlineType;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.ILeftBarline;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/5/21
 */
public class LeftBarline extends Barline implements ILeftBarline {

    LeftBarline(IId id, IBarlineType barlineType) {
        super(id, barlineType);
    }
}
