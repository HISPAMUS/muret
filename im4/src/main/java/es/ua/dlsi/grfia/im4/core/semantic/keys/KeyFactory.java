package es.ua.dlsi.grfia.im4.core.semantic.keys;


import es.ua.dlsi.grfia.im4.core.Factory;
import es.ua.dlsi.grfia.im4.core.semantic.Key;

public class KeyFactory extends Factory<Key> {
    private static KeyFactory instance = null;

    public static KeyFactory getInstance() {
        if (instance == null) {
            instance = new KeyFactory();
        }
        return instance;
    }

    private KeyFactory() {
        super("key");

        map.put(KeyCMajor.SKM, KeyCMajor::new);
        map.put(KeyFMajor.SKM, KeyFMajor::new);
        map.put(KeyGMajor.SKM, KeyGMajor::new);
    }
}
