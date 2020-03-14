package es.ua.dlsi.grfia.moosicae.utils;

import es.ua.dlsi.grfia.moosicae.IMException;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @param <T> Base class from which the derived will be instantiated
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Factory<T> {
    protected HashMap<String, Supplier<T>> defaultConstructor = new HashMap<>();
    protected HashMap<String, Function<Integer, T>> integerConstructor = new HashMap<>();
    protected HashMap<String, Function<String, T>> stringConstructor = new HashMap<>();

    private String typeName;

    public Factory(String typeName) {
        this.typeName = typeName;
    }

    public T create(String code) throws IMException {
        Supplier<T> supplier = defaultConstructor.get(code);
        if (supplier != null) {
            return supplier.get();
        } else {
            throw new IMException("Cannot create any " + typeName + " using the code '" + code + "'");
        }
    }

    public T create(String code, Integer integerConstructorParameter) throws IMException {
        Function<Integer, T> function = integerConstructor.get(code);
        if (function != null) {
            return function.apply(integerConstructorParameter);
        } else {
            throw new IMException("Cannot create any " + typeName + " using the code '" + code + "' and an integer parameter");
        }
    }

    public T create(String code, String stringConstructorParameter) throws IMException {
        Function<String, T> function = stringConstructor.get(code);
        if (function != null) {
            return function.apply(stringConstructorParameter);
        } else {
            throw new IMException("Cannot create any " + typeName + " using the code '" + code + "' and a string parameter");
        }
    }


}
