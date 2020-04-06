package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.IMixedMeter;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 05/04/2020
 */
public class MixedMeter extends CompositeMeter implements IMixedMeter {
    MixedMeter(IId id, @NotNull IMeter[] submeters) {
        super(id, submeters);
    }

    @Override
    public MixedMeter clone() {
        return new MixedMeter(null, getSubMeters());
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportMixedMeter(this, inputOutput);
    }
}
