package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.ITuplet;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;
import es.ua.dlsi.grfia.moosicae.core.IVoicedComposite;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.ITupletActual;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.ITupletNormal;

import java.util.LinkedList;
import java.util.List;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class ITupletBuilder extends IVoicedCompositeBuilder<ITuplet> {
    private ITupletActual tupletActual;
    private ITupletNormal tupletNormal;

    public ITupletBuilder() {
    }

    public ITupletBuilder from(ITupletActual tupletActual) {
        this.tupletActual = tupletActual;
        return this;
    }

    public ITupletBuilder from(ITupletNormal tupletNormal) {
        this.tupletNormal = tupletNormal;
        return this;
    }

    @Override
    public ITuplet build() throws IMException {
        if (tupletActual == null) {
            throw new IMException("Missing tuplet actual value");
        }
        if (tupletNormal == null) {
            throw new IMException("Missing tuplet normal value");
        }
        if (this.children.size() <=1) {
            throw new IMException("At least two elements are required, and just " + this.children.size() + " are found");
        }
        ITuplet tuplet = ICoreAbstractFactory.getInstance().createTuplet(getId(), children.toArray(new IVoiced[0]), tupletActual, tupletNormal);
        return tuplet;
    }
}
