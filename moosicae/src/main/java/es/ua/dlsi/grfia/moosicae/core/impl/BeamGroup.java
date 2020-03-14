package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IBeamGroup;
import es.ua.dlsi.grfia.moosicae.core.IExporterVisitor;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class BeamGroup extends DurationalComposite implements IBeamGroup {
    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        //TODO
    }

    @Override
    public DurationalComposite clone() {
        return null;
    }
}
