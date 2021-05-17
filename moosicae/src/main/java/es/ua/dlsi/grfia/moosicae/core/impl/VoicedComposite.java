package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDurational;
import es.ua.dlsi.grfia.moosicae.core.IDurationalComposite;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;
import es.ua.dlsi.grfia.moosicae.core.IVoicedComposite;
import es.ua.dlsi.grfia.moosicae.core.adt.ITime;
import es.ua.dlsi.grfia.moosicae.core.adt.ITimeBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class VoicedComposite extends Voiced implements IVoicedComposite {
    @NotNull
    protected List<IVoiced> children;

    public VoicedComposite(IId id, @NotNull IVoiced[] children) {
        super(id);
        this.children = Arrays.asList(children);
    }

    public VoicedComposite(IId id) {
        super(id);
        this.children = new LinkedList<>();
    }

    @Override
    public IVoiced[] getChildren() {
        return children.toArray(new IVoiced[children.size()]);
    }

    @Override
    public void addChild(IVoiced item) {
        this.children.add(item);
    }


    public abstract VoicedComposite clone();

    @Override
    public String toString() {
        return "VoicedComposite{" +
                "children=" + children +
                "} " + super.toString();
    }
}
