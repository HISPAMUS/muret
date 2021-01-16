package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import es.ua.dlsi.grfia.moosicae.core.properties.IAlteration;
import es.ua.dlsi.grfia.moosicae.core.properties.IDiatonicPitch;
import es.ua.dlsi.grfia.moosicae.core.properties.IOctave;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitch;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IPitchBuilder extends CoreObjectBuilder<IPitch> {
    private IOctave octave;
    private IAlteration alteration;
    private IDiatonicPitch diatonicPitch;

    public IPitchBuilder() {}

    public IPitchBuilder from(IOctave octave) {
        this.octave = octave;
        return this;
    }

    public IPitchBuilder from(IAlteration alteration) {
        this.alteration = alteration;
        return this;
    }

    public IPitchBuilder from(IDiatonicPitch diatonicPitch) {
        this.diatonicPitch = diatonicPitch;
        return this;
    }

    public IPitchBuilder from(EDiatonicPitches diatonicPitch) {
        this.diatonicPitch = ICoreAbstractFactory.getInstance().createDiatonicPitch(null, diatonicPitch);
        return this;
    }

    public IPitchBuilder from(int octave) {
        this.octave = ICoreAbstractFactory.getInstance().createOctave(getId(), octave);
        return this;
    }

    @Override
    public IPitch build() throws IMException {
        return ICoreAbstractFactory.getInstance().createPitch(getId(), octave, alteration, diatonicPitch);
    }


}
