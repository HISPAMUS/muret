package es.ua.dlsi.grfia.im4.io;


import es.ua.dlsi.grfia.im4.core.impl.ClefSigns;

public interface IOAbstractFactory {
    String generateClefSign(ClefSigns clefSign);
    ClefSigns parseClefSign(String sign);
}
