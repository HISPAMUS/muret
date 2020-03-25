package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.ICoreObject;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public abstract class MEIObjectBuilder<ObjectType extends ICoreObject> extends CoreObjectBuilder<ObjectType> implements IImporterAdapter<ObjectType, XMLImporterParam> {
    public MEIObjectBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        // all MEI objects may have an xml:id element that will be used as ID in the core object
        if (xmlImporterParam.hasAttributes()) {
            Optional<String> xmlID = xmlImporterParam.getAttribute("xml:id");
            if (xmlID.isPresent()) {
                this.from(coreObjectFactory.createId(xmlID.get()));
            }
        }
        readMEI(xmlImporterParam);
    }

    protected abstract void readMEI(XMLImporterParam xmlImporterParam) throws IMException;
}
