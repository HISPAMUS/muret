package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.IName;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmlNameBuilder extends CoreObjectBuilder<IName> implements IImporterAdapter<IName, XMLImporterParam> {
    private String value;

    public MxmlNameBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public IName build() throws IMException {
        return coreObjectFactory.createName(getId(), value);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> value = xmlImporterParam.getCharacters();
        if (value.isPresent()) {
            this.value = value.get();
        }
    }
}
