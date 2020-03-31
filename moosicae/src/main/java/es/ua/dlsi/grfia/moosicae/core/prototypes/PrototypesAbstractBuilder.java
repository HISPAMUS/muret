package es.ua.dlsi.grfia.moosicae.core.prototypes;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;

import java.util.HashMap;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class PrototypesAbstractBuilder {
    private static final HashMap<ICoreAbstractFactory, PrototypesAbstractBuilder> prototypes = new HashMap<>();
    private final ICoreAbstractFactory coreAbstractFactory;

    private final Clefs clefs;
    private final Keys keys;

    private PrototypesAbstractBuilder(ICoreAbstractFactory coreAbstractFactory) throws IMException {
        this.coreAbstractFactory = coreAbstractFactory;

        this.clefs = new Clefs(coreAbstractFactory);
        this.keys = new Keys(coreAbstractFactory);
    }

    public static synchronized PrototypesAbstractBuilder getInstance(ICoreAbstractFactory coreAbstractFactory) throws IMException {
        PrototypesAbstractBuilder p = prototypes.get(coreAbstractFactory);
        if (p == null) {
            p = new PrototypesAbstractBuilder(coreAbstractFactory);
            prototypes.put(coreAbstractFactory, p);
        }
        return p;
    }

    public Clefs getClefs() {
        return clefs;
    }

    public Keys getKeys() {
        return keys;
    }
}
