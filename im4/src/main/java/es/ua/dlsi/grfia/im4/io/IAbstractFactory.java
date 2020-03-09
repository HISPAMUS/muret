package es.ua.dlsi.grfia.im4.io;

import es.ua.dlsi.grfia.im4.core.impl.Clef;
import es.ua.dlsi.grfia.im4.core.IClef;

public interface IAbstractFactory {
    Clef parseClef(String string);
    void writeClef(IClef clef, IExporterContext exporterContext);
}
