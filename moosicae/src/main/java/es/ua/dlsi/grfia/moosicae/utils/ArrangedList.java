package es.ua.dlsi.grfia.moosicae.utils;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * A list of elements that can be rearranged or repositioned
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class ArrangedList<ItemClass> {
    LinkedList<ItemClass> items;

    public Iterator<ItemClass> iterator() {
        return items.iterator();
    }
}
