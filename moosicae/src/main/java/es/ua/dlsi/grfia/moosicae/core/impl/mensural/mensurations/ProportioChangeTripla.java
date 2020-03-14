package es.ua.dlsi.grfia.moosicae.core.impl.mensural.mensurations;


import es.ua.dlsi.grfia.moosicae.core.mensural.EMensuralPerfections;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.mensural.IProportioChangeTripla;
import es.ua.dlsi.grfia.moosicae.core.impl.mensural.Mensuration;
import es.ua.dlsi.grfia.moosicae.utils.Time;

public class ProportioChangeTripla extends Mensuration implements IProportioChangeTripla  {
    public ProportioChangeTripla() {
        super(EMensuralPerfections.imperfectum, EMensuralPerfections.imperfectum, EMensuralPerfections.perfectum, EMensuralPerfections.imperfectum);
    }

    @Override
    public ProportioChangeTripla clone() {
        return new ProportioChangeTripla();
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
        return "ProportioTripla{} " + super.toString();
    }
}
