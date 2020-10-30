package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IBeamGroup;
import es.ua.dlsi.grfia.moosicae.core.IDurational;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class BeamGroup extends DurationalComposite implements IBeamGroup {

    BeamGroup(IId id, @NotNull IDurational[] children) {
        super(id, children);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) {
        exportVisitor.exportBeamGroup(this, inputOutput);
    }

    @Override
    public DurationalComposite clone() {
        return new BeamGroup(null, children);
    }
}
