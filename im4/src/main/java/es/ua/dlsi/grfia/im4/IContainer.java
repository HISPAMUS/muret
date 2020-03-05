package es.ua.dlsi.grfia.im4;

import java.util.Iterator;

public interface IContainer extends IComponent {
    Iterator<? extends IComponent> getChildrenIterator();
}
