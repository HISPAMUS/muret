package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class AbstractExporter<ExporterVisitorType extends IExporterVisitor> implements IExporter {
    protected final ExporterVisitorType exporterVisitor;

    protected AbstractExporter(ExporterVisitorType exporterVisitor) {
        this.exporterVisitor = exporterVisitor;
    }
}
