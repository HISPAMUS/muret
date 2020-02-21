package es.ua.dlsi.grfia.im4.core.semantic;

public class PitchedDurationalSemanticItem extends DurationalSemanticItem {
    boolean beamStart;
    boolean beamEnd;

    boolean slurStart;
    boolean slurEnd;
    /**
     * Optional articulation
     */
    Articulation articulation;

    /**
     * Optional ornament
     */
    Ornament ornament;

    public PitchedDurationalSemanticItem(Figures figure, int dots) {
        super(figure, dots);
    }

    public boolean isBeamStart() {
        return beamStart;
    }

    public void setBeamStart(boolean beamStart) {
        this.beamStart = beamStart;
    }

    public boolean isBeamEnd() {
        return beamEnd;
    }

    public void setBeamEnd(boolean beamEnd) {
        this.beamEnd = beamEnd;
    }

    public boolean isSlurStart() {
        return slurStart;
    }

    public void setSlurStart(boolean slurStart) {
        this.slurStart = slurStart;
    }

    public boolean isSlurEnd() {
        return slurEnd;
    }

    public void setSlurEnd(boolean slurEnd) {
        this.slurEnd = slurEnd;
    }

    public Articulation getArticulation() {
        return articulation;
    }

    public void setArticulation(Articulation articulation) {
        this.articulation = articulation;
    }

    public Ornament getOrnament() {
        return ornament;
    }

    public void setOrnament(Ornament ornament) {
        this.ornament = ornament;
    }
}
