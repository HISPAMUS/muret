package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements.MxmlMeasure;
import es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements.MxmlPartContents;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class MxmlPartContentsBuilder extends CoreObjectBuilder<MxmlPartContents> implements IImporterAdapter<MxmlPartContents, XMLImporterParam>  {
    private final List<MxmlMeasure> items;

    public MxmlPartContentsBuilder(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);
        this.items = new LinkedList<>();
    }

    public void add(MxmlMeasure measure) {
        this.items.add(measure);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> id = xmlImporterParam.getAttribute("id");
        if (id.isPresent()) {
            from(coreObjectFactory.createId(id.get()));
        }
    }

    @Override
    public MxmlPartContents build() throws IMException {
        return new MxmlPartContents(getId(), items.toArray(new MxmlMeasure[items.size()]));
    }
}
