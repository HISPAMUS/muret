package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.IConnector;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import java.util.Arrays;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEISection extends MEIObject {
    private final MEIMeasure [] measures;
    private final IConnector[] connectors;

    public MEISection(IId id, MEIMeasure [] measures, IConnector [] connectors) {
        super(id);
        this.measures = measures;
        this.connectors = connectors;
    }

    public MEIMeasure[] getMeasures() {
        return measures;
    }

    public IConnector[] getConnectors() {
        return connectors;
    }

    @Override
    public MEISection clone() {
        return new MEISection(null, measures.clone(), connectors.clone());
    }

    @Override
    public String toString() {
        return "MEISection{" +
                "measures=" + Arrays.toString(measures) +
                "connectors=" + Arrays.toString(connectors) +
                "} " + super.toString();
    }

}
