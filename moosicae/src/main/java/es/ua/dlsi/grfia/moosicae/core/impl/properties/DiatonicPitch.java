package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IDiatonicPitch;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class DiatonicPitch extends EnumCoreProperty<EDiatonicPitches> implements IDiatonicPitch {
    public DiatonicPitch(IId id, @NotNull EDiatonicPitches enumValue) {
        super(id, enumValue);
    }

    @Override
    public DiatonicPitch clone() {
        return new DiatonicPitch(null, value);
    }

}
