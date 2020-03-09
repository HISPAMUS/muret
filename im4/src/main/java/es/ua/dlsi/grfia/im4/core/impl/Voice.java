package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IVoice;
import es.ua.dlsi.grfia.im4.core.IVoiced;

public class Voice implements IVoice {
    @Override
    public IVoiced[] getChildren() {
        return new IVoiced[0];
    }
}
