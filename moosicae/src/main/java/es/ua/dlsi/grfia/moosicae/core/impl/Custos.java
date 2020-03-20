package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICustos;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IPitch;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;

import java.util.Objects;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Custos implements ICustos {
    private final IPitch pitch;

    Custos(IPitch pitch) {
        this.pitch = pitch;
    }

    @Override
    public IVoiced clone() {
        return new Custos(pitch);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public IPitch getPitch() {
        return pitch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Custos custos = (Custos) o;
        return pitch.equals(custos.pitch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pitch);
    }

    @Override
    public String toString() {
        return "Custos{" +
                "pitch=" + pitch +
                '}';
    }
}
