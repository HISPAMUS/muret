package es.ua.dlsi.grfia.moosicae.core.prototypes;

import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.ICoreItem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class Prototypes<Type extends ICoreItem> {
    protected final ICoreAbstractFactory coreAbstractFactory;
    protected HashMap<String, Type> prototypes;

    public Prototypes(ICoreAbstractFactory coreAbstractFactory) {
        this.coreAbstractFactory = coreAbstractFactory;
        this.prototypes = new HashMap<>();
    }

    protected void add(String name, Type prototype) {
        prototypes.put(name, prototype);
    }

    public Type generateInstance(String name) {
        Type type = prototypes.get(name);
        if (type == null) {
            throw new IMRuntimeException("Cannot find a prototype for '" + name + "'");
        }
        return (Type) type.clone();
    }

    public Collection<Type> getPrototypes() {
        return prototypes.values();
    }

    public Map<String, Type> getMap() {
        return prototypes;
    }

    public Set<String> getNames() {
        return prototypes.keySet();
    }
}
