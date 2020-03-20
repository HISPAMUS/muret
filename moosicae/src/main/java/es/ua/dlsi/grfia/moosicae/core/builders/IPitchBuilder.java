package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;

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

    public void setOctave(int octave) {
        this.octave = coreObjectFactory.createOctave(octave);
    }

    /**
     * Convenience builder
     */
    public IPitch build(EDiatonicPitches eDiatonicPitch, Optional<EAccidentalSymbols> accidentalSymbol,
                        int octaveNumber) throws IMException {
        octave = coreObjectFactory.createOctave(octaveNumber);
        if (accidentalSymbol.isPresent()) {
            alteration = coreObjectFactory.createAlteration(
                    coreObjectFactory.createAccidentalSymbol(accidentalSymbol.get()),
                    Optional.empty()
            );
        }
        diatonicPitch = coreObjectFactory.createDiatonicPitch(eDiatonicPitch);
        return build();
    }

    @Override
    public IPitch build() throws IMException {
        assertRequired("octave", octave);
        assertRequired("diatonicPitch", diatonicPitch);
        return coreObjectFactory.createPitch(octave, Optional.ofNullable(alteration), diatonicPitch);
    }
}
