package es.ua.dlsi.grfia.im4.core.semantic.ottavas;

import es.ua.dlsi.grfia.im4.core.semantic.OttavaMark;

public class OttavaBassaStartingMark extends OttavaMark {
    public OttavaBassaStartingMark() {
        super("*8ba");
    }

    @Override
    public OttavaBassaStartingMark clone() {
        return new OttavaBassaStartingMark();
    }
}
