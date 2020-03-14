package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.EFigures;
import es.ua.dlsi.grfia.moosicae.core.ICommonTime;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.utils.Time;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class CommonTime extends MeterSymbol implements ICommonTime {
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
        return new CommonTime();
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }
}
