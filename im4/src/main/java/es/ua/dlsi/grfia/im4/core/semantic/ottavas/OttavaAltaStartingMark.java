package es.ua.dlsi.grfia.im4.core.semantic.ottavas;

import es.ua.dlsi.grfia.im4.core.semantic.OttavaMark;

public class OttavaAltaStartingMark extends OttavaMark {
    public OttavaAltaStartingMark() {
        super("*8va");
    }

    @Override
    public OttavaAltaStartingMark clone() {
        return new OttavaAltaStartingMark();
    }
}
