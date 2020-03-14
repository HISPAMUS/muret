package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDurational;
import es.ua.dlsi.grfia.moosicae.core.IDurationalComposite;
import es.ua.dlsi.grfia.moosicae.utils.Time;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class DurationalComposite implements IDurationalComposite {
    @Override
    public IDurational[] getChildren() {
        return new IDurational[0];
    }

    @Override
    public Time getDuration() {
        return null;
    }

    public abstract DurationalComposite clone();
}
