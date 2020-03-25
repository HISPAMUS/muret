package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public interface IObjectBuilder<BuiltObjectType> {
    BuiltObjectType build() throws IMException;
}
