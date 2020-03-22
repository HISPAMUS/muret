package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IPitchClassBuilder extends CoreObjectBuilder<IPitchClass> {
    IDiatonicPitch diatonicPitch;
    IAccidentalCore accidentalSymbol;

    public IPitchClassBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setDiatonicPitch(IDiatonicPitch diatonicPitch) {
        this.diatonicPitch = diatonicPitch;
    }

    public void setAccidentalSymbol(IAccidentalCore accidentalSymbol) {
        this.accidentalSymbol = accidentalSymbol;
    }

    @Override
    public IPitchClass build() throws IMException {
        assertRequired("diatonicPitch", diatonicPitch);
        return coreObjectFactory.createPitchClass(getId(), diatonicPitch, accidentalSymbol);
    }
}
