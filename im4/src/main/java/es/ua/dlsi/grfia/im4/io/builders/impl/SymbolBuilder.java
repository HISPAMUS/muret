package es.ua.dlsi.grfia.im4.io.builders.impl;

import es.ua.dlsi.grfia.im4.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.io.builders.ISymbolBuilder;

import java.util.HashMap;
import java.util.Optional;
import java.util.Properties;

public abstract class SymbolBuilder<SymbolType> implements ISymbolBuilder<SymbolType> {
    protected final ICoreAbstractFactory coreSymbolFactory;
    private final Properties properties;
    private final HashMap<String, ISymbolBuilder<?>> children;

    public SymbolBuilder(ICoreAbstractFactory coreSymbolFactory) {
        this.properties = new Properties();
        this.children = new HashMap<>();
        this.coreSymbolFactory = coreSymbolFactory;
    }

    public void addProperty(String key, String value) {
        properties.put(key, value);
    }

    public void addProperty(String key, SymbolBuilder compositeBuilder) {
        properties.put(key, compositeBuilder);
    }

    @Override
    public <ChildType> void addChild(String childName, ISymbolBuilder<ChildType> childBuilder) {
        children.put(childName, childBuilder);
    }

    @Override
    public <ChildType> ISymbolBuilder<ChildType> getRequiredChild(String childName) throws IM4Exception {
        ISymbolBuilder<ChildType> child = (ISymbolBuilder<ChildType>) children.get(childName);
        if (child == null) {
            throw new IM4Exception("Cannot find child '" + childName + "'");
        }
        return child;
    }

    @Override
    public <ChildType> Optional<ISymbolBuilder<ChildType>> getOptionalChild(String childName) {
        return Optional.ofNullable((ISymbolBuilder<ChildType>) children.get(childName));
    }

    @Override
    public String getRequiredProperty(String key) throws IM4Exception {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new IM4Exception("Cannot find property '" + key + "'");
        }
        return value;
    }

    @Override
    public Optional<String> getOptionalProperty(String key) {
        return Optional.ofNullable(properties.getProperty(key));
    }

    public abstract SymbolType build() throws IM4Exception;

}
