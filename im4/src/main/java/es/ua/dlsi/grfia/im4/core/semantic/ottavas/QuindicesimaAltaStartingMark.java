package es.ua.dlsi.grfia.im4.core.semantic.ottavas;

import es.ua.dlsi.grfia.im4.core.semantic.OttavaMark;

public class QuindicesimaAltaStartingMark extends OttavaMark {
    public QuindicesimaAltaStartingMark() {
        super("*15ma");
    }

    @Override
    public QuindicesimaAltaStartingMark clone() {
        return new QuindicesimaAltaStartingMark();
    }
}
