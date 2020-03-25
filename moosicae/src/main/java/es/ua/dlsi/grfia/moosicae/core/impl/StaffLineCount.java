package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.impl.properties.IntegerCoreCoreProperty;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IStaffLineCount;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class StaffLineCount extends IntegerCoreCoreProperty implements IStaffLineCount {
    public StaffLineCount(@NotNull IId id, @NotNull Integer value) {
        super(id, value);
    }

    @Override
    public StaffLineCount clone() {
        return new StaffLineCount(getId(), value);
    }
}
