package es.ua.dlsi.grfia.moosicae.io.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IDiatonicPitch;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IDiatonicPitchBuilder extends CoreObjectBuilder<IDiatonicPitch> {
    private EDiatonicPitches diatonicPitch;
    public IDiatonicPitchBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setDiatonicPitch(EDiatonicPitches diatonicPitch) {
        this.diatonicPitch = diatonicPitch;
    }

    @Override
    public IDiatonicPitch build() throws IMException {
        assertRequired("diatonicPitch", diatonicPitch);
        return coreObjectFactory.createDiatonicPitch(diatonicPitch);
    }
}
