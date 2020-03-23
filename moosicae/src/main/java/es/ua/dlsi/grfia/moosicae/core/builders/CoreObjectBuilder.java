package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.ICoreObject;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * Use the fluent API to create children. Individual properties must be added with a method "from", and lists with a method "add"
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public abstract class CoreObjectBuilder<T extends ICoreObject> {
    protected final ICoreAbstractFactory coreObjectFactory;
    private IId id;

    public CoreObjectBuilder(ICoreAbstractFactory coreObjectFactory) {
        this.coreObjectFactory = coreObjectFactory; 
    }

    public CoreObjectBuilder<T> from(IId id) {
        this.id = id;
        return this;
    }

    public abstract T build() throws IMException;

    /**
     * If ID is not assigned, a new one is generated
     * @return
     */
    protected IId getId() {
        if (this.id != null) {
            return id;
        } else {
            return coreObjectFactory.createId();
        }
    }

    // we don't need it because the ICoreAbstractFactory alreadt uses @NotNull annotations
    /*protected void assertRequired(String propertyName, Object property) throws IMException {
        // this could be used with reflection but this way is faster and easier
        if (property == null) {
            throw new IMException("Missing property '" + propertyName + "'");
        }
    }*/

    public abstract <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) throws IMException;
}
