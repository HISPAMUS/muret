package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.SkmItem;

public class SkmColoration extends SkmItem {
    public SkmColoration() {
        super("~");
    }

    @Override
    public SkmColoration clone() {
        return new SkmColoration();
    }
}
