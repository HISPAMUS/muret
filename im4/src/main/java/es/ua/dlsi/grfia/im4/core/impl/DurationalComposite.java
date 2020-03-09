package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IDurational;
import es.ua.dlsi.grfia.im4.core.IDurationalComposite;
import es.ua.dlsi.grfia.im4.core.ITime;

public class DurationalComposite implements IDurationalComposite {
    @Override
    public IDurational[] getChildren() {
        return new IDurational[0];
    }

    @Override
    public ITime getDuration() {
        return null;
    }
}
