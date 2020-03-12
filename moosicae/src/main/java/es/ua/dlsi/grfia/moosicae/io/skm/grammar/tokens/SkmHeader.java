package es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens;

import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmToken;

public class SkmHeader extends SkmToken {
    private final SkmHeaderTypes skmHeaderType;

    public SkmHeader(SkmHeaderTypes skmHeaderType) {
        super(skmHeaderType.getEncoding());
        this.skmHeaderType = skmHeaderType;
    }

    public static SkmHeader parse(String text) {
        SkmHeaderTypes skmHeaderType = SkmHeaderTypes.valueOf(text);
        if (skmHeaderType == null) {
            throw new IMRuntimeException("Cannot find a header with encoding '" + text + "'");
        }
        return new SkmHeader(SkmHeaderTypes.valueOf(text));
    }

    public SkmHeaderTypes getSkmHeaderType() {
        return skmHeaderType;
    }
}
