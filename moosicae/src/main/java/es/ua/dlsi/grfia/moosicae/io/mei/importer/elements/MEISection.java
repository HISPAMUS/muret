package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.IConnector;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import java.util.Arrays;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEISection extends MEIObject implements IMeiSectionItem {
    private final IMeiSectionItem [] sectionItems;
    private final IConnector[] connectors;

    public MEISection(IId id, IMeiSectionItem [] sectionItems, IConnector [] connectors) {
        super(id);
        this.sectionItems = sectionItems;
        this.connectors = connectors;
    }

    public IMeiSectionItem[] getSectionItems() {
        return sectionItems;
    }

    public IConnector[] getConnectors() {
        return connectors;
    }

    @Override
    public MEISection clone() {
        return new MEISection(null, sectionItems.clone(), connectors.clone());
    }

    @Override
    public String toString() {
        return "MEISection{" +
                "sectionItems=" + Arrays.toString(sectionItems) +
                "connectors=" + Arrays.toString(connectors) +
                "} " + super.toString();
    }

}
