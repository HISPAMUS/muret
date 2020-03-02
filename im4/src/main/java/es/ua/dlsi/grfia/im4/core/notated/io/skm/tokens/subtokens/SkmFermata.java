package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.SkmItem;

public class SkmFermata extends SkmItem {
    public SkmFermata() {
        super(";");
    }

    @Override
    public SkmFermata clone() {
        return new SkmFermata();
    }
}
