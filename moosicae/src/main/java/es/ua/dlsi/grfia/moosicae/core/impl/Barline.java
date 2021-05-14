package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IBarline;
import es.ua.dlsi.grfia.moosicae.core.properties.IBarlineType;
import es.ua.dlsi.grfia.moosicae.core.properties.INumber;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;


import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class Barline extends VoicedItem implements IBarline {
    private IBarlineType barlineType;

    Barline(IId id,  IBarlineType barlineType) {
        super(id);
        this.barlineType = barlineType;
    }

    @Override
    public Optional<IBarlineType> getBarlineType() {
        return Optional.ofNullable(barlineType);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportBarline(this, inputOutput);
    }

    @Override
    public Barline clone() {
        return new Barline(null, barlineType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Barline)) return false;

        Barline barline = (Barline) o;

        return barlineType != null ? barlineType.equals(barline.barlineType) : barline.barlineType == null;
    }

    @Override
    public int hashCode() {
        return barlineType != null ? barlineType.hashCode() : 0;
    }
}
