package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IClef;
import es.ua.dlsi.grfia.moosicae.core.IClefSign;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;

import java.util.Objects;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Clef implements IClef {
    private final int line;
    private final IClefSign signType;

    /**
     * Used by factory
     * @param line
     * @param signType
     */
    Clef(int line, IClefSign signType) {
        this.line = line;
        this.signType = signType;
    }

    public int getLine() {
        return line;
    }

    public IClefSign getSignType() {
        return signType;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals");
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

    @Override
    public Clef clone() {
        return new Clef(line, signType);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public String toString() {
        return "Clef{" +
                "line=" + line +
                ", signType=" + signType +
                '}';
    }
}
