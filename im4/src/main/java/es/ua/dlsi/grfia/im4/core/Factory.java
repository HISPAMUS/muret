package es.ua.dlsi.grfia.im4.core;

import java.util.HashMap;
import java.util.function.Supplier;

/**
 * @author drizo
 * @param <T> Base class from which the derived will be instantiated
 */
public class Factory<T> {
    protected HashMap<String, Supplier<T>> map = new HashMap<>();
    private String typeName;

    public Factory(String typeName) {
        this.typeName = typeName;
    }

    public T create(String code) throws IM4Exception {
        Supplier<T> supplier = map.get(code);
        if (supplier != null) {
            return supplier.get();
        } else {
            throw new IM4Exception("Cannot create any " + typeName + " using the code '" + code + "'");
        }
    }
}
