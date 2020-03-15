package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IBarline;
import es.ua.dlsi.grfia.moosicae.core.IBarlineType;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class Barline implements IBarline {
    private Optional<Integer> barNumber;
    private Optional<IBarlineType> barlineType;

    public Barline(Optional<Integer> barNumber, Optional<IBarlineType> barlineType) {
        this.barNumber = barNumber;
        this.barlineType = barlineType;
    }

    @Override
    public Optional<Integer> getBarNumber() {
        return barNumber;
    }

    @Override
    public Optional<IBarlineType> getBarlineType() {
        return barlineType;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.export(this, inputOutput);
    }

    @Override
    public Barline clone() {
        return new Barline(barNumber, barlineType);
    }
}
