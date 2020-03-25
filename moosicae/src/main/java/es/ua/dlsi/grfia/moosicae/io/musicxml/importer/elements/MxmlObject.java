package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.ICoreObject;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public abstract class MxmlObject implements ICoreObject {
    protected final IId id;

    protected MxmlObject(IId id) {
        this.id = id;
    }

    @Override
    public IId getId() {
        return id;
    }

    @Override
    public abstract MxmlObject clone();

    @Override
    public String toString() {
        return "MxmlObject{" +
                "id=" + id +
                '}';
    }
}
