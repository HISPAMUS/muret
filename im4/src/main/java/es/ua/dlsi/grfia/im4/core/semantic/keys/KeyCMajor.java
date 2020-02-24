package es.ua.dlsi.grfia.im4.core.semantic.keys;

import es.ua.dlsi.grfia.im4.core.semantic.Key;
import es.ua.dlsi.grfia.im4.core.semantic.SemanticItem;

public class KeyCMajor extends Key {
    /**
     * Package visibility to be used by the factory
     */
    static final String SKM = "*k[]";

    public KeyCMajor() {
        super(SKM);
    }

    @Override
    public SemanticItem clone() {
        return new KeyCMajor();
    }
}
