package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IClef;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IClefBuilder;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIClefBuilder extends CoreObjectBuilder<IClef> implements IImporterAdapter<IClef, XMLImporterParam> {
    private IClef clef;
    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<IClef> clef = MEIAttributesParsers.getInstance().parseClef(xmlImporterParam, false);
        if (clef.isPresent()) {
            this.clef = clef.get();
        }
    }

    @Override
    public IClef build() throws IMException {
        return clef;
    }
}
