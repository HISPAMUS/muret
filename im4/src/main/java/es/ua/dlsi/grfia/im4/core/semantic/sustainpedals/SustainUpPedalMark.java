package es.ua.dlsi.grfia.im4.core.semantic.sustainpedals;

import es.ua.dlsi.grfia.im4.core.semantic.SustainPedalMark;

public class SustainUpPedalMark extends SustainPedalMark {
    public SustainUpPedalMark() {
        super("*Xped");
    }

    @Override
    public SustainUpPedalMark clone() {
        return new SustainUpPedalMark();
    }
}
