package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IPart;
import es.ua.dlsi.grfia.moosicae.core.builders.IPartBuilder;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MxmlPartDefinitionBuilder extends IPartBuilder implements IImporterAdapter<IPart, XMLImporterParam> {
    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> id = xmlImporterParam.getAttribute("id");
        if (id.isPresent()) {
            from(ICoreAbstractFactory.getInstance().createId(id.get()));
        }
    }
}
