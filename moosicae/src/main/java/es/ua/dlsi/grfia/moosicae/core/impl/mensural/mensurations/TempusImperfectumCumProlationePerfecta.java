package es.ua.dlsi.grfia.moosicae.core.impl.mensural.mensurations;


import es.ua.dlsi.grfia.moosicae.core.mensural.EMensuralPerfections;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.impl.mensural.Mensuration;
import es.ua.dlsi.grfia.moosicae.core.mensural.ITempusImperfectumCumProlationePerfecta;
import es.ua.dlsi.grfia.moosicae.utils.Time;

/**
 * Visually rendered as C with a dot inside
 * 1 breve = 2 semibreves, 1 semibreve = 3 minim
 */
public class TempusImperfectumCumProlationePerfecta extends Mensuration implements ITempusImperfectumCumProlationePerfecta {
    public TempusImperfectumCumProlationePerfecta() {
        super(EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum, EMensuralPerfections.perfectum);
    }

    @Override
    public Time getBarDuration() {
        return getBreveDuration();
    }

    @Override
    public TempusImperfectumCumProlationePerfecta clone() {
        return new TempusImperfectumCumProlationePerfecta();
    }


    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {

    }

    @Override
    public String toString() {
        return "TempusImperfectumCumProlationePerfecta{C.} " + super.toString();
    }
}
