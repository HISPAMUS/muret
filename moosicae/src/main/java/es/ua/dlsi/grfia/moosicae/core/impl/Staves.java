package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.ISystemElement;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class Staves extends CoreObject implements ISystemElement {
    public Staves(@NotNull IId id) {
        super(id);
    }
}
