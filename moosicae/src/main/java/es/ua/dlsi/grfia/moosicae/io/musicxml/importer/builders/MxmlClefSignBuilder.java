package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IClefSignBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefSign;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLCorePropertyReaders;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmlClefSignBuilder extends IClefSignBuilder implements IImporterAdapter<IClefSign, XMLImporterParam> {
    public MxmlClefSignBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        if (xmlImporterParam.getCharacters().isPresent()) {
            from(XMLCorePropertyReaders.readCharacters(EClefSigns.class, xmlImporterParam));
        }
    }
}
