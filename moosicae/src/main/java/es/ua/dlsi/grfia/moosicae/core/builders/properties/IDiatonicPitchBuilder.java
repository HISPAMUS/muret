package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import es.ua.dlsi.grfia.moosicae.core.properties.IDiatonicPitch;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IDiatonicPitchBuilder extends CoreObjectBuilder<IDiatonicPitch> {
    private EDiatonicPitches value;

    public IDiatonicPitchBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public IDiatonicPitchBuilder from(EDiatonicPitches value) {
        this.value = value;
        return this;
    }

    @Override
    public IDiatonicPitch build() throws IMException {
        return coreObjectFactory.createDiatonicPitch(getId(), value);
    }


}
