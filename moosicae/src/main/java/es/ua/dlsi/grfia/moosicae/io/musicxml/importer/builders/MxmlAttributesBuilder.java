package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements.MxmlAttributes;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements.MxmlDivisions;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class MxmlAttributesBuilder extends CoreObjectBuilder<MxmlAttributes> implements IImporterAdapter<MxmlAttributes, XMLImporterParam> {
    private List<INonDurational> nonDurationals;
    private MxmlDivisions divisions;

    public MxmlAttributesBuilder() {
        this.nonDurationals = new LinkedList<>();
    }

    public MxmlAttributesBuilder add(INonDurational nonDurational) {
        this.nonDurationals.add(nonDurational);
        return this;
    }

    public MxmlAttributesBuilder from(MxmlDivisions divisions) {
        this.divisions = divisions;
        return this;
    }


    @Override
    public MxmlAttributes build() throws IMException {
        return new MxmlAttributes(getId(), divisions, nonDurationals.toArray(new INonDurational[nonDurationals.size()]));
    }


    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {

    }
}
