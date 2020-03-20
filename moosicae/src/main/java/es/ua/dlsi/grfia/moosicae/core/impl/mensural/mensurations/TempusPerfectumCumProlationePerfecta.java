package es.ua.dlsi.grfia.moosicae.core.impl.mensural.mensurations;


import es.ua.dlsi.grfia.moosicae.core.mensural.EMensuralPerfections;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.impl.mensural.Mensuration;
import es.ua.dlsi.grfia.moosicae.core.mensural.ITempusPerfectumCumProlationePerfecta;
import es.ua.dlsi.grfia.moosicae.utils.Time;

/**
 * Visually rendered as O  with a dot inside
 * 1 breve = 3 semibreves, 1 semibreve = 3 minim
 */
public class TempusPerfectumCumProlationePerfecta extends Mensuration implements ITempusPerfectumCumProlationePerfecta {
    public TempusPerfectumCumProlationePerfecta() {
        super(EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum, EMensuralPerfections.perfectum, EMensuralPerfections.perfectum);
    }

    @Override
    public Time getBarDuration() {
        return getBreveDuration();
    }

    @Override
    public TempusPerfectumCumProlationePerfecta clone() {
        return new TempusPerfectumCumProlationePerfecta();
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {

    }

    @Override
    public String toString() {
        return "TempusPerfectumCumProlationePerfecta{O.} " + super.toString();
    }
}
