package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IBeamGroup;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;
import es.ua.dlsi.grfia.moosicae.core.builders.IBeamGroupBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IConnectorBuilder;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIBeam;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * See MEIBeam javadoc
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 06/04/2020
 */
public class MEIBeamBuilder extends IBeamGroupBuilder implements IImporterAdapter<IBeamGroup, XMLImporterParam> {

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        MEIObjectBuilder.readMEI(this, xmlImporterParam);
    }

    public IConnectorBuilder add(IVoiced child) {
        this.connected.add(child);
        return this;
    }

    /**
     * This object,
     * @return
     * @throws IMException
     */
    @Override
    public MEIBeam build() throws IMException {
        IBeamGroup beamGroup = super.build();
        MEIBeam beam = new MEIBeam(beamGroup.getId());
        for (IVoiced connected: beamGroup.getConnected()) {
            beam.add(connected);
        }
        return beam;
    }
}
