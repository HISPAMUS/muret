package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMultimeasureRest;
import es.ua.dlsi.grfia.moosicae.core.builders.IMultimeasureRestBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.ITieBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.ITie;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.mei.importer.elements.MEITie;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 20/05/2021
 */
public class MEITieBuilder extends MEIObjectBuilder<MEITie> implements IImporterAdapter<MEITie, XMLImporterParam> {
    String startId;
    String endId;

    public MEITieBuilder() {
    }

    public String getStartId() {
        return startId;
    }

    public String getEndId() {
        return endId;
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        MEIObjectBuilder.readMEI(this, xmlImporterParam);
        Optional<String> startIdAttr = xmlImporterParam.getAttribute("startid");
        if (startIdAttr.isPresent()) {
            this.startId = getReferencedId(startIdAttr.get());
        } else {
            throw new IMException("Expected a startid attribute in tie");
        }
        Optional<String> endIdAttr = xmlImporterParam.getAttribute("endid");
        if (endIdAttr.isPresent()) {
            this.endId = getReferencedId(endIdAttr.get());
        } else {
            throw new IMException("Expected an endid attribute in tie");
        }
    }

    @Override
    public MEITie build() throws IMException {
        return new MEITie(getId(), ICoreAbstractFactory.getInstance().createId(startId), ICoreAbstractFactory.getInstance().createId(endId));
    }
}
