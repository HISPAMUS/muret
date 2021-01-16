package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.ETimeSignatureSymbols;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Usually we will find just a pair of elements (beat, beat-type). However, in the case of mixed meters, they are repeated
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmTimeSignatureBuilder extends CoreObjectBuilder<IMeter> implements IImporterAdapter<IMeter, XMLImporterParam> {
    private List<ITimeSignatureNumerator> numeratorList;
    private List<ITimeSignatureDenominator> denominatorList;
    private ETimeSignatureSymbols timeSignatureSymbol;
    private IMeter interchangeableRightMeter;

    public MxmTimeSignatureBuilder() {
        numeratorList = new LinkedList<>();
        denominatorList = new LinkedList<>();
    }

    public MxmTimeSignatureBuilder add(ITimeSignatureNumerator numerator) {
        this.numeratorList.add(numerator);
        return this;
    }

    public MxmTimeSignatureBuilder add(ITimeSignatureDenominator denominator) {
        this.denominatorList.add(denominator);
        return this;
    }


    public MxmTimeSignatureBuilder from(IMeter interchangeableRightMeter) {
        this.interchangeableRightMeter = interchangeableRightMeter;
        return this;
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> symbol = xmlImporterParam.getAttribute("symbol");
        if (symbol.isPresent()) {
            switch (symbol.get()) {
                case "common":
                    timeSignatureSymbol = ETimeSignatureSymbols.common;
                    break;
                case "cut":
                    timeSignatureSymbol = ETimeSignatureSymbols.cut;
                    break;
                default:
                    throw new IMException("Unknown time signature symbol: '" + symbol.get() + "'");
            }
        }
    }

    @Override
    public IMeter build() throws IMException {
        IMeter meter = null;
        if (timeSignatureSymbol != null) {
            switch (timeSignatureSymbol) {
                case common:
                    meter = ICoreAbstractFactory.getInstance().createCommonTime(getId());
                    break;
                case cut:
                    meter = ICoreAbstractFactory.getInstance().createCutTime(getId());
                    break;
                default:
                    throw new IMException("Unknown time signature symbol: '" + timeSignatureSymbol + "'");
            }
        } else {
            if (numeratorList.size() != denominatorList.size()) {
                throw new IMException("The number of <beat> (#" + numeratorList.size() + ") is different to those of <beat-type> (#" + denominatorList.size() + ")");
            }
            if (numeratorList.isEmpty()) {
                throw new IMException("At least a symbol or a pair <beat>-<beat-type> is required");
            }

            if (numeratorList.size() == 1) {
                meter = ICoreAbstractFactory.getInstance().createStandardTimeSignature(getId(), numeratorList.get(0), denominatorList.get(0));
            } else {
                // check if all denominators are the same
                boolean isAdditiveMeter = true;
                ITimeSignatureDenominator last = null;
                for (ITimeSignatureDenominator denominator: denominatorList) {
                    if (last != null && !denominator.equals(last)) {
                        isAdditiveMeter = false;
                        break;
                    }
                    last = denominator;
                }
                if (isAdditiveMeter) {
                    meter = ICoreAbstractFactory.getInstance().createAdditiveMeter(getId(), numeratorList.toArray(new ITimeSignatureNumerator[0]), denominatorList.get(0));
                } else {
                    IMeter [] submeters = new IMeter[numeratorList.size()];
                    for (int i=0; i<submeters.length; i++) {
                        submeters[i] = ICoreAbstractFactory.getInstance().createStandardTimeSignature(null, numeratorList.get(i), denominatorList.get(i));
                    }
                    meter = ICoreAbstractFactory.getInstance().createMixedMeter(getId(), submeters);
                }
            }
        }
        if (interchangeableRightMeter != null) {
            return ICoreAbstractFactory.getInstance().createInterchangingMeter(getId(), meter, interchangeableRightMeter);
        } else {
            return meter;
        }
    }
}
