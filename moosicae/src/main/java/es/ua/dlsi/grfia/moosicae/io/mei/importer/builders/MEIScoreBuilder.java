package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IConnector;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.IMeiSectionItem;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIScore;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEISection;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIScoreBuilder extends MEIObjectBuilder<MEIScore> {
    private final List<MEISection> sectionList;

    public MEIScoreBuilder() {
        this.sectionList = new LinkedList<>();
    }

    public MEIScoreBuilder add(MEISection section) {
        this.sectionList.add(section);
        return this;
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        MEIObjectBuilder.readMEI(this, xmlImporterParam);
    }

    @Override
    public MEIScore build() throws IMException {
        return new MEIScore(getId(), sectionList.toArray(new MEISection[0]));
    }
}
