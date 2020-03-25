package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.builders.IObjectBuilder;

/**
 * It adapts the specific format (i.e. xml) properties (in the case of XML there will be attributes and element characters)
 * into core builder properties (assigned using methods named "from")
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public interface IImporterAdapter<BuiltObjectType, ImporterParameterType> extends IObjectBuilder<BuiltObjectType> {
    void read(ImporterParameterType importerParameterType) throws IMException;
}
