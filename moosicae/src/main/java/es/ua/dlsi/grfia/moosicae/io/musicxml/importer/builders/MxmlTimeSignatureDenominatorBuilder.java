package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.properties.ITimeSignatureDenominator;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.ITimeSignatureDenominatorBuilder;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmlTimeSignatureDenominatorBuilder extends ITimeSignatureDenominatorBuilder implements IImporterAdapter<ITimeSignatureDenominator, XMLImporterParam> {

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> characters = xmlImporterParam.getCharacters();
        if (characters.isPresent()) {
            this.value = Integer.parseInt(characters.get());
        }
    }
}
