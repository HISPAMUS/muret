package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IVoicedItem;
import es.ua.dlsi.grfia.moosicae.core.IStaff;
import es.ua.dlsi.grfia.moosicae.core.properties.IStaffLineCount;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class IStaffBuilder extends ISystemBuilder<IStaff> {
    private final List<IVoicedItem> staffSymbols;
    protected IStaffLineCount lineCount;

    public IStaffBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
        staffSymbols = new LinkedList<>();
    }

    public IStaffBuilder from(IStaffLineCount staffLineCount) {
        this.lineCount = lineCount;
        return this;
    }

    public IStaffBuilder add(IVoicedItem coreItem) {
        this.staffSymbols.add(coreItem);
        return this;
    }

    @Override
    public IStaff build() throws IMException {
        return coreObjectFactory.createStaff(getId(), lineCount, staffSymbols.toArray(new IVoicedItem[0])); // recall the IVoicedItem[0] is used to indicate the array type without cast
    }
}