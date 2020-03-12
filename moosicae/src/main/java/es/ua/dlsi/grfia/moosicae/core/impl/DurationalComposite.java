package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDurational;
import es.ua.dlsi.grfia.moosicae.core.IDurationalComposite;
import es.ua.dlsi.grfia.moosicae.core.ITime;

public abstract class DurationalComposite implements IDurationalComposite {
    @Override
    public IDurational[] getChildren() {
        return new IDurational[0];
    }

    @Override
    public ITime getDuration() {
        return null;
    }
}
