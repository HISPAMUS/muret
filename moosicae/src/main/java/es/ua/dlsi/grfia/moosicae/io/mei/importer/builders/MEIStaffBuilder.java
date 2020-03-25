package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEILayer;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIStaff;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MEIStaffBuilder extends MEIObjectBuilder<MEIStaff> {
    private final List<MEILayer> layers;

    public MEIStaffBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
        layers = new LinkedList<>();
    }

    @Override
    protected void readMEI(XMLImporterParam xmlImporterParam) {
    }

    public void add(MEILayer layer) {
        this.layers.add(layer);
    }

    @Override
    public MEIStaff build() throws IMException {
        return new MEIStaff(getId(), layers.toArray(new MEILayer[layers.size()]));
    }
}
