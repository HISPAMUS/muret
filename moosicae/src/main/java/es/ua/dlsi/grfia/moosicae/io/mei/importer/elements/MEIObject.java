package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.IMooObject;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public abstract class MEIObject implements IMooObject {
    protected final IId id;

    protected MEIObject(IId id) {
        if (id == null) {
            this.id = IdGenerator.getInstance().generateUniqueId();
        } else {
            this.id = id;
        }
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
