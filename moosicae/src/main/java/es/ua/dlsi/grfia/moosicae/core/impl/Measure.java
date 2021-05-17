package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IMeasure;
import es.ua.dlsi.grfia.moosicae.core.IVoicedSingle;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.ILeftBarline;
import es.ua.dlsi.grfia.moosicae.core.properties.INumber;
import es.ua.dlsi.grfia.moosicae.core.properties.IRightBarline;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class Measure extends CoreObject implements IMeasure {
    @NotNull
    private final LinkedList<IVoicedSingle> items;
    private INumber barNumber;
    private ILeftBarline leftBarline;
    private IRightBarline rightBarline;

    Measure(IId id, INumber barNumber, ILeftBarline leftBarline, IRightBarline rightBarline) {
        super(id);
        this.items = new LinkedList<>();
        this.barNumber = barNumber;
        this.leftBarline = leftBarline;
        this.rightBarline = rightBarline;
    }

    @Override
    public Optional<INumber> getBarNumber() {
        return Optional.ofNullable(barNumber);
    }

    @Override
    public Optional<ILeftBarline> getLeftBarline() {
        return Optional.ofNullable(leftBarline);
    }

    @Override
    public Optional<IRightBarline> getRightBarline() {
        return Optional.ofNullable(rightBarline);
    }

    @Override
    public IVoicedSingle[] getItems() {
        return items.toArray(new IVoicedSingle[items.size()]);
    }

    @Override
    public void add(IVoicedSingle voicedItem) {
        this.items.add(voicedItem);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportMeasure(this, inputOutput);
    }

    @Override
    public Measure clone() {
        return new Measure(null, barNumber, leftBarline, rightBarline);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Measure)) return false;

        Measure measure = (Measure) o;

        if (barNumber != null ? !barNumber.equals(measure.barNumber) : measure.barNumber != null) return false;
        if (leftBarline != null ? !leftBarline.equals(measure.leftBarline) : measure.leftBarline != null) return false;
        return rightBarline != null ? rightBarline.equals(measure.rightBarline) : measure.rightBarline == null;
    }

    @Override
    public int hashCode() {
        int result = barNumber != null ? barNumber.hashCode() : 0;
        result = 31 * result + (leftBarline != null ? leftBarline.hashCode() : 0);
        result = 31 * result + (rightBarline != null ? rightBarline.hashCode() : 0);
        return result;
    }
}
