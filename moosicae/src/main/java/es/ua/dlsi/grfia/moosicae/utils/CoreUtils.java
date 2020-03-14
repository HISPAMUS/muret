package es.ua.dlsi.grfia.moosicae.utils;

import java.util.Objects;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 14/03/2020
 */
public class CoreUtils {
    public static <T, C> void requireNotNullConstructorParam(Object callerObject, T parameter, String parameterName) {
        Objects.requireNonNull(parameter, "Missong constructor parameter '" + parameterName + "' for class " + callerObject.getClass().getCanonicalName());
    }
}
