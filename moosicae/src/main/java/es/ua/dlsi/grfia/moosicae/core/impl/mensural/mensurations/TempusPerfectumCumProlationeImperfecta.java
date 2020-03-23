package es.ua.dlsi.grfia.moosicae.core.impl.mensural.mensurations;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.mensural.EMensuralPerfections;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.impl.mensural.Mensuration;
import es.ua.dlsi.grfia.moosicae.core.mensural.ITempusPerfectumCumProlationeImperfecta;
import es.ua.dlsi.grfia.moosicae.utils.Time;
import org.jetbrains.annotations.NotNull;

/**
 * Visually rendered as O
 * 1 breve = 3 semibreves, 1 semibreve = 2 minim
 */
public class TempusPerfectumCumProlationeImperfecta extends Mensuration implements ITempusPerfectumCumProlationeImperfecta {
    public TempusPerfectumCumProlationeImperfecta(@NotNull IId id) {
        super(id, EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum, EMensuralPerfections.perfectum, EMensuralPerfections.imperfectum);
    }

    @Override
    public Time getBarDuration() {
        return getBreveDuration();
    }

    @Override
    public TempusPerfectumCumProlationeImperfecta clone() {
        return new TempusPerfectumCumProlationeImperfecta(id);
    }

    @Override
    public String toString() {
        return "TempusPerfectumCumProlationeImperfecta{O} " + super.toString();
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {

    }
}
