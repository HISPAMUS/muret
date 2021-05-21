package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.IConnector;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import java.util.Arrays;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIScore extends MEIObject {
    private final MEISection[] sections;

    public MEIScore(IId id, MEISection[] sections) {
        super(id);
        this.sections = sections;
    }
    @Override
    public MEIScore clone() {
        return new MEIScore(null, sections.clone());
    }

    public MEISection[] getSections() {
        return sections;
    }

    @Override
    public String toString() {
        return "MEIScore{" +
                "sections=" + Arrays.toString(sections) +
                "} " + super.toString();
    }

}
