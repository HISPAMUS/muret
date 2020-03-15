package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IMetronomeMark;
import es.ua.dlsi.grfia.moosicae.core.IDots;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IFigure;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class MetronomeMark implements IMetronomeMark {
    private IFigure figure;
    private Optional<IDots> dots;
    private int value;

    public MetronomeMark(IFigure figure, Optional<IDots> dots, int value) {
        this.figure = figure;
        this.dots = dots;
        this.value = value;
    }

    @Override
    public IFigure getFigure() {
        return figure;
    }

    @Override
    public Optional<IDots> getDots() {
        return dots;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public MetronomeMark clone() {
        return new MetronomeMark(figure, dots, value);
    }
}
