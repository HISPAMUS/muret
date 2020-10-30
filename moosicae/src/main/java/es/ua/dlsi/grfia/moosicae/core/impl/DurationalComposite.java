package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDurational;
import es.ua.dlsi.grfia.moosicae.core.IDurationalComposite;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.utils.Time;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class DurationalComposite extends VoicedItem implements IDurationalComposite {
    @NotNull
    protected IDurational[] children;

    public DurationalComposite(IId id, @NotNull IDurational[] children) {
        super(id);
        this.children = children.clone();
    }

    @Override
    public IDurational[] getChildren() {
        return children;
    }

    @Override
    public Time getDuration() {
        Time result = Time.TIME_ZERO;
        for (IDurational child: children) {
            result = result.add(child.getDuration());
        }
        return result;
    }

    public abstract DurationalComposite clone();
}
