package es.ua.dlsi.grfia.moosicae.io.xml;

import es.ua.dlsi.grfia.moosicae.IMException;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class XMLCorePropertyReaders {
    public static <TEnum extends Enum<TEnum>> TEnum readCharacters(Class<TEnum> enumClass, XMLImporterParam xmlImporterParam) throws IMException {
        Optional<String> characters = xmlImporterParam.getCharacters();
        if (characters.isPresent()) {
            String string = characters.get();
            TEnum enumValue = Enum.valueOf(enumClass, string);
            if (enumValue == null) {
                throw new IMException("No enum value for '" + string + "'");
            }
            return enumValue;
        } else {
            throw new IMException("Expected characters in the XMLImporterParam");
        }
    }

    public static <TEnum extends Enum<TEnum>> TEnum readAttribute(Class<TEnum> enumClass, XMLImporterParam xmlImporterParam, String attributeName) throws IMException {
        Optional<String> value = xmlImporterParam.getAttribute(attributeName);
        if (!value.isPresent()) {
            TEnum enumValue = Enum.valueOf(enumClass, value.get());
            if (enumValue == null) {
                throw new IMException("No enum value for '" + value.get() + "'");
            }
            return enumValue;
        } else {
            throw new IMException("Expected an attribute '" + attributeName + "' in the XMLImporterParam");
        }
    }
}
