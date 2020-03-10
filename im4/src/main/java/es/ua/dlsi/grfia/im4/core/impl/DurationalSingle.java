package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IDots;
import es.ua.dlsi.grfia.im4.core.IDurationalSingle;
import es.ua.dlsi.grfia.im4.core.IFigure;
import es.ua.dlsi.grfia.im4.core.ITime;

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
