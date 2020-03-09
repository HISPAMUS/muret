package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IPart;
import es.ua.dlsi.grfia.im4.core.IVoice;

public class Part implements IPart {
    @Override
    public IVoice[] getVoices() {
        return new IVoice[0];
    }
}
