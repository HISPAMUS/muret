package es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens;

import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmToken;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class SkmHeader extends SkmToken {
    private final ESkmHeaders skmHeaderType;

    public SkmHeader(ESkmHeaders skmHeaderType) {
        super(skmHeaderType.getEncoding());
        this.skmHeaderType = skmHeaderType;
    }

    public static SkmHeader parse(String text) {
        ESkmHeaders skmHeaderType = ESkmHeaders.valueOf(text);
        if (skmHeaderType == null) {
            throw new IMRuntimeException("Cannot find a header with encoding '" + text + "'");
        }
        return new SkmHeader(ESkmHeaders.valueOf(text));
    }

    public ESkmHeaders getSkmHeaderType() {
        return skmHeaderType;
    }
}
