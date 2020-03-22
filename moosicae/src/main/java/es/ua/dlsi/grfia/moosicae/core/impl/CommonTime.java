package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICommonTime;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.utils.Time;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class CommonTime extends MeterSymbol implements ICommonTime {
    CommonTime(@NotNull IId id) {
        super(id);
    }

    @Override
    public String toString() {
        return "CommonTime{} " + super.toString();
    }

    @Override
    public Time getBarDuration() {
        return EFigures.WHOLE.getDuration();
    }

    @Override
    public CommonTime clone() {
        return new CommonTime(IdGenerator.getInstance().generateUniqueId());
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.export(this, inputOutput);
    }


}
