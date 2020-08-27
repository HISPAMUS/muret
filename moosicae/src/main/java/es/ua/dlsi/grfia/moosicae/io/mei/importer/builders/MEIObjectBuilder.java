package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMooObject;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public abstract class MEIObjectBuilder<ObjectType extends IMooObject> extends CoreObjectBuilder<ObjectType> implements IImporterAdapter<ObjectType, XMLImporterParam> {
    public MEIObjectBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    /**
     * This element is static because not all elements will derive from MEIObjectBuilder but from others such as INoteBuilder
     * @param meiObjectBuilder
     * @param xmlImporterParam
     * @throws IMException
     */
    public static void readMEI(MEIObjectBuilder meiObjectBuilder, XMLImporterParam xmlImporterParam) throws IMException {
        // all MEI objects may have an xml:id element that will be used as ID in the core object
        if (xmlImporterParam.hasAttributes()) {
            Optional<String> xmlID = xmlImporterParam.getAttribute("xml:id");
            if (xmlID.isPresent()) {
                meiObjectBuilder.from(meiObjectBuilder.coreObjectFactory.createId(xmlID.get()));
            }
        }
    }
}
