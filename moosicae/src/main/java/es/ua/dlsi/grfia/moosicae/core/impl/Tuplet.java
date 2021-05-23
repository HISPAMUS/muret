package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ITuplet;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.ITupletActual;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.ITupletNormal;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/5/21
 */
public class Tuplet extends VoicedComposite implements ITuplet {
    private final ITupletActual tupletActual;
    private final ITupletNormal tupletNormal;

    public Tuplet(IId id, @NotNull IVoiced[] children, ITupletActual tupletActual, ITupletNormal tupletNormal) {
        super(id, children);
        this.tupletActual = tupletActual;
        this.tupletNormal = tupletNormal;
    }

    public Tuplet(IId id, ITupletActual tupletActual, ITupletNormal tupletNormal) {
        super(id);
        this.tupletActual = tupletActual;
        this.tupletNormal = tupletNormal;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportTuplet(this, inputOutput);
    }

    @Override
    public VoicedComposite clone() {
        IVoiced [] clonedChildren = new IVoiced[children.size()];
        for (int i=0; i<children.size(); i++) {
            clonedChildren[i] = (IVoiced) children.get(i).clone();
        }
        return new Tuplet(null, clonedChildren, tupletActual, tupletNormal);
    }

    @Override
    public ITupletActual getActual() {
        return tupletActual;
    }

    @Override
    public ITupletNormal getNormal() {
        return tupletNormal;
    }
}
