package es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens;

import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.EKernHeaders;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernToken;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class KernHeader extends KernSpineBegin {
    private final EKernHeaders skmHeaderType;

    public KernHeader(EKernHeaders skmHeaderType) {
        super(skmHeaderType.getEncoding());
        this.skmHeaderType = skmHeaderType;
    }

    public static KernHeader parse(String text) {
        EKernHeaders skmHeaderType = EKernHeaders.valueOf(text);
        if (skmHeaderType == null) {
            throw new IMRuntimeException("Cannot find a header with encoding '" + text + "'");
        }
        return new KernHeader(EKernHeaders.valueOf(text));
    }

    public EKernHeaders getSkmHeaderType() {
        return skmHeaderType;
    }
}
