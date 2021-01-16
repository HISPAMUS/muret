package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
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
    private final List<MEIMeasure> measureList;

    public MEISectionBuilder() {
        this.measureList = new LinkedList<>();
    }

    public MEISectionBuilder add(MEIMeasure measure) {
        this.measureList.add(measure);
        return this;
    }


    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {

    }

    @Override
    public MEISection build() throws IMException {
        return new MEISection(getId(), measureList.toArray(new MEIMeasure[0]));
    }
}
