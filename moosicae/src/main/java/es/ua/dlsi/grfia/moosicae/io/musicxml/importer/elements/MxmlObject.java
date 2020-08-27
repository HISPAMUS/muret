package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.IMooObject;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public abstract class MxmlObject implements IMooObject {
    protected final IId id;

    protected MxmlObject(IId id) {
        this.id = id;
    }

    @Override
    public Optional<IId> getId() {
        return Optional.ofNullable(id);
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
