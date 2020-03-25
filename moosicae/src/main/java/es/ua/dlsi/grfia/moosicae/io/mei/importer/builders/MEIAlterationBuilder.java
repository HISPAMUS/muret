package es.ua.dlsi.grfia.moosicae.io.mei.importer.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IAlterationBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.properties.IAlteration;
import es.ua.dlsi.grfia.moosicae.io.IImporterAdapter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporterParam;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIAlterationBuilder extends IAlterationBuilder implements IImporterAdapter<IAlteration, XMLImporterParam> {
    public MEIAlterationBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    @Override
    public void read(XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> accidGes = xmlImporterParam.getAttribute("accid.ges"); //TODO resto de parámetros
        if (accidGes.isPresent()) {
            EAccidentalSymbols eAccidentalSymbol;
            switch (accidGes.get()) {
                case "fff":
                    eAccidentalSymbol = EAccidentalSymbols.TRIPLE_FLAT;
                    break;
                case "ff":
                    eAccidentalSymbol = EAccidentalSymbols.DOUBLE_FLAT;
                    break;
                case "f":
                    eAccidentalSymbol = EAccidentalSymbols.FLAT;
                    break;
                case "n":
                    eAccidentalSymbol = EAccidentalSymbols.NATURAL;
                    break;
                case "s":
                    eAccidentalSymbol = EAccidentalSymbols.SHARP;
                    break;
                case "ss":
                    eAccidentalSymbol = EAccidentalSymbols.DOUBLE_SHARP;
                    break;
                default:
                    throw new IMException("Unknown accidental symbol '" + accidGes.get() + "'");
            }
            from(eAccidentalSymbol);
        }
    }
}
