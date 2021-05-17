package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IDurational;
import es.ua.dlsi.grfia.moosicae.core.IMultimeasureRest;
import es.ua.dlsi.grfia.moosicae.core.IRest;
import es.ua.dlsi.grfia.moosicae.core.IWholeMeasureRest;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.MultimeasureRestCount;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IMultimeasureRestCount;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class WholeMeasureRest extends MultimeasureRest implements IWholeMeasureRest {
    WholeMeasureRest(IId id, IRest rest) {
        super(id, new IDurational[]{rest}, new MultimeasureRestCount(null, 1));
    }

    @Override
    public WholeMeasureRest clone() {
        return new WholeMeasureRest(null, (IRest)children.get(0));
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportWholeMeasureRest(this, inputOutput);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WholeMeasureRest)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "WholeMeasureRest";
    }
}
