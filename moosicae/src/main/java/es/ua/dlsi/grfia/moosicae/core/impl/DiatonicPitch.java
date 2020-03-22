package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDiatonicPitch;
import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class DiatonicPitch extends EnumBased<EDiatonicPitches> implements IDiatonicPitch {
    DiatonicPitch(@NotNull IId id, @NotNull EDiatonicPitches enumValue) {
        super(id, enumValue);
    }

    @Override
    public DiatonicPitch clone() {
        return new DiatonicPitch(IdGenerator.getInstance().generateUniqueId(), enumValue);
    }

    @Override
    public EDiatonicPitches getValue() {
        return enumValue;
    }
}
