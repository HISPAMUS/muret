package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreObject;
import es.ua.dlsi.grfia.moosicae.core.builders.IObjectBuilder;


import java.util.HashMap;

/**
 * Used to handle context organized importers, such as XML tree structures. It allows to add core object builders (method begin),
 * that when are finished (method end) look for available objects built by previous contexts that can be used to build
 * the new core object, that in turn is added to the list of available objects for being used by further contexts
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 21/03/2020
 */
public class ImportingContexts {
    private final ImportedObjectPool objectPool;
    private final HashMap<String, IObjectBuilder<?>> objectBuilders;

    public ImportingContexts() {
        objectBuilders = new HashMap<>();
        objectPool = new ImportedObjectPool();
    }

    public IObjectBuilder<?> begin(String contextName, IObjectBuilder<?> coreObjectBuilder) {
        objectBuilders.put(contextName, coreObjectBuilder);
        return coreObjectBuilder;
    }

    public boolean contains(String contextName) {
        return objectBuilders.containsKey(contextName);
    }

    public Object end(String contextName) throws IMException {
        IObjectBuilder<?> coreObjectBuilder = objectBuilders.get(contextName);
        if (coreObjectBuilder == null) {
            throw new IMException("Cannot find a core object builder for the context with name '" + contextName + "'");
        }
        objectPool.populate(coreObjectBuilder);
        Object coreObject = coreObjectBuilder.build();
        objectPool.add(coreObject);
        return coreObject;
    }

    public void addObjectToPool(Object object) {
        this.objectPool.add(object);
    }

}