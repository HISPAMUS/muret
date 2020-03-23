package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IMode;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

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

    public IKeyBuilder from(IPitchClass pitchClass) {
        this.pitchClass = pitchClass;
        return this;
    }

    public IKeyBuilder from(IMode mode) {
        this.mode = mode;
        return this;
    }

    public IKeyBuilder from(IKeySignature keySignature) {
        this.keySignature = keySignature;
        return this;
    }

    @Override
    public IKey build() throws IMException {
        return coreObjectFactory.createKey(getId(), pitchClass, mode, keySignature);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importKey(this, inputOutputType);
    }
}
