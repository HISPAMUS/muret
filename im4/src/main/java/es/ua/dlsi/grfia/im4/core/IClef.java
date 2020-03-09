package es.ua.dlsi.grfia.im4.core;

import es.ua.dlsi.grfia.im4.core.impl.ClefSigns;

public interface IClef extends INonDurational {
    int getLine();

    ClefSigns getSign();
}
