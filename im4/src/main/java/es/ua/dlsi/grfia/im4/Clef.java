package es.ua.dlsi.grfia.im4;

import es.ua.dlsi.grfia.im4.io.IExporterContext;
import es.ua.dlsi.grfia.im4.io.IExporterVisitor;

import java.util.Objects;

public class Clef implements IClef {
    private final int line;
    private final ClefSigns sign;

    protected Clef(int line, ClefSigns sign) {
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


    @Override
    public Staff getStaff() {
        return null;
    }

    @Override
    public void export(IExporterVisitor exporterVisitor, IExporterContext context) {
        exporterVisitor.export(this, context);
    }
}
