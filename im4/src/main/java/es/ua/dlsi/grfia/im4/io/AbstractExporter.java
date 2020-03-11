package es.ua.dlsi.grfia.im4.io;

import es.ua.dlsi.grfia.im4.core.IExporterVisitor;

public abstract class AbstractExporter<ExporterVisitorType extends IExporterVisitor> implements IExporter {
    protected final ExporterVisitorType exporterVisitor;

    protected AbstractExporter(ExporterVisitorType exporterVisitor) {
        this.exporterVisitor = exporterVisitor;
    }
}
