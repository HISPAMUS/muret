package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IClef;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IFermata;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEIFermata;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIFermataBuilder extends CoreObjectBuilder<MEIFermata> implements IImporterAdapter<MEIFermata, XMLImporterParam> {
    private String startId;

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        MEIObjectBuilder.readMEI(this, xmlImporterParam);

        //TODO position
        Optional<String> startIdAttr = xmlImporterParam.getAttribute("startid");
        if (startIdAttr.isPresent()) {
            this.startId = MEIObjectBuilder.getReferencedId(startIdAttr.get());
        } else {
            throw new IMException("Expected a startid attribute in fermata");
        }
    }

    @Override
    public MEIFermata build() throws IMException {
        MEIFermata meiFermata = new MEIFermata(getId(), ICoreAbstractFactory.getInstance().createId(startId));
        return meiFermata;
    }
}
