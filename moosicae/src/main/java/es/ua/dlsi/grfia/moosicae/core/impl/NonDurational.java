package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.INonDurational;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class NonDurational  extends CoreItem implements INonDurational {
    public NonDurational(@NotNull IId id) {
        super(id);
    }

    public abstract NonDurational clone();
}
