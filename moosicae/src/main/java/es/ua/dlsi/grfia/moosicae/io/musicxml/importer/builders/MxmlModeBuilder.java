package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.IModeBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EModes;
import es.ua.dlsi.grfia.moosicae.core.properties.IMode;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLCorePropertyReaders;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmlModeBuilder extends IModeBuilder implements IImporterAdapter<IMode, XMLImporterParam> {
    public MxmlModeBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        from(XMLCorePropertyReaders.readCharacters(EModes.class, xmlImporterParam));
    }
}
