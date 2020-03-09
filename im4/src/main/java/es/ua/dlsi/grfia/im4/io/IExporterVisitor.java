package es.ua.dlsi.grfia.im4.io;


import es.ua.dlsi.grfia.im4.core.impl.*;
import es.ua.dlsi.grfia.im4.core.IClef;
import es.ua.dlsi.grfia.im4.core.IMeter;

/**
 * Uses the visitor pattern
 */
public interface IExporterVisitor<TContext extends IExporterContext> {
    void export(IClef clef, TContext context);
    void export(IMeter meter, TContext context);
    void export(Part part, TContext context);
    void export(Voice voice, TContext context);
}
