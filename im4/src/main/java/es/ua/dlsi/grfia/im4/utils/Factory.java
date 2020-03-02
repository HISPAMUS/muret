package es.ua.dlsi.grfia.im4.utils;

import es.ua.dlsi.grfia.im4.core.IM4Exception;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author drizo
 * @param <T> Base class from which the derived will be instantiated
 */
public class Factory<T> {
    protected HashMap<String, Supplier<T>> defaultConstructor = new HashMap<>();
    protected HashMap<String, Function<Integer, T>> integerConstructor = new HashMap<>();
    protected HashMap<String, Function<String, T>> stringConstructor = new HashMap<>();

    private String typeName;

    public Factory(String typeName) {
        this.typeName = typeName;
    }

    public T create(String code) throws IM4Exception {
        Supplier<T> supplier = defaultConstructor.get(code);
        if (supplier != null) {
            return supplier.get();
        } else {
            throw new IM4Exception("Cannot create any " + typeName + " using the code '" + code + "'");
        }
    }

    public T create(String code, Integer integerConstructorParameter) throws IM4Exception {
        Function<Integer, T> function = integerConstructor.get(code);
        if (function != null) {
            return function.apply(integerConstructorParameter);
        } else {
            throw new IM4Exception("Cannot create any " + typeName + " using the code '" + code + "' and an integer parameter");
        }
    }

    public T create(String code, String stringConstructorParameter) throws IM4Exception {
        Function<String, T> function = stringConstructor.get(code);
        if (function != null) {
            return function.apply(stringConstructorParameter);
        } else {
            throw new IM4Exception("Cannot create any " + typeName + " using the code '" + code + "' and a string parameter");
        }
    }


}
