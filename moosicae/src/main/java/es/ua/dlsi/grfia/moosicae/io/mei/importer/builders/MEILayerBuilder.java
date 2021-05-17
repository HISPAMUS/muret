package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;
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
    private final List<IVoiced> items;


    public MEILayerBuilder() {
        items = new LinkedList<>();
    }

    public void add(IVoiced coreItem) {
        this.items.add(coreItem);
    }

    @Override
    public MEILayer build() throws IMException {
        return new MEILayer(getId(), items.toArray(new IVoiced[items.size()]), n);
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
