package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDots;
import es.ua.dlsi.grfia.moosicae.core.IDurationalSingle;
import es.ua.dlsi.grfia.moosicae.core.IFigure;
import es.ua.dlsi.grfia.moosicae.core.ITime;

public abstract class DurationalSingle implements IDurationalSingle {
    @Override
    public IFigure getFigure() {
        return null;
    }

    @Override
    public IDots getDots() {
        return null;
    }

    @Override
    public ITime getDuration() {
        return null;
    }
}
