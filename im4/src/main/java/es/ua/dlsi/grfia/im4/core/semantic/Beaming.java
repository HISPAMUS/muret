package es.ua.dlsi.grfia.im4.core.semantic;

public class Beaming {
    private final boolean beamStart;
    private final boolean beamEnd;

    public Beaming(boolean beamStart, boolean beamEnd) {
        this.beamStart = beamStart;
        this.beamEnd = beamEnd;
    }

    public boolean isBeamStart() {
        return beamStart;
    }

    public boolean isBeamEnd() {
        return beamEnd;
    }
}
