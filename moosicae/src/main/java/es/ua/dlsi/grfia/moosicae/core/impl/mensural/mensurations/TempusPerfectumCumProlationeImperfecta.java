package es.ua.dlsi.grfia.moosicae.core.impl.mensural.mensurations;

import es.ua.dlsi.grfia.moosicae.core.mensural.EMensuralPerfections;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.impl.mensural.Mensuration;
import es.ua.dlsi.grfia.moosicae.core.mensural.ITempusPerfectumCumProlationeImperfecta;
import es.ua.dlsi.grfia.moosicae.utils.Time;

/**
 * Visually rendered as O
 * 1 breve = 3 semibreves, 1 semibreve = 2 minim
 */
public class TempusPerfectumCumProlationeImperfecta extends Mensuration implements ITempusPerfectumCumProlationeImperfecta {
    public TempusPerfectumCumProlationeImperfecta() {
        super(EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum, EMensuralPerfections.perfectum, EMensuralPerfections.imperfectum);
    }

    @Override
    public Time getBarDuration() {
        return getBreveDuration();
    }

    @Override
    public TempusPerfectumCumProlationeImperfecta clone() {
        return new TempusPerfectumCumProlationeImperfecta();
    }

    @Override
    public String toString() {
        return "TempusPerfectumCumProlationeImperfecta{O} " + super.toString();
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {

    }
}
