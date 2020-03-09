package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IMetadata;
import es.ua.dlsi.grfia.im4.core.IPart;
import es.ua.dlsi.grfia.im4.core.IScore;
import es.ua.dlsi.grfia.im4.core.IStaves;

public class Score implements IScore {
    @Override
    public IMetadata getMetadata() {
        return null;
    }

    @Override
    public IPart[] getParts() {
        return new IPart[0];
    }

    @Override
    public IStaves[] getStaves() {
        return new IStaves[0];
    }
}
