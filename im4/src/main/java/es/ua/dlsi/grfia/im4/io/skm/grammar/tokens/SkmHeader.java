package es.ua.dlsi.grfia.im4.io.skm.grammar.tokens;

import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;
import es.ua.dlsi.grfia.im4.io.skm.grammar.SkmToken;

public class SkmHeader extends SkmToken {
    private final SkmHeaderTypes skmHeaderType;

    public SkmHeader(SkmHeaderTypes skmHeaderType) {
        super(skmHeaderType.getEncoding());
        this.skmHeaderType = skmHeaderType;
    }

    public static SkmHeader parse(String text) {
        SkmHeaderTypes skmHeaderType = SkmHeaderTypes.valueOf(text);
        if (skmHeaderType == null) {
            throw new IM4RuntimeException("Cannot find a header with encoding '" + text + "'");
        }
        return new SkmHeader(SkmHeaderTypes.valueOf(text));
    }

    public SkmHeaderTypes getSkmHeaderType() {
        return skmHeaderType;
    }
}
