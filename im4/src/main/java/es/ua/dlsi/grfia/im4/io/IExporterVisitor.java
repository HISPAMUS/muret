package es.ua.dlsi.grfia.im4.io;


import es.ua.dlsi.grfia.im4.core.*;

/**
 * Uses the visitor pattern
 */
public interface IExporterVisitor<TContext extends IExporterContext> {
    void export(IClef clef, TContext context);
    void export(IMeter meter, TContext context);
    void export(Layer layer, TContext context);
    void export(Staff staff, TContext context);
    void export(Part part, TContext context);
    void export(Voice voice, TContext context);
    void export(StaffGroup staffGroup, TContext context);
}
