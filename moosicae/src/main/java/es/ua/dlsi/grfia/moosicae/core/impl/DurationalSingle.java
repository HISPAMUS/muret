package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDots;
import es.ua.dlsi.grfia.moosicae.core.IDurationalSingle;
import es.ua.dlsi.grfia.moosicae.core.EFigures;
import es.ua.dlsi.grfia.moosicae.utils.Time;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class DurationalSingle implements IDurationalSingle {
    @Override
    public EFigures getFigure() {
        return null;
    }

    @Override
    public IDots getDots() {
        return null;
    }

    @Override
    public Time getDuration() {
        return null;
    }

    public abstract DurationalSingle clone();
}
