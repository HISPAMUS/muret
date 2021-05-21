package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.IMooObject;
import es.ua.dlsi.grfia.moosicae.core.IVoiced;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 21/5/21
 */
public abstract class MEIMark extends MEIObject {
    private final IId startId;

    public MEIMark(IId id, IId startId) {
        super(id);
        this.startId = startId;
    }

    public IId getStartId() {
        return startId;
    }

    public abstract void toMooObject(MEIMark mark, IVoiced voiced);
}
