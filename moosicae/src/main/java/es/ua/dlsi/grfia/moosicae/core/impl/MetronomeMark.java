package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import javax.validation.constraints.NotNull;


import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class MetronomeMark extends VoicedItem implements IMetronomeMark {
    @NotNull
    private IFigure figure;

    private IDots dots;
    @NotNull
    private IMetronomeMarkValue value;

    @NotNull
    private final IHorizontalAnchor start;

    MetronomeMark(IId id, @NotNull IHorizontalAnchor start, @NotNull IFigure figure,  IDots dots, IMetronomeMarkValue value) {
        super(id);
        this.figure = figure;
        this.dots = dots;
        this.value = value;
        this.start = start;
    }

    @Override
    public IFigure getFigure() {
        return figure;
    }

    @Override
    public Optional<IDots> getDots() {
        return Optional.ofNullable(dots);
    }

    @Override
    public IMetronomeMarkValue getValue() {
        return value;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportMetronomeMark(this, inputOutput);
    }

    @Override
    public MetronomeMark clone() {
        return new MetronomeMark(null, start, figure, dots, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetronomeMark)) return false;

        MetronomeMark that = (MetronomeMark) o;

        if (!figure.equals(that.figure)) return false;
        if (dots != null ? !dots.equals(that.dots) : that.dots != null) return false;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        int result = figure.hashCode();
        result = 31 * result + (dots != null ? dots.hashCode() : 0);
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public IHorizontalAnchor getStart() {
        return null;
    }
}
