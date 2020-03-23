package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IMultimeasureRestCount;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.IMultimeasureRest;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class MultimeasureRest extends DurationalComposite implements IMultimeasureRest {
    @NotNull
    private final IMultimeasureRestCount measureCount;

    MultimeasureRest(@NotNull IId id, @NotNull IMultimeasureRestCount measureCount) {
        super(id);
        this.measureCount = measureCount;
    }

    @Override
    public IMultimeasureRestCount getMeasureCount() {
        return measureCount;
    }

    @Override
    public MultimeasureRest clone() {
        return new MultimeasureRest(IdGenerator.getInstance().generateUniqueId(), measureCount);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportMultimeasureRest(this, inputOutput);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MultimeasureRest)) return false;

        MultimeasureRest that = (MultimeasureRest) o;

        return measureCount.equals(that.measureCount);
    }

    @Override
    public int hashCode() {
        return measureCount.hashCode();
    }

    @Override
    public String toString() {
        return "MultimeasureRest{" +
                "measureCount=" + measureCount +
                "} " + super.toString();
    }
}
