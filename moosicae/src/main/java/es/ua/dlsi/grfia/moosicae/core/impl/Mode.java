package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IMode;
import es.ua.dlsi.grfia.moosicae.core.enums.EModes;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class Mode extends EnumBased<EModes> implements IMode {
    public Mode(EModes enumValue) {
        super(enumValue);
    }

    @Override
    public Mode clone() {
        return new Mode(enumValue);
    }

    @Override
    public EModes getMode() {
        return enumValue;
    }
}
