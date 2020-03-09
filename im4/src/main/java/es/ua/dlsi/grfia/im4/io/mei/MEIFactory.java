package es.ua.dlsi.grfia.im4.io.mei;

import es.ua.dlsi.grfia.im4.core.impl.ClefSigns;
import es.ua.dlsi.grfia.im4.io.IOAbstractFactory;

public class MEIFactory implements IOAbstractFactory {
    private static MEIFactory instance = null;

    public static MEIFactory getInstance() {
        if (instance == null) {
            instance = new MEIFactory();
        }
        return instance;
    }

    //TODO
    @Override
    public String generateClefSign(ClefSigns clefSign) {
        return clefSign.name();
    }

    @Override
    public ClefSigns parseClefSign(String sign) {
        return ClefSigns.valueOf(sign);
    }
}
