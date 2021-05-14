package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.ILeftBarline;
import es.ua.dlsi.grfia.moosicae.core.properties.INumber;
import es.ua.dlsi.grfia.moosicae.core.properties.IRightBarline;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/5/21
 */
public interface IMeasure extends IMooObject, IExporterVisitable {
    Optional<INumber> getBarNumber();
    Optional<ILeftBarline> getLeftBarline();
    Optional<IRightBarline> getRightBarline();
    IVoicedItem[] getItems();
    void add(IVoicedItem voicedItem);
}
