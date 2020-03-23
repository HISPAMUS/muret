package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class ID implements IId {
    private final String id;

    public ID(String id) {
        this.id = id;
    }

    @Override
    public String getValue() {
        return id;
    }
}
