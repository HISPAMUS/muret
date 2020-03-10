package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IClef;
import es.ua.dlsi.grfia.im4.core.ClefSignTypes;
import es.ua.dlsi.grfia.im4.core.ICoreAbstractFactory;

public class CoreFactoryImpl implements ICoreAbstractFactory {
    @Override
    public IClef createClef(int line, ClefSignTypes clefSign) {
        return new Clef(line, null); //TODO
    }
}
