package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.ICautionaryKeySignatureAccidentalsBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.ICautionaryKeySignatureAccidentals;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmlKeyCancelBuilder extends ICautionaryKeySignatureAccidentalsBuilder implements IImporterAdapter<ICautionaryKeySignatureAccidentals, XMLImporterParam> {

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> characters = xmlImporterParam.getCharacters();
        if (characters.isPresent()) {
            // don't need to see what's in (the fifths cancelled)
            from(true);
        }
    }
}
