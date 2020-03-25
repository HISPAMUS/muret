package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICutTime;
import es.ua.dlsi.grfia.moosicae.core.TimeSignatureDenominator;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.utils.Time;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class CutTime extends FractionalTimeSignature implements ICutTime {

    CutTime(IId id) {
        super(id,
                new TimeSignatureNumerator(null, 2),
                new TimeSignatureDenominator(null, 2));
    }

    @Override
    public String toString() {
        return "CutTime{} " + super.toString();
    }

    @Override
    public Time getBarDuration() {
        return EFigures.WHOLE.getDuration();
    }

    @Override
    public CutTime clone() {
        return new CutTime(null);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportCutTime(this, inputOutput);
    }
}
