package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IBeamGroup;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;
import es.ua.dlsi.grfia.moosicae.core.builders.IBeamGroupBuilder;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIBeam;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 06/04/2020
 */
public class MEIBeamBuilder extends IBeamGroupBuilder implements IImporterAdapter<IBeamGroup, XMLImporterParam> {

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        MEIObjectBuilder.readMEI(this, xmlImporterParam);
    }

    /**
     * This object,
     * @return
     * @throws IMException
     */
    @Override
    public MEIBeam build() throws IMException {
        IBeamGroup beamGroup = super.build();
        MEIBeam beam = new MEIBeam(beamGroup);
        return beam;
    }
}
