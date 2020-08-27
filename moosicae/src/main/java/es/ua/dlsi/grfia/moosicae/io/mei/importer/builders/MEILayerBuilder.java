package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IVoicedItem;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEILayer;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MEILayerBuilder extends MEIObjectBuilder<MEILayer> {
    private Integer n;
    private final List<IVoicedItem> coreItemList;


    public MEILayerBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
        coreItemList = new LinkedList<>();
    }

    public void add(IVoicedItem coreItem) {
        this.coreItemList.add(coreItem);
    }

    @Override
    public MEILayer build() throws IMException {
        return new MEILayer(getId(), coreItemList.toArray(new IVoicedItem[coreItemList.size()]), n);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        MEIObjectBuilder.readMEI(this, xmlImporterParam);
        Optional<String> nattr = xmlImporterParam.getAttribute("n");
        if (nattr.isPresent()) {
            n = Integer.parseInt(nattr.get());
        }

    }
}
