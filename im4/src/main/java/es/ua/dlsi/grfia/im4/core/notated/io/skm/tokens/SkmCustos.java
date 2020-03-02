package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.SkmToken;
import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens.SkmScientificPitch;

public class SkmCustos extends SkmToken {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*custos";

    private SkmScientificPitch skmScientificPitch;

    public SkmCustos(SkmScientificPitch skmScientificPitch) {
        super(SKM + skmScientificPitch.getSkmEncoding());
        this.skmScientificPitch = skmScientificPitch;
    }

    public SkmScientificPitch getSkmScientificPitch() {
        return skmScientificPitch;
    }

    @Override
    public SkmCustos clone() {
        return new SkmCustos(skmScientificPitch);
    }
}
