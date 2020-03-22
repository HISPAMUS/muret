package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IAccidentalCore;
import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class AccidentalCore extends EnumBased<EAccidentalSymbols> implements IAccidentalCore {
    AccidentalCore(@NotNull IId id, @NotNull EAccidentalSymbols enumValue) {
        super(id, enumValue);
    }

    @Override
    public AccidentalCore clone() {
        return new AccidentalCore(IdGenerator.getInstance().generateUniqueId(), enumValue);
    }

    @Override
    public EAccidentalSymbols getValue() {
        return enumValue;
    }

}
