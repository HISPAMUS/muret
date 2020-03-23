package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class AccidentalSymbol extends EnumCoreProperty<EAccidentalSymbols> implements IAccidentalSymbol {
    public AccidentalSymbol(@NotNull IId id, @NotNull EAccidentalSymbols enumValue) {
        super(id, enumValue);
    }

    @Override
    public AccidentalSymbol clone() {
        return new AccidentalSymbol(IdGenerator.getInstance().generateUniqueId(), value);
    }


}
