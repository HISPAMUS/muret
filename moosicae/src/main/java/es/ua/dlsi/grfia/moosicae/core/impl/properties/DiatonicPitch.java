package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IDiatonicPitch;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class DiatonicPitch extends EnumCoreProperty<EDiatonicPitches> implements IDiatonicPitch {
    public DiatonicPitch(@NotNull IId id, @NotNull EDiatonicPitches enumValue) {
        super(id, enumValue);
    }

    @Override
    public DiatonicPitch clone() {
        return new DiatonicPitch(IdGenerator.getInstance().generateUniqueId(), value);
    }

}
