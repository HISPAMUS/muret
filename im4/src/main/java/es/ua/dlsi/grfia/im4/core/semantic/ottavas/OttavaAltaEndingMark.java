package es.ua.dlsi.grfia.im4.core.semantic.ottavas;

import es.ua.dlsi.grfia.im4.core.semantic.OttavaMark;

public class OttavaAltaEndingMark extends OttavaMark {
    public OttavaAltaEndingMark() {
        super("*X8va");
    }

    @Override
    public OttavaAltaEndingMark clone() {
        return new OttavaAltaEndingMark();
    }
}
