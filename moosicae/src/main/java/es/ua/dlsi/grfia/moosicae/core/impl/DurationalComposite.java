package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDurational;
import es.ua.dlsi.grfia.moosicae.core.IDurationalComposite;
import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.utils.Time;
import org.jetbrains.annotations.NotNull;

//TODO Durational composite
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class DurationalComposite extends CoreItem implements IDurationalComposite {

    public DurationalComposite(@NotNull IId id) {
        super(id);
    }

    @Override
    public IDurational[] getChildren() {
        return new IDurational[0];
    }

    @Override
    public Time getDuration() {

        return null;
    }

    public abstract DurationalComposite clone();
}
