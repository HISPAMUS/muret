package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICommonTime;
import es.ua.dlsi.grfia.moosicae.core.TimeSignatureDenominator;
import es.ua.dlsi.grfia.moosicae.core.adt.ITime;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class CommonTime extends StandardTimeSignature implements ICommonTime {
    CommonTime(IId id) {
        super(id,
                new TimeSignatureNumerator(null, 4),
                new TimeSignatureDenominator(null, 4));
    }

    @Override
    public String toString() {
        return "CommonTime{} " + super.toString();
    }

    @Override
    public ITime getBarDuration() {
        return EFigures.WHOLE.getDuration();
    }

    @Override
    public CommonTime clone() {
        return new CommonTime(null);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportCommonTime(this, inputOutput);
    }


}
