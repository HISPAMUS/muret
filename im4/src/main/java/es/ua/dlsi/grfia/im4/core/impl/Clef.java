package es.ua.dlsi.grfia.im4.core.impl;

import es.ua.dlsi.grfia.im4.core.IClef;

import java.util.Objects;

public class Clef implements IClef {
    private final int line;
    private final ClefSigns sign;

    /**
     * Used by factory
     * @param line
     * @param sign
     */
    Clef(int line, ClefSigns sign) {
        this.line = line;
        this.sign = sign;
    }

    public int getLine() {
        return line;
    }

    public ClefSigns getSign() {
        return sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clef clef = (Clef) o;
        return line == clef.line &&
                sign == clef.sign;
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, sign);
    }

   /* @Override
    public void export(IExporterVisitor exporterVisitor, IExporterContext context) {
        exporterVisitor.export(this, context);
    }*/
}
