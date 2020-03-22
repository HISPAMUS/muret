package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class AccidentalSymbol extends EnumCoreProperty<EAccidentalSymbols> implements IAccidentalSymbol {
    AccidentalSymbol(@NotNull IId id, @NotNull EAccidentalSymbols enumValue) {
        super(id, enumValue);
    }

    @Override
    public AccidentalSymbol clone() {
        return new AccidentalSymbol(IdGenerator.getInstance().generateUniqueId(), enumValue);
    }

    @Override
    public EAccidentalSymbols getValue() {
        return enumValue;
    }

}
