package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.IKeyAccidentalCount;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmlFifthsBuilder extends CoreObjectBuilder<IKeyAccidentalCount> implements IImporterAdapter<IKeyAccidentalCount, XMLImporterParam> {
    private Integer value;
    public MxmlFifthsBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> characters = xmlImporterParam.getCharacters();
        if (characters.isPresent()) {
            this.value = Integer.parseInt(characters.get());
        }
    }

    @Override
    public IKeyAccidentalCount build() throws IMException {
        return coreObjectFactory.createKeyAccidentalCount(getId(), value);
    }
}