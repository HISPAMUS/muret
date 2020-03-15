package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IClefSign;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class ClefSign extends EnumBased<EClefSigns> implements IClefSign {
    public ClefSign(EClefSigns enumValue) {
        super(enumValue);
    }

    @Override
    public ClefSign clone() {
        return new ClefSign(enumValue);
    }

    @Override
    public EClefSigns getClefSign() {
        return enumValue;
    }
}
