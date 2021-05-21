package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IConnector;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.IMeiSectionItem;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIMeasure;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEISection;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEISectionBuilder extends MEIObjectBuilder<MEISection> {
    private final List<IMeiSectionItem> sectionItemList;
    private final List<IConnector> connectorList;

    public MEISectionBuilder() {
        this.sectionItemList = new LinkedList<>();
        this.connectorList = new LinkedList<>();
    }

    public MEISectionBuilder add(IMeiSectionItem sectionItem) {
        this.sectionItemList.add(sectionItem);
        return this;
    }

    public MEISectionBuilder add(IConnector connector) {
        this.connectorList.add(connector);
        return this;
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {

    }

    @Override
    public MEISection build() throws IMException {
        return new MEISection(getId(), sectionItemList.toArray(new IMeiSectionItem[0]), connectorList.toArray(new IConnector[0]));
    }
}
