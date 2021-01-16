package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.core.IMooObject;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

/**
 * Use the fluent API to create children. Individual properties must be added with a method "from", and lists with a method "add"
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public abstract class CoreObjectBuilder<T extends IMooObject> implements IObjectBuilder<T> {
    /**
     * Must be private beacuse if it's null, a new ID is generated in getId()
     */
    private IId id;

    public CoreObjectBuilder<T> from(IId id) {
        this.id = id;
        return this;
    }

    /**
     * If ID is not assigned, a new one is generated
     * @return
     */
    protected IId getId() {
        return id;
        /*if (this.id != null) {
            return id;
        } else {
            return ICoreAbstractFactory.getInstance().createId();
        }*/
    }

    // we don't need it because the ICoreAbstractFactory already uses @NotNull annotations
    /*protected void assertRequired(String propertyName, Object property) throws IMException {
        // this could be used with reflection but this way is faster and easier
        if (property == null) {
            throw new IMException("Missing property '" + propertyName + "'");
        }
    }*/
}
