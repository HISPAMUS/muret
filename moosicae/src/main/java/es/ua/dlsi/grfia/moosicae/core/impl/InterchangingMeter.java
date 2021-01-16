package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.IInterchangingMeter;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.adt.ITime;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.impl.adt.Time;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 06/04/2020
 */
public class InterchangingMeter extends Meter implements IInterchangingMeter {
    @NotNull
    private final IMeter left;
    @NotNull
    private final IMeter right;

    public InterchangingMeter(IId id, @NotNull IMeter left, @NotNull IMeter right) throws IMException {
        super(id);
        this.left = left;
        this.right = right;
        if (!left.getBarDuration().equals(right.getBarDuration())) {
            throw new IMException("Both meters must have the same bar duration: " + left.getBarDuration() + " and " + right.getBarDuration());
        }
    }

    @Override
    public IMeter getLeft() {
        return left;
    }

    @Override
    public IMeter getRight() {
        return right;
    }

    @Override
    public ITime getBarDuration() {
        return left.getBarDuration();
    }

    @Override
    public InterchangingMeter clone() {
        try {
            return new InterchangingMeter(null, left, right);
        } catch (IMException e) {
            throw new IMRuntimeException(e); // it should never happen as this object is correct
        }
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportInterchangingMeter(this, inputOutput);
    }
}
