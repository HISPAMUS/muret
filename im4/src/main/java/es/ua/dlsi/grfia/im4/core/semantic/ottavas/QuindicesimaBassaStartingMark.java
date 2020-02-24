package es.ua.dlsi.grfia.im4.core.semantic.ottavas;

import es.ua.dlsi.grfia.im4.core.semantic.OttavaMark;

public class QuindicesimaBassaStartingMark extends OttavaMark {
    public QuindicesimaBassaStartingMark() {
        super("*15ba");
    }

    @Override
    public QuindicesimaBassaStartingMark clone() {
        return new QuindicesimaBassaStartingMark();
    }
}
