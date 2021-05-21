package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.properties.ITimeSignatureDenominator;
import es.ua.dlsi.grfia.moosicae.core.properties.ITimeSignatureNumerator;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 06/04/2020
 */
public class MEIMeterSigBuilder extends MEIObjectBuilder<IMeter> implements IImporterAdapter<IMeter, XMLImporterParam> {
    private String count;
    private String unit;
    private String sym;


    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        MEIObjectBuilder.readMEI(this, xmlImporterParam);
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
                    return ICoreAbstractFactory.getInstance().createCommonTime(getId());
                case "cut":
                    return ICoreAbstractFactory.getInstance().createCutTime(getId());
                default:
                    throw new IMException("Unsupported meter sym: '" + sym);
            }
        } else if (count == null || unit == null) {
            throw new IMException("If sym is not present, both count and unit should be specified");
        } else {
            ITimeSignatureDenominator denominator = ICoreAbstractFactory.getInstance().createTimeSignatureDenominator(null, Integer.parseInt(unit));

            String [] numeratorsStr = count.split("\\+");
            if (numeratorsStr.length == 1) {
                ITimeSignatureNumerator numerator = ICoreAbstractFactory.getInstance().createTimeSignatureNumerator(null, Integer.parseInt(count));
                return ICoreAbstractFactory.getInstance().createStandardTimeSignature(null, numerator, denominator);
            } else {
                ITimeSignatureNumerator [] numerators = new ITimeSignatureNumerator[numeratorsStr.length];
                for (int i=0; i<numerators.length; i++) {
                    numerators[i] = ICoreAbstractFactory.getInstance().createTimeSignatureNumerator(null, Integer.parseInt(numeratorsStr[i]));
                }
                return ICoreAbstractFactory.getInstance().createAdditiveMeter(null, numerators, denominator);
            }
        }
    }
}
