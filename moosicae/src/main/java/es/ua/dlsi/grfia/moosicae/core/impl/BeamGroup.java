package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IBeamGroup;
import es.ua.dlsi.grfia.moosicae.core.IDurational;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class BeamGroup extends Connector implements IBeamGroup {

    BeamGroup(IId id, @NotNull IVoiced[] connected) {
        super(id, connected);
    }

    @Override
    public BeamGroup clone() {
        return new BeamGroup(null, getConnected());
    }

    @Override
    public String toString() {
        return "BeamGroup{} " + super.toString();
    }
}
