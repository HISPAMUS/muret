package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.core.IKeySignature;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;


import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IKeySignatureBuilder extends CoreObjectBuilder<IKeySignature> {
    private List<IPitchClass> pitchClassList;

    public IKeySignatureBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
        this.pitchClassList = new LinkedList<>();
    }

    public IKeySignatureBuilder add(IPitchClass pitchClass) {
        pitchClassList.add(pitchClass);
        return this;
    }

    @Override
    public IKeySignature build() {
        // the key signature can have no pitch class (CM or Am)
        return coreObjectFactory.createKeySignature(getId(), pitchClassList.toArray(new IPitchClass[pitchClassList.size()]));
    }


}
