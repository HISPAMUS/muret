package es.ua.dlsi.grfia.moosicae.core.impl.mensural.mensurations;


import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.mensural.EMensuralPerfections;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.mensural.IProportioChangeDupla;
import es.ua.dlsi.grfia.moosicae.core.impl.mensural.Mensuration;
import es.ua.dlsi.grfia.moosicae.utils.Time;
import org.jetbrains.annotations.NotNull;

public class ProportioChangeDupla extends Mensuration implements IProportioChangeDupla {
    public ProportioChangeDupla(@NotNull IId id) {
        super(id, EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum);
    }

    @Override
    public ProportioChangeDupla clone() {
        return new ProportioChangeDupla(id);
    }

    @Override
    public Time getBarDuration() {
        return getSemibreveDuration(); //TODO Comprobar
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {

    }

    @Override
    public String toString() {
        return "ProportioDupla{} " + super.toString();
    }
}
