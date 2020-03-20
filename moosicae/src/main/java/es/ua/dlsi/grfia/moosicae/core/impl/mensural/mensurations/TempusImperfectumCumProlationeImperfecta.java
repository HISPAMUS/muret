package es.ua.dlsi.grfia.moosicae.core.impl.mensural.mensurations;

import es.ua.dlsi.grfia.moosicae.core.impl.mensural.Mensuration;
import es.ua.dlsi.grfia.moosicae.core.mensural.EMensuralPerfections;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.mensural.ITempusImperfectumCumProlationeImperfecta;
import es.ua.dlsi.grfia.moosicae.utils.Time;

/**
 * Visually rendered as C
 * 1 breve = 2 semibreves, 1 semibreve = 2 minim
 */
public class TempusImperfectumCumProlationeImperfecta extends Mensuration implements ITempusImperfectumCumProlationeImperfecta {
    public TempusImperfectumCumProlationeImperfecta() {
        super(EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum);
    }

    @Override
    public Time getBarDuration() {
        return getBreveDuration();
    }

    @Override
    public TempusImperfectumCumProlationeImperfecta clone() {
        return new TempusImperfectumCumProlationeImperfecta();
    }


    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {

    }

    @Override
    public String toString() {
        return "TempusImperfectumCumProlationeImperfecta{C} " + super.toString();
    }
}
