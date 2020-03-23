package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitch;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Custos extends CoreItem implements ICustos {
    @NotNull
    private final IPitch pitch;

    Custos(@NotNull IId id, @NotNull IPitch pitch) {
        super(id);
        this.pitch = pitch;
    }

    @Override
    public Custos clone() {
        return new Custos(IdGenerator.getInstance().generateUniqueId(), pitch);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportCustos(this, inputOutput);
    }

    @Override
    public IPitch getPitch() {
        return pitch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Custos)) return false;

        Custos custos = (Custos) o;

        return pitch.equals(custos.pitch);
    }

    @Override
    public int hashCode() {
        return pitch.hashCode();
    }

    @Override
    public String toString() {
        return "Custos{" +
                "pitch=" + pitch +
                '}';
    }
}
