package es.ua.dlsi.grfia.moosicae.utils.builder;

import es.ua.dlsi.grfia.moosicae.IMException;

import java.util.HashMap;
import java.util.Optional;
import java.util.Properties;

/**
 * It contains a hierarchical structure of properties that can be used to help builders
 * to create objects from strings imported from files such as XML or **kern
 * @param <BuiltType> The target class type
 */
public abstract class AbstractBuilderFromProperties<BuiltType> {
    private final Properties properties;
    private final HashMap<String, AbstractBuilderFromProperties<?>> children;

    public AbstractBuilderFromProperties() {
        this.properties = new Properties();
        this.children = new HashMap<>();
    }

    public void addProperty(String key, String value) {
        properties.put(key, value);
    }

    public void addProperty(String key, AbstractBuilderFromProperties compositeBuilder) {
        properties.put(key, compositeBuilder);
    }

    public <ChildType> void addChild(String childName, AbstractBuilderFromProperties<ChildType> childBuilder) {
        children.put(childName, childBuilder);
    }

    public <ChildType> AbstractBuilderFromProperties<ChildType> getRequiredChild(String childName) throws IMException {
        AbstractBuilderFromProperties<ChildType> child = (AbstractBuilderFromProperties<ChildType>) children.get(childName);
        if (child == null) {
            throw new IMException("Cannot find child '" + childName + "'");
        }
        return child;
    }

    public <ChildType> Optional<AbstractBuilderFromProperties<ChildType>> getOptionalChild(String childName) {
        return Optional.ofNullable((AbstractBuilderFromProperties<ChildType>) children.get(childName));
    }

    public String getRequiredProperty(String key) throws IMException {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new IMException("Cannot find property '" + key + "'");
        }
        return value;
    }

    public Optional<String> getOptionalProperty(String key) {
        return Optional.ofNullable(properties.getProperty(key));
    }

    public abstract BuiltType build() throws IMException;

}
