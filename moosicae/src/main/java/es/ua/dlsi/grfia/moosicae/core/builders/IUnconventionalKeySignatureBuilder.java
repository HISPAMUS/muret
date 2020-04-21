package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.core.IUnconventionalKeySignature;
import es.ua.dlsi.grfia.moosicae.core.properties.ICautionaryKeySignatureAccidentals;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;


import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IUnconventionalKeySignatureBuilder extends CoreObjectBuilder<IUnconventionalKeySignature> {
    private List<IPitchClass> pitchClassList;
    private ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals;

    public IUnconventionalKeySignatureBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
        this.pitchClassList = new LinkedList<>();
    }

    public IUnconventionalKeySignatureBuilder add(IPitchClass pitchClass) {
        pitchClassList.add(pitchClass);
        return this;
    }

    public IUnconventionalKeySignatureBuilder from(ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals) {
        this.cautionaryKeySignatureAccidentals = cautionaryKeySignatureAccidentals;
        return this;
    }


    @Override
    public IUnconventionalKeySignature build() {
        // the key signature can have no pitch class (CM or Am)
        return coreObjectFactory.createUnconventionalKeySignature(getId(), pitchClassList.toArray(new IPitchClass[0]), cautionaryKeySignatureAccidentals);
    }


}
