package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.ITimeSignatureDenominator;
import es.ua.dlsi.grfia.moosicae.core.ITimeSignatureNumerator;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 06/04/2020
 */
public class MEIMeterSigBuilder extends MEIObjectBuilder<IMeter> implements IImporterAdapter<IMeter, XMLImporterParam> {
    private String count;
    private String unit;
    private String sym;

    public MEIMeterSigBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> osym = xmlImporterParam.getAttribute("sym");
        if (osym.isPresent()) {
            sym = osym.get();
        }

        Optional<String> ocount = xmlImporterParam.getAttribute("count");
        if (ocount.isPresent()) {
            count = ocount.get();
        }

        Optional<String> ounit = xmlImporterParam.getAttribute("unit");
        if (ounit.isPresent()) {
            unit = ounit.get();
        }
    }

    @Override
    public IMeter build() throws IMException {
        if (sym != null) {
            switch (sym) {
                case "common":
                    return coreObjectFactory.createCommonTime(getId());
                case "cut":
                    return coreObjectFactory.createCutTime(getId());
                default:
                    throw new IMException("Unsupported meter sym: '" + sym);
            }
        } else if (count == null || unit == null) {
            throw new IMException("If sym is not present, both count and unit should be specified");
        } else {
            ITimeSignatureDenominator denominator = coreObjectFactory.createTimeSignatureDenominator(null, Integer.parseInt(unit));

            String [] numeratorsStr = count.split("\\+");
            if (numeratorsStr.length == 1) {
                ITimeSignatureNumerator numerator = coreObjectFactory.createTimeSignatureNumerator(null, Integer.parseInt(count));
                return coreObjectFactory.createStandardTimeSignature(null, numerator, denominator);
            } else {
                ITimeSignatureNumerator [] numerators = new ITimeSignatureNumerator[numeratorsStr.length];
                for (int i=0; i<numerators.length; i++) {
                    numerators[i] = coreObjectFactory.createTimeSignatureNumerator(null, Integer.parseInt(numeratorsStr[i]));
                }
                return coreObjectFactory.createAdditiveMeter(null, numerators, denominator);
            }
        }
    }
}
