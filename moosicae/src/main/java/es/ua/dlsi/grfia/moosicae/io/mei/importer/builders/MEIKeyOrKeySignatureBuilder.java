package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.properties.ICautionaryKeySignatureAccidentals;
import es.ua.dlsi.grfia.moosicae.core.properties.IKeyAccidentalCount;
import es.ua.dlsi.grfia.moosicae.core.properties.IMode;
import es.ua.dlsi.grfia.moosicae.io.commonbuilders.KeyOrKeySignatureBuilder;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 02/04/2020
 */
public class MEIKeyOrKeySignatureBuilder extends KeyOrKeySignatureBuilder {
    public MEIKeyOrKeySignatureBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        super.read(xmlImporterParam);

        Optional<IMode> mode = MEIAttributesParsers.getInstance().parseMode(coreObjectFactory, xmlImporterParam, "mode");
        if (mode.isPresent()) {
            from(mode.get());
        }

        Optional<String> showChange = xmlImporterParam.getAttribute("keysig.showchange");
        ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals = null;
        if (showChange.isPresent() && showChange.get().equals("true")) {
            from(coreObjectFactory.createCautionaryKeySignatureAccidentals(null, true));
        }

        Optional<Pair<Integer, Optional<EAccidentalSymbols>>> pairKeySignature = MEIAttributesParsers.getInstance().parseConventionalKeySignatureAttribute(xmlImporterParam, "sig");
        if (pairKeySignature.isPresent()) {
            int naccidentals = pairKeySignature.get().getLeft();
            IKeyAccidentalCount keyAccidentalCount = coreObjectFactory.createKeyAccidentalCount(null, naccidentals);
            from(keyAccidentalCount);

            EAccidentalSymbols eaccidentalSymbol = pairKeySignature.get().getRight().get();
            from(eaccidentalSymbol);
        }
    }
}
