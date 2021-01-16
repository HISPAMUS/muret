package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IDiatonicPitchBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import es.ua.dlsi.grfia.moosicae.core.properties.IDiatonicPitch;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLCorePropertyReaders;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmlDiatonicPitchBuilder extends IDiatonicPitchBuilder implements IImporterAdapter<IDiatonicPitch, XMLImporterParam> {

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        if (xmlImporterParam.getCharacters().isPresent()) {
            from(XMLCorePropertyReaders.readCharacters(EDiatonicPitches.class, xmlImporterParam));
        }
    }
}
