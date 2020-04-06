package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IAlternatingMeter;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 05/04/2020
 */
public class AlternatingMeter extends CompositeMeter implements IAlternatingMeter {
    AlternatingMeter(IId id, @NotNull IMeter[] submeters) {
        super(id, submeters);
    }

    @Override
    public AlternatingMeter clone() {
        return new AlternatingMeter(null, getSubMeters());
    }


    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportAlternatingMeter(this, inputOutput);
    }
}
