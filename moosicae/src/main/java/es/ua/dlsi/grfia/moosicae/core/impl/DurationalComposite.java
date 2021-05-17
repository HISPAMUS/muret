package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDurational;
import es.ua.dlsi.grfia.moosicae.core.IDurationalComposite;
import es.ua.dlsi.grfia.moosicae.core.IVoicedSingle;
import es.ua.dlsi.grfia.moosicae.core.adt.ITimeBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.adt.ITime;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * We don't inherit here from IDurational for avoiding having time as parameter in the constructor
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class DurationalComposite extends Voiced implements IDurationalComposite {
    @NotNull
    protected List<IDurational> children;

    public DurationalComposite(IId id, @NotNull IDurational[] children) {
        super(id);
        this.children = Arrays.asList(children);
    }

    @Override
    public IDurational[] getChildren() {
        return children.toArray(new IDurational[children.size()]);
    }

    @Override
    public ITime getDuration() {
        ITime result = ITimeBuilder.getInstance().timeZero();
        for (IDurational child: children) {
            result = result.add(child.getDuration());
        }
        return result;
    }

    public abstract DurationalComposite clone();
}
