package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.ITie;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class MxmlTie extends MxmlObject implements IImporterAdapter<ITie, XMLImporterParam> {

    protected MxmlTie(IId id) {
        super(id);
    }

    @Override
    public MxmlObject clone() {
        return null;
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {

    }

    @Override
    public ITie build() throws IMException {
        return null;
    }
}
