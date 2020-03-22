package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IId;
import es.ua.dlsi.grfia.moosicae.core.IIdGenerator;

import java.util.UUID;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class IdGenerator implements IIdGenerator {
    public static IdGenerator instance = null;

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    @Override
    public IId generateUniqueId() {
        UUID uuid = UUID.randomUUID();
        return new ID(uuid.toString());
    }
}
