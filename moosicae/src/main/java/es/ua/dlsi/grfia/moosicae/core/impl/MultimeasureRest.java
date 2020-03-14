package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.EFigures;
import es.ua.dlsi.grfia.moosicae.core.IMultimeasureRest;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class MultimeasureRest extends DurationalComposite implements IMultimeasureRest {
    private final EFigures figure;
    private final int measureCount;

    public MultimeasureRest(EFigures figure, int measureCount) {
        this.figure = figure;
        this.measureCount = measureCount;
    }

    @Override
    public EFigures getFigure() {
        return figure;
    }

    @Override
    public int getMeasureCount() {
        return measureCount;
    }

    @Override
    public MultimeasureRest clone() {
        return new MultimeasureRest(figure, measureCount);
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

        if (measureCount != that.measureCount) return false;
        return figure == that.figure;
    }

    @Override
    public int hashCode() {
        int result = figure.hashCode();
        result = 31 * result + measureCount;
        return result;
    }

    @Override
    public String toString() {
        return "MultimeasureRest{" +
                "figure=" + figure +
                ", measureCount=" + measureCount +
                "} " + super.toString();
    }
}
