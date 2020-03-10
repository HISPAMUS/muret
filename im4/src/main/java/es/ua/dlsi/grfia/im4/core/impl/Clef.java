package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IClef;
import es.ua.dlsi.grfia.im4.core.ClefSignTypes;

import java.util.Objects;

public class Clef implements IClef {
    private final int line;
    private final ClefSignTypes signType;

    /**
     * Used by factory
     * @param line
     * @param signType
     */
    Clef(int line, ClefSignTypes signType) {
        this.line = line;
        this.signType = signType;
    }

    public int getLine() {
        return line;
    }

    public ClefSignTypes getSignType() {
        return signType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clef clef = (Clef) o;
        return line == clef.line &&
                signType == clef.signType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, signType);
    }
}
