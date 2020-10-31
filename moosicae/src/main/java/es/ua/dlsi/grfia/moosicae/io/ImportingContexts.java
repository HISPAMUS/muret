package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.builders.IObjectBuilder;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Used to handle context organized importers, such as XML tree structures. It allows to add core object builders (method begin),
 * that when are finished (method end) look for available objects built by previous contexts that can be used to build
 * the new core object, that in turn is added to the list of available objects for being used by further contexts
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 21/03/2020
 */
public class ImportingContexts<BuiltType> {
    private final ImportedObjectPool objectPool;
    private final HashMap<String, IObjectBuilder<? extends BuiltType>> objectBuilders;
    /**
     * Use a list instead of a Stack in order to iterate
     */
    private final LinkedList<IObjectBuilder<? extends BuiltType>> objectBuilderStack;

    public ImportingContexts() {
        //objectBuilders = new HashMap<>();
        objectPool = new ImportedObjectPool();
        objectBuilders = new HashMap<>();
        objectBuilderStack = new LinkedList<>();
    }

    /**
     * It starts a context associating the context name to the builder
     * @param contextName
     * @param coreObjectBuilder
     * @return
     */
    public <BuilderType extends IObjectBuilder<? extends BuiltType>> IObjectBuilder<? extends BuiltType> begin(String contextName, BuilderType coreObjectBuilder) {
        objectBuilders.put(contextName, coreObjectBuilder);
        objectBuilderStack.add(0, coreObjectBuilder);

        return coreObjectBuilder;
    }

    public boolean contains(String contextName) {
        return objectBuilders.containsKey(contextName);
    }

    /**
     * It looks for the builder associated to the context name, then it assigns all elements in the object pool that can be
     * assigned (with the 'from' or 'add' method) to the builder. Finally, the builder builds the object that is pushed
     * into the object pool
     * @param contextName
     * @return
     * @throws IMException
     */
    public BuiltType end(String contextName) throws IMException {
        IObjectBuilder<? extends BuiltType> coreObjectBuilder = objectBuilders.get(contextName);
        if (coreObjectBuilder == null) {
            throw new IMException("Cannot find a core object builder for the context with name '" + contextName + "'");
        }

        // try to assign available objects to build object
        objectPool.populate(coreObjectBuilder);
        BuiltType coreObject = coreObjectBuilder.build();
        objectBuilderStack.remove(0);
        objectBuilders.remove(contextName);
        //objectPool.add(coreObject);

        // try to assign this just created object to other parent context builders
        addObjectToPool(coreObject);
        return coreObject;
    }

    /**
     * It tries to assign the object to the last inserted active object. If no one can process it, it remains in the pool
     * It just adds an object to the pool to be used by the first active context that can make use of it given the object type
     * @param object
     */
    public void addObjectToPool(Object object) {
        boolean assigned = false;
        for (Iterator<IObjectBuilder<? extends BuiltType>> it = objectBuilderStack.iterator(); !assigned && it.hasNext(); ) {
            IObjectBuilder<? extends BuiltType> objectBuilder = it.next();
            assigned = this.objectPool.assign(object, objectBuilder);
        }
        if (!assigned) {
            this.objectPool.add(object);
        }
    }

    public void removeObjectFromPool(Object object) {
        this.objectPool.remove(object);
    }

    /**
     * This is a collapsed version of begin, addObjectToPool and end methods for very simple builders that do not have children
     * @param coreObjectBuilder
     * @param objects
     */
    public <BuilderType extends IObjectBuilder<? extends BuiltType>> BuiltType beginEnd(BuilderType coreObjectBuilder, Object ... objects) throws IMException {
        begin(coreObjectBuilder.getClass().getName(), coreObjectBuilder);
        for (Object object: objects) {
            addObjectToPool(object);
        }
        return end(coreObjectBuilder.getClass().getName());
    }

}
