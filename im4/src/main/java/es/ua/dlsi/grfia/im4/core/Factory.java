package es.ua.dlsi.grfia.im4.core;

import es.ua.dlsi.grfia.im4.core.impl.Clef;
import es.ua.dlsi.grfia.im4.core.impl.ClefSigns;

public class Factory {
    private static Factory instance = null;

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public IClef createClef(int line, ClefSigns sign) {
        return null; // new Clef(line, sign);
    }

}
