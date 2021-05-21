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

    private static final String HASH = "#";

    /**
     * This element is static because not all elements will derive from MEIObjectBuilder but from others such as INoteBuilder
     * @param meiObjectBuilder
     * @param xmlImporterParam
     * @throws IMException
     */
    public static void readMEI(CoreObjectBuilder meiObjectBuilder, XMLImporterParam xmlImporterParam) throws IMException {
        // all MEI objects may have an xml:id element that will be used as ID in the core object
        if (xmlImporterParam.hasAttributes()) {
            Optional<String> xmlID = xmlImporterParam.getAttribute("id"); //xml:id, the parser removes the namespace
            if (xmlID.isPresent()) {
                meiObjectBuilder.from(ICoreAbstractFactory.getInstance().createId(xmlID.get()));
            }
        }
    }

    /**
     * This element is static because not all elements will derive from MEIObjectBuilder but from others such as INoteBuilder.
     * It checks the element starts with a '#' and removes it
     * @param targetId
     * @return
     */
    public static String getReferencedId(String targetId) throws IMException {
        if (!targetId.startsWith(HASH)) {
            throw new IMException("The target id '" + targetId + "' does not start with a '#'");
        }
        return targetId.substring(1);
    }

}
