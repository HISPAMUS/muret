package es.ua.dlsi.grfia.im4.core.semantic.ottavas;

import es.ua.dlsi.grfia.im4.core.semantic.OttavaMark;

public class OttavaBassaEndingMark extends OttavaMark {
    public OttavaBassaEndingMark() {
        super("*X8ba");
    }

    @Override
    public OttavaBassaEndingMark clone() {
        return new OttavaBassaEndingMark();
    }
}
