package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements.IMxmlPartItem;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements.MxmlMeasure;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class MxmlMeasureBuilder extends CoreObjectBuilder<MxmlMeasure> implements IImporterAdapter<MxmlMeasure, XMLImporterParam>  {
    private final List<IMxmlPartItem> items;

    public MxmlMeasureBuilder() {
        this.items = new LinkedList<>();
    }

    public void add(IMxmlPartItem voiced) {
        this.items.add(voiced);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> id = xmlImporterParam.getAttribute("id");
        if (id.isPresent()) {
            from(ICoreAbstractFactory.getInstance().createId(id.get()));
        }
    }

    @Override
    public MxmlMeasure build() throws IMException {
        return new MxmlMeasure(getId(), items.toArray(new IMxmlPartItem[items.size()]));
    }
}
