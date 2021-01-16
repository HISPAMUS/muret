package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class CoreObjectBuilderSuppliers {
    protected HashMap<String, Supplier<?>> suppliers = new HashMap<>();

    public CoreObjectBuilderSuppliers() {
    }

    public <T> Object create(String code) throws IMException {
        Supplier<?> supplier = suppliers.get(code);
        if (supplier != null) {
            return supplier.get();
        } else {
            throw new IMException("Cannot create a " + code + "' and an ICoreAbstractFactory parameter");
        }
    }
    public void add(String code, Supplier<?> constructor) {
        suppliers.put(code, constructor);
    }

    public boolean contains(String code) {
        return suppliers.containsKey(code);
    }

    /* This was used when the ICoreAbstractFactory was required in the constructor
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

    public <T> Object create(String code) throws IMException {
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
    }*/
}
