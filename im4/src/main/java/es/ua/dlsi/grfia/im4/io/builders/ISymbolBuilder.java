package es.ua.dlsi.grfia.im4.io.builders;

import es.ua.dlsi.grfia.im4.core.IM4Exception;

import java.util.Optional;

public interface ISymbolBuilder<SymbolType> {
    void addProperty(String key, String value);
    <ChildType> void addChild(String childName, ISymbolBuilder<ChildType> compositeBuilder);

    <ChildType> ISymbolBuilder<ChildType> getRequiredChild(String childName) throws IM4Exception;;
    <ChildType> Optional<ISymbolBuilder<ChildType>> getOptionalChild(String childName);

    String getRequiredProperty(String key) throws IM4Exception;
    Optional<String> getOptionalProperty(String key);

    SymbolType build() throws IM4Exception;
}
