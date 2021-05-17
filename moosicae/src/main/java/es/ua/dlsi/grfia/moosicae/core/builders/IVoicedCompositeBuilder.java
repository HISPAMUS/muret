package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.core.IVoiced;
import es.ua.dlsi.grfia.moosicae.core.IVoicedComposite;

import java.util.LinkedList;
import java.util.List;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class IVoicedCompositeBuilder<T extends IVoicedComposite> extends CoreObjectBuilder<T> {
    protected List<IVoiced> children;

    public IVoicedCompositeBuilder() {
        children = new LinkedList<>();
    }

    public IVoicedCompositeBuilder add(IVoiced child) {
        this.children.add(child);
        return this;
    }
}
