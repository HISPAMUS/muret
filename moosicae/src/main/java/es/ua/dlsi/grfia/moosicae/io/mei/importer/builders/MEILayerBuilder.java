package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.ICoreItem;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEILayer;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MEILayerBuilder extends MEIObjectBuilder<MEILayer> {
    private final List<ICoreItem> coreItemList;

    public MEILayerBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
        coreItemList = new LinkedList<>();
    }

    @Override
    protected void readMEI(XMLImporterParam xmlImporterParam) throws IMException {

    }

    public void add(ICoreItem coreItem) {
        this.coreItemList.add(coreItem);
    }

    @Override
    public MEILayer build() throws IMException {
        return new MEILayer(getId(), coreItemList.toArray(new ICoreItem[coreItemList.size()]));
    }
}
