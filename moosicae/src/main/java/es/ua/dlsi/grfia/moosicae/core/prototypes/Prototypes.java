package es.ua.dlsi.grfia.moosicae.core.prototypes;

import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IVoicedItem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * It contains named examples of a series of known objects. Use generateInstance method or at least a defensive copy of the prototypes
 * The derived classes of Prototypes should be instantiated using the PrototypesAbstractBuilder class
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public abstract class Prototypes<Type extends IVoicedItem> {
    protected HashMap<String, Type> prototypes;

    public Prototypes() {
        this.prototypes = new HashMap<>();
    }

    protected void add(String name, Type prototype) {
        prototypes.put(name, prototype);
    }

    /**
     * It creates a copy of the given prototype for the specified name
     * @param name
     * @return
     */
    public Type generateInstance(String name) {
        Type type = prototypes.get(name);
        if (type == null) {
            throw new IMRuntimeException("Cannot find a prototype for '" + name + "'");
        }
        return (Type) type.clone();
    }

    /**
     * Use only on tests
     * @return
     */
    public Collection<Type> getPrototypes() {
        return prototypes.values();
    }

    /**
     * Use only on tests
     * @return
     */
    public Map<String, Type> getMap() {
        return prototypes;
    }

    public Set<String> getNames() {
        return prototypes.keySet();
    }
}
