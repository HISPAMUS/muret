package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class IStaffGroupBuilder extends ISystemBuilder<IStaffGroup> {
    private final List<ISystem> children;

    public IStaffGroupBuilder() {
        children = new LinkedList<>();
    }

    public IStaffGroupBuilder add(ISystem child) {
        this.children.add(child);
        return this;
    }

    @Override
    public IStaffGroup build() throws IMException {
        return ICoreAbstractFactory.getInstance().createStaffGroup(getId(), children.toArray(new ISystem[0]));
    }
}
