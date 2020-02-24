package es.ua.dlsi.grfia.im4.core.semantic.headers;

import es.ua.dlsi.grfia.im4.core.Factory;
import es.ua.dlsi.grfia.im4.core.semantic.HeaderItem;


public class HeaderFactory extends Factory<HeaderItem> {
    private static HeaderFactory instance = null;

    public static HeaderFactory getInstance() {
        if (instance == null) {
            instance = new HeaderFactory();
        }
        return instance;
    }

    private HeaderFactory() {
        super("header");

        map.put(HeaderDynamics.SKM, HeaderDynamics::new);
        map.put(HeaderHarm.SKM, HeaderHarm::new);
        map.put(HeaderSKern.SKM, HeaderSKern::new);
        map.put(HeaderSMens.SKM, HeaderSMens::new);
        map.put(HeaderText.SKM, HeaderText::new);
    }
}
