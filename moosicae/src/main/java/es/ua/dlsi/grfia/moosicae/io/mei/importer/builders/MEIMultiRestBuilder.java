package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMultimeasureRest;
import es.ua.dlsi.grfia.moosicae.core.IRest;
import es.ua.dlsi.grfia.moosicae.core.builders.IMultimeasureRestBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IRestBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 20/05/2021
 */
public class MEIMultiRestBuilder extends IMultimeasureRestBuilder implements IImporterAdapter<IMultimeasureRest, XMLImporterParam> {
    public MEIMultiRestBuilder() {
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        MEIObjectBuilder.readMEI(this, xmlImporterParam);
        Optional<String> countStr = xmlImporterParam.getAttribute("num");
        if (countStr.isPresent()) {
            this.from(ICoreAbstractFactory.getInstance().createMultimeasureRestCount(null, Integer.parseInt(countStr.get())));
        } else {
            throw new IMException("Expected a count attribute in multiRest");
        }
    }

    @Override
    public IMultimeasureRest build() throws IMException {
        return super.build();
    }
}
