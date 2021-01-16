package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IArpeggioArrow;
import es.ua.dlsi.grfia.moosicae.core.properties.IArpeggioOrder;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/1/21
 */
public interface IArpeggio extends IMark {
    Optional<IArpeggioArrow> getArrow();
    Optional<IArpeggioOrder> getOrder();
}
