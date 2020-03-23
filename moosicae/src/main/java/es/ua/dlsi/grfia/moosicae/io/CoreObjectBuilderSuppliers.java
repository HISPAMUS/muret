package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;

import java.util.HashMap;
import java.util.function.Function;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class CoreObjectBuilderSuppliers {
    protected HashMap<String, Function<ICoreAbstractFactory, ?>> constructors = new HashMap<>();

    public CoreObjectBuilderSuppliers() {
    }

    public <T> Object create(String code, ICoreAbstractFactory constructorParameter) throws IMException {
        Function<ICoreAbstractFactory, ?> function = constructors.get(code);
        if (function != null) {
            return function.apply(constructorParameter);
        } else {
            throw new IMException("Cannot create a " + code + "' and an ICoreAbstractFactory parameter");
        }
    }

    public void add(String code, Function<ICoreAbstractFactory, ?> constructor) {
        constructors.put(code, constructor);
    }

    public boolean contains(String code) {
        return constructors.containsKey(code);
    }

   /* public T create(String code) throws IMException {
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
    }*/


}
