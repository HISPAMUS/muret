package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IAlterationBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.properties.IAlteration;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmAlterationBuilder extends IAlterationBuilder implements IImporterAdapter<IAlteration, XMLImporterParam> {

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        int alter = Integer.parseInt(xmlImporterParam.getCharacters().get());
        from(EAccidentalSymbols.fromSemitonesAlteration(alter));
    }
}
