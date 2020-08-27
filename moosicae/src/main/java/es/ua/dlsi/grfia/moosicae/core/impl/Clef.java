package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IClef;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IOctaveTransposition;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefLine;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefSign;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import javax.validation.constraints.NotNull;


import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Clef extends VoicedItem implements IClef {

    private final IClefLine line;
    @NotNull
    private final IClefSign signType;

    private final IOctaveTransposition octaveTransposition;

    /**
     * Used by factory
     * @param signType
     * @param line
     * @param octaveTransposition
     */
    Clef(IId id, @NotNull IClefSign signType, IClefLine line, IOctaveTransposition octaveTransposition) {
        super(id);
        this.line = line;
        this.signType = signType;
        this.octaveTransposition = octaveTransposition;
    }

    @Override
    public Optional<IClefLine> getLine() {
        return Optional.ofNullable(line);
    }

    @Override
    public Optional<IOctaveTransposition> getOctaveTransposition() {
        return Optional.ofNullable(octaveTransposition);
    }



    public IClefSign getSignType() {
        return signType;
    }

    @Override
    public Clef clone() {
        return new Clef(null, signType, line, octaveTransposition);
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
        if (!signType.equals(clef.signType)) return false;
        return octaveTransposition != null ? octaveTransposition.equals(clef.octaveTransposition) : clef.octaveTransposition == null;
    }

    @Override
    public int hashCode() {
        int result = line != null ? line.hashCode() : 0;
        result = 31 * result + signType.hashCode();
        result = 31 * result + (octaveTransposition != null ? octaveTransposition.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Clef{" +
                "line=" + line +
                ", signType=" + signType +
                ", octaveTransposition=" + octaveTransposition +
                "} " + super.toString();
    }
}
