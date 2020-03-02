package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.SkmItem;

public class SkmAlteration extends SkmItem {
    private final SkmAccidental skmAccidental;
    private final SkmAlterationQualifier skmAlterationQualifier;

    public SkmAlteration(SkmAccidental skmAccidental) {
        super(skmAccidental.getSkmEncoding());
        this.skmAccidental = skmAccidental;
        this.skmAlterationQualifier = null;
    }

    public SkmAlteration(SkmAccidental skmAccidental, SkmAlterationQualifier skmAlterationQualifier) {
        super(skmAccidental.getSkmEncoding() + skmAlterationQualifier.getSkmEncoding());
        this.skmAccidental = skmAccidental;
        this.skmAlterationQualifier = skmAlterationQualifier;
    }

    public SkmAccidental getSkmAccidental() {
        return skmAccidental;
    }

    public SkmAlterationQualifier getSkmAlterationQualifier() {
        return skmAlterationQualifier;
    }

    @Override
    public SkmAlteration clone() {
        if (skmAlterationQualifier == null) {
            return new SkmAlteration(skmAccidental);
        } else {
            return new SkmAlteration(skmAccidental, skmAlterationQualifier);
        }
    }
}
