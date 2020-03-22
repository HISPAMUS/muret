package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IClef;
import es.ua.dlsi.grfia.moosicae.core.IClefSign;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Clef extends CoreItem implements IClef {
    @Nullable
    private final Integer line;
    @NotNull
    private final IClefSign signType;

    /**
     * Used by factory
     * @param line
     * @param signType
     */
    Clef(@NotNull IId id, @Nullable Integer line, @NotNull IClefSign signType) {
        super(id);
        this.line = line;
        this.signType = signType;
    }

    @Override
    public Optional<Integer> getLine() {
        return Optional.ofNullable(line);
    }

    public IClefSign getSignType() {
        return signType;
    }

    @Override
    public Clef clone() {
        return new Clef(IdGenerator.getInstance().generateUniqueId(), line, signType);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.export(this, inputOutput);
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
