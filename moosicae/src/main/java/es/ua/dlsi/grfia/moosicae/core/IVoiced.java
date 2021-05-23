package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IMarkAnchor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IVoiced extends IMooObject, IImportable, IExporterVisitable, IMarkAnchor {
    IConnector[] getConnectors();
    IMark[] getMarks();
    void addMark(IMark mark);
    void addConnector(IConnector connector);
}
