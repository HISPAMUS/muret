package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IMarkAnchor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public interface IMark extends IMooObject, IExporterVisitable {
    IMarkAnchor getStart();
}
