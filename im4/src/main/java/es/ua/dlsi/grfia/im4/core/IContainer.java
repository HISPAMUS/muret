package es.ua.dlsi.grfia.im4.core;

import java.util.Iterator;

public interface IContainer extends IComponent {
    Iterator<? extends IComponent> getChildrenIterator();
}
