package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IFractionalTimeSignature;
import es.ua.dlsi.grfia.moosicae.core.builders.IFractionalTimeSignatureBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.ETimeSignatureSymbols;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmTimeSignatureBuilder extends IFractionalTimeSignatureBuilder implements IImporterAdapter<IFractionalTimeSignature, XMLImporterParam> {
    public MxmTimeSignatureBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> symbol = xmlImporterParam.getAttribute("symbol");
        if (symbol.isPresent()) {
            switch (symbol.get()) {
                case "common":
                    from(ETimeSignatureSymbols.common);
                    break;
                case "cut":
                    from(ETimeSignatureSymbols.cut);
                    break;
                default:
                    throw new IMException("Unkown time signature symbol: '" + symbol.get() + "'");
            }
        }
    }
}
