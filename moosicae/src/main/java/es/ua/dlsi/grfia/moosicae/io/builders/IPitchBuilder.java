package es.ua.dlsi.grfia.moosicae.io.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IPitchBuilder extends CoreObjectBuilder<IPitch> {
    private IOctave octave;
    private IAlteration alteration;
    private IDiatonicPitch diatonicPitch;

    public IPitchBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setOctave(IOctave octave) {
        this.octave = octave;
    }

    public void setAlteration(IAlteration alteration) {
        this.alteration = alteration;
    }

    public void setDiatonicPitch(IDiatonicPitch diatonicPitch) {
        this.diatonicPitch = diatonicPitch;
    }

    @Override
    public IPitch build() throws IMException {
        assertRequired("octave", octave);
        assertRequired("diatonicPitch", diatonicPitch);
        return coreObjectFactory.createPitch(octave, Optional.ofNullable(alteration), diatonicPitch);
    }
}
