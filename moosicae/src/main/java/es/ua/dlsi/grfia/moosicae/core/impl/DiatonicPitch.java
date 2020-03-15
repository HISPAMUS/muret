package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDiatonicPitch;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class DiatonicPitch extends EnumBased<EDiatonicPitches> implements IDiatonicPitch {
    public DiatonicPitch(EDiatonicPitches enumValue) {
        super(enumValue);
    }

    @Override
    public DiatonicPitch clone() {
        return new DiatonicPitch(enumValue);
    }

    @Override
    public EDiatonicPitches getDiatonicPitch() {
        return enumValue;
    }
}
