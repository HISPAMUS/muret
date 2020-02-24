package es.ua.dlsi.grfia.im4.core.semantic.ottavas;

import es.ua.dlsi.grfia.im4.core.semantic.OttavaMark;

public class QuindicesimaAltaEndingMark extends OttavaMark {
    public QuindicesimaAltaEndingMark() {
        super("*X15ma");
    }

    @Override
    public QuindicesimaAltaEndingMark clone() {
        return new QuindicesimaAltaEndingMark();
    }
}
