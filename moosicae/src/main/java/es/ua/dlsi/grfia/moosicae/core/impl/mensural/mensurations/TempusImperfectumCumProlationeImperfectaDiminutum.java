package es.ua.dlsi.grfia.moosicae.core.impl.mensural.mensurations;



//TODO Duraciones

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.mensural.EMensuralPerfections;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.impl.mensural.Mensuration;
import es.ua.dlsi.grfia.moosicae.core.mensural.ITempusImperfectumCumProlationeImperfectaDiminutum;
import es.ua.dlsi.grfia.moosicae.utils.Time;
import javax.validation.constraints.NotNull;

/**
 * Visually rendered as cut time (see https://en.wikipedia.org/wiki/Mensural_notation, unicode U+1D1CD)
 * 1 breve = 2 semibreves, 1 semibreve = 2 minim
 */
public class TempusImperfectumCumProlationeImperfectaDiminutum extends Mensuration implements ITempusImperfectumCumProlationeImperfectaDiminutum {
    public TempusImperfectumCumProlationeImperfectaDiminutum(@NotNull IId id) {
        super(id, EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum);
    }

    @Override
    public Time getBarDuration() {
        return getBreveDuration();
    }

    @Override
    public TempusImperfectumCumProlationeImperfectaDiminutum clone() {
        return new TempusImperfectumCumProlationeImperfectaDiminutum(id);
    }


    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {

    }

    @Override
    public String toString() {
        return "TempusImperfectumCumProlationeImperfectaDiminutum{C|} " + super.toString();
    }
}
