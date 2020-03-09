package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IDots;
import es.ua.dlsi.grfia.im4.core.IDurational;
import es.ua.dlsi.grfia.im4.core.IFigure;
import es.ua.dlsi.grfia.im4.core.ITime;

public class Durational implements IDurational {
    IFigure figure;
    IDots dots;
    ITime duration;

    @Override
    public ITime getDuration() {
        return null;
    }
}
