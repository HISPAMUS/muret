package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.properties.IBarlineType;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IRightBarline;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/5/21
 */
public class RightBarline extends Barline implements IRightBarline {

    RightBarline(IId id, IBarlineType barlineType) {
        super(id, barlineType);
    }
}
