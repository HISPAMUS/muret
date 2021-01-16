package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 06/04/2020
 */
public class MEIMeterSigGrpBuilder extends MEIObjectBuilder<IMeter> implements IImporterAdapter<IMeter, XMLImporterParam> {
    private String func;
    private List<IMeter> submeters;

    public MEIMeterSigGrpBuilder() {
        this.submeters = new LinkedList<>();
    }

    public MEIMeterSigGrpBuilder add(IMeter meter) {
        submeters.add(meter);
        return this;
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> ofunc = xmlImporterParam.getAttribute("func");
        if (ofunc.isPresent()) {
            func = ofunc.get();
        }
    }

    @Override
    public IMeter build() throws IMException {
        if (func == null) {
            throw new IMException("Missing attribute func");
        }

        if (submeters.size() < 2) {
            throw new IMException("Expecting at least 2 submeters in a meterSigGrp");
        }

        switch (func) {
            case "mixed":
                return ICoreAbstractFactory.getInstance().createMixedMeter(getId(), submeters.toArray(new IMeter[0]));
            case "alternating":
                return ICoreAbstractFactory.getInstance().createAlternatingMeter(getId(), submeters.toArray(new IMeter[0]));
            case "interchanging":
                if (submeters.size() != 2) {
                    throw new IMException("Expecting 2 submeters");
                }
                return ICoreAbstractFactory.getInstance().createInterchangingMeter(getId(), submeters.get(0), submeters.get(1));
            default:
                throw new IMException("Unknown func attribute: '" + func + "'");
        }
    }
}
