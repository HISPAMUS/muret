package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import java.util.Arrays;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEISection extends MEIObject {
    private final MEIMeasure [] measures;

    public MEISection(IId id, MEIMeasure [] measures) {
        super(id);
        this.measures = measures;
    }

    public MEIMeasure[] getMeasures() {
        return measures;
    }

    @Override
    public MEISection clone() {
        return new MEISection(null, measures.clone());
    }

    @Override
    public String toString() {
        return "MEISection{" +
                "measures=" + Arrays.toString(measures) +
                "} " + super.toString();
    }
}
