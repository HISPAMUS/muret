package es.ua.dlsi.grfia.moosicae.core.impl.mensural.mensurations;


import es.ua.dlsi.grfia.moosicae.core.adt.ITime;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.mensural.EMensuralPerfections;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.mensural.IProportioChangeTripla;
import es.ua.dlsi.grfia.moosicae.core.impl.mensural.Mensuration;

public class ProportioChangeTripla extends Mensuration implements IProportioChangeTripla  {
    public ProportioChangeTripla(IId id) {
        super(id, EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum, EMensuralPerfections.perfectum, EMensuralPerfections.imperfectum);
    }

    @Override
    public ProportioChangeTripla clone() {
        return new ProportioChangeTripla(id);
    }

    @Override
    public ITime getBarDuration() {
        return getSemibreveDuration(); //TODO Comprobar
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) {

    }

    @Override
    public String toString() {
        return "ProportioTripla{} " + super.toString();
    }
}
