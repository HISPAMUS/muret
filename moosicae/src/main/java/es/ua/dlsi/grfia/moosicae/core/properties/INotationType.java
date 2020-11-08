package es.ua.dlsi.grfia.moosicae.core.properties;

import es.ua.dlsi.grfia.moosicae.core.enums.ENotationTypes;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public interface INotationType extends IEnumCoreProperty<ENotationTypes> {
    ENotationTypes getValue();
}