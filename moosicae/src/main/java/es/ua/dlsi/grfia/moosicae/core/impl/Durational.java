package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDots;
import es.ua.dlsi.grfia.moosicae.core.IDurational;
import es.ua.dlsi.grfia.moosicae.core.IFigure;
import es.ua.dlsi.grfia.moosicae.core.ITime;

public abstract class Durational implements IDurational {
    IFigure figure;
    IDots dots;
    ITime duration;

    @Override
    public ITime getDuration() {
        return null;
    }
}
