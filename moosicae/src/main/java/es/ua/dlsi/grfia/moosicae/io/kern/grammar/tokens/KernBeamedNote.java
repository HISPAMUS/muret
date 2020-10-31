package es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens;

import es.ua.dlsi.grfia.moosicae.core.IMooObject;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 30/10/2020
 */
public class KernBeamedNote extends KernCoreSymbol {
    private final EKernBeamType beamType;
    private final int count;

    public KernBeamedNote(String encoding, IMooObject symbol, EKernBeamType beamType, int count) {
        super(encoding, symbol);
        this.beamType = beamType;
        if (count <= 0) {
            throw new IllegalArgumentException("Count must be positive, and it is " + count + " in encoding " + encoding);
        }
        this.count = count;
    }

    public EKernBeamType getBeamType() {
        return beamType;
    }

    public int getCount() {
        return count;
    }
}
