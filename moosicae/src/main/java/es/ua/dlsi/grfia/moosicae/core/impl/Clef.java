package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IClef;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefLine;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefSign;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import javax.validation.constraints.NotNull;


import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Clef extends CoreItem implements IClef {

    private final IClefLine line;
    @NotNull
    private final IClefSign signType;

    /**
     * Used by factory
     * @param line
     * @param signType
     */
    Clef(IId id,  IClefLine line, @NotNull IClefSign signType) {
        super(id);
        this.line = line;
        this.signType = signType;
    }

    @Override
    public Optional<IClefLine> getLine() {
        return Optional.ofNullable(line);
    }

    public IClefSign getSignType() {
        return signType;
    }

    @Override
    public Clef clone() {
        return new Clef(null, line, signType);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportClef(this, inputOutput);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clef)) return false;

        Clef clef = (Clef) o;

        if (line != null ? !line.equals(clef.line) : clef.line != null) return false;
        return signType.equals(clef.signType);
    }

    @Override
    public int hashCode() {
        int result = line != null ? line.hashCode() : 0;
        result = 31 * result + signType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Clef{" +
                "line=" + line +
                ", signType=" + signType +
                "} " + super.toString();
    }
}
