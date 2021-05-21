package es.ua.dlsi.grfia.moosicae.utils;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 21/5/21
 */
public class Pair<K,V> {
    private final K left;
    private final V right;

    public Pair(K left, V right) {
        this.left = left;
        this.right = right;
    }

    public K getLeft() {
        return left;
    }

    public V getRight() {
        return right;
    }
}
