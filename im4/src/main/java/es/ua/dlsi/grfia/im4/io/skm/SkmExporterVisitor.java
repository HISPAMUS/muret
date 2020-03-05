package es.ua.dlsi.grfia.im4.io.skm;

import es.ua.dlsi.grfia.im4.core.*;
import es.ua.dlsi.grfia.im4.io.IExporterVisitor;

public class SkmExporterVisitor implements IExporterVisitor<SkmExporterContext> {


    @Override
    public void export(IClef clef, SkmExporterContext context) {
        context.append("*clef");
        context.append(clef.getSign().name()); //TODO
        context.append(clef.getLine());
    }

    @Override
    public void export(IMeter meter, SkmExporterContext context) {

    }

    @Override
    public void export(Layer layer, SkmExporterContext context) {

    }

    @Override
    public void export(Staff staff, SkmExporterContext context) {

    }

    @Override
    public void export(Part part, SkmExporterContext context) {

    }

    @Override
    public void export(Voice voice, SkmExporterContext context) {

    }

    @Override
    public void export(StaffGroup staffGroup, SkmExporterContext context) {

    }
}
