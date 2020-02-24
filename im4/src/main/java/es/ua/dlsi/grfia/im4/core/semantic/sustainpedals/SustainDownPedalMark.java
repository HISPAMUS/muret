package es.ua.dlsi.grfia.im4.core.semantic.sustainpedals;

import es.ua.dlsi.grfia.im4.core.semantic.SustainPedalMark;

public class SustainDownPedalMark extends SustainPedalMark {
    public SustainDownPedalMark() {
        super("*ped");
    }

    @Override
    public SustainDownPedalMark clone() {
        return new SustainDownPedalMark();
    }
}
