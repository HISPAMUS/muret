package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.ISystem;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class System extends MooObject implements ISystem {
    public System(IId id) {
        super(id);
    }
}
