package es.ua.dlsi.grfia.moosicae.core;

import es.ua.dlsi.grfia.moosicae.core.properties.IFermataShape;
import es.ua.dlsi.grfia.moosicae.core.properties.IVerticalPlace;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/1/21
 */
public interface IFermata extends IMark {
    Optional<IVerticalPlace> getVerticalPlace();
    Optional<IFermataShape> getFermataShape();
}
