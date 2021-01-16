package es.ua.dlsi.grfia.moosicae.core.prototypes;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;

import java.util.HashMap;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class PrototypesAbstractBuilder {
    private static PrototypesAbstractBuilder instance;

    private final Clefs clefs;
    private final Keys keys;
    private final Meters meters;

    private PrototypesAbstractBuilder() throws IMException {
        this.clefs = new Clefs();
        this.keys = new Keys();
        this.meters = new Meters();
    }

    public static PrototypesAbstractBuilder getInstance() throws IMException {
        if (instance == null) {
            instance = new PrototypesAbstractBuilder();
        }
        return instance;
    }

    public Clefs getClefs() {
        return clefs;
    }

    public Keys getKeys() {
        return keys;
    }

    public Meters getMeters() {
        return meters;
    }
}
