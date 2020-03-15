package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IMultimeasureRest;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class MultimeasureRest extends DurationalComposite implements IMultimeasureRest {
    private final int measureCount;

    public MultimeasureRest(int measureCount) {
        this.measureCount = measureCount;
    }

    @Override
    public int getMeasureCount() {
        return measureCount;
    }

    @Override
    public MultimeasureRest clone() {
        return new MultimeasureRest(measureCount);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MultimeasureRest)) return false;

        MultimeasureRest that = (MultimeasureRest) o;

        return measureCount == that.measureCount;
    }

    @Override
    public int hashCode() {
        return measureCount;
    }

    @Override
    public String toString() {
        return "MultimeasureRest{" +
                "measureCount=" + measureCount +
                "} " + super.toString();
    }
}
