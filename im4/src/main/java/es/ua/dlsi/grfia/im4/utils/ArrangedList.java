package es.ua.dlsi.grfia.im4.utils;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * A list of elements that can be rearranged or repositioned
 */
public class ArrangedList<ItemClass> {
    LinkedList<ItemClass> items;

    public Iterator<ItemClass> iterator() {
        return items.iterator();
    }
}
