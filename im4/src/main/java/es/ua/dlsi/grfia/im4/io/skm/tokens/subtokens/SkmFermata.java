package es.ua.dlsi.grfia.im4.io.skm.tokens.subtokens;

import es.ua.dlsi.grfia.im4.io.skm.SkmItem;

public class SkmFermata extends SkmItem {
    public SkmFermata() {
        super(";");
    }

    @Override
    public SkmFermata clone() {
        return new SkmFermata();
    }
}
