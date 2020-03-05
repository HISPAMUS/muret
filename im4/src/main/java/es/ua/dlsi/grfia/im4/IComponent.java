package es.ua.dlsi.grfia.im4;

import es.ua.dlsi.grfia.im4.io.IExporterContext;
import es.ua.dlsi.grfia.im4.io.IExporterVisitor;

/**
 * Composite pattern
 */
public interface IComponent {
    void export(IExporterVisitor exporterVisitor, IExporterContext context);
}
