package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;

public abstract class PitchedDurationalSemanticItem extends DurationalSemanticItem {
    protected final Beaming beaming;
    protected final Slurring slurring;
    /**
     * Optional articulation
     */
    protected final Articulation articulation;

    /**
     * Optional ornament
     */
    protected final Ornament ornament;

    public PitchedDurationalSemanticItem(Figures figure, int dots, Perfection perfection, Fermata fermata, Size size,
                                         Beaming beaming, Slurring slurring, Articulation articulation, Ornament ornament) throws IM4Exception {
        super(null, figure, dots, perfection, fermata, size);
        this.beaming = beaming;
        this.slurring = slurring;
        this.articulation = articulation;
        this.ornament = ornament;
        this.setSkmEncodingJustInConstructor(buildSkmEncoding());
    }

    public Beaming getBeaming() {
        return beaming;
    }

    public Slurring getSlurring() {
        return slurring;
    }

    public Articulation getArticulation() {
        return articulation;
    }

    public Ornament getOrnament() {
        return ornament;
    }
}
