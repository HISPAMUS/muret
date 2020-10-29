package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IMooObject;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import javax.validation.constraints.NotNull;
import java.util.Optional;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public abstract class CoreObject implements IMooObject {
    @NotNull
    protected final IId id;

    /**
     *
     * @param id If id is null, a new id is generated. If not null, the value is assigned
     */
    public CoreObject(IId id) {
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
    public String toString() {
        return "{id=" + id + '}';
    }

    @Override
    public abstract CoreObject clone();
}
