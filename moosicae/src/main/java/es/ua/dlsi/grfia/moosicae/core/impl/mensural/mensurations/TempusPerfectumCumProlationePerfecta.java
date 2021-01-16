package es.ua.dlsi.grfia.moosicae.core.impl.mensural.mensurations;


import es.ua.dlsi.grfia.moosicae.core.adt.ITime;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.mensural.EMensuralPerfections;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.impl.mensural.Mensuration;
import es.ua.dlsi.grfia.moosicae.core.mensural.ITempusPerfectumCumProlationePerfecta;

/**
 * Visually rendered as O  with a dot inside
 * 1 breve = 3 semibreves, 1 semibreve = 3 minim
 */
public class TempusPerfectumCumProlationePerfecta extends Mensuration implements ITempusPerfectumCumProlationePerfecta {
    public TempusPerfectumCumProlationePerfecta(IId id) {
        super(id, EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum, EMensuralPerfections.perfectum, EMensuralPerfections.perfectum);
    }

    @Override
    public ITime getBarDuration() {
        return getBreveDuration();
    }

    @Override
    public TempusPerfectumCumProlationePerfecta clone() {
        return new TempusPerfectumCumProlationePerfecta(id);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) {

    }

    @Override
    public String toString() {
        return "TempusPerfectumCumProlationePerfecta{O.} " + super.toString();
    }
}
