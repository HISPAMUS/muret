package es.ua.dlsi.grfia.moosicae.io.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IKeyBuilder extends CoreObjectBuilder<IKey> {
    private IPitchClass pitchClass;
    private IMode mode;
    private IKeySignature keySignature;

    public IKeyBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setPitchClass(IPitchClass pitchClass) {
        this.pitchClass = pitchClass;
    }

    public void setMode(IMode mode) {
        this.mode = mode;
    }

    public void setKeySignature(IKeySignature keySignature) {
        this.keySignature = keySignature;
    }

    @Override
    public IKey build() throws IMException {
        assertRequired("pitchClass", pitchClass);
        assertRequired("mode", mode);
        assertRequired("keySignature", keySignature);
        return coreObjectFactory.createKey(pitchClass, mode, keySignature);
    }
}
