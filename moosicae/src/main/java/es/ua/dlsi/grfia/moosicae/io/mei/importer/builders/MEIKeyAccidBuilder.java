package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IPitchClassBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 02/04/2020
 */
public class MEIKeyAccidBuilder extends IPitchClassBuilder implements IImporterAdapter<IPitchClass, XMLImporterParam> {
    public MEIKeyAccidBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<EDiatonicPitches> diatonicPitch = MEIAttributesParsers.getInstance().parseDiatonicPitch(xmlImporterParam);
        Optional<EAccidentalSymbols> accidentalSymbol = MEIAttributesParsers.getInstance().parseAccidentalSymbol(xmlImporterParam, "accid");
        if (diatonicPitch.isPresent() || accidentalSymbol.isPresent()) {
            if (!diatonicPitch.isPresent() || !accidentalSymbol.isPresent()) {
                throw new IMException("Both pname and accid must be present in keyAccid");
            }

            from(coreObjectFactory.createDiatonicPitch(null, diatonicPitch.get()));
            from(coreObjectFactory.createAccidentalSymbol(null, accidentalSymbol.get()));
        }
    }
}
