package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.properties.IDiatonicPitch;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IPitchClassBuilder extends CoreObjectBuilder<IPitchClass> {
    IDiatonicPitch diatonicPitch;
    IAccidentalSymbol accidentalSymbol;

    public IPitchClassBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public IPitchClassBuilder from(IDiatonicPitch diatonicPitch) {
        this.diatonicPitch = diatonicPitch;
        return this;
    }

    public IPitchClassBuilder from(IAccidentalSymbol accidentalSymbol) {
        this.accidentalSymbol = accidentalSymbol;
        return this;
    }

    @Override
    public IPitchClass build() throws IMException {
        return coreObjectFactory.createPitchClass(getId(), diatonicPitch, accidentalSymbol);
    }


}
