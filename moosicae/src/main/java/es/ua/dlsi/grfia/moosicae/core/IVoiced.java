package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.impl.Connector;
import es.ua.dlsi.grfia.moosicae.core.properties.IMarkAnchor;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public interface IVoiced extends IMooObject, IExporterVisitable, IMarkAnchor {
    IConnector[] getConnectors();
    IMark[] getMarks();
    void addMark(IMark mark);
}
