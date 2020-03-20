package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class AccidentalSymbol extends EnumBased<EAccidentalSymbols> implements IAccidentalSymbol {
    public AccidentalSymbol(EAccidentalSymbols enumValue) {
        super(enumValue);
    }

    @Override
    public AccidentalSymbol clone() {
        return new AccidentalSymbol(enumValue);
    }

    @Override
    public EAccidentalSymbols getAccidentalSymbol() {
        return enumValue;
    }
}
