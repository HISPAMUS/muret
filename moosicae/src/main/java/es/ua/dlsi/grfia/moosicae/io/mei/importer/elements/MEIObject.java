package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.ICoreObject;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public abstract class MEIObject implements ICoreObject {
    protected final IId id;

    protected MEIObject(IId id) {
        this.id = id;
    }

    @Override
    public IId getId() {
        return id;
    }

    @Override
    public abstract MEIObject clone();

    @Override
    public String toString() {
        return "MxmlObject{" +
                "id=" + id +
                '}';
    }
}
