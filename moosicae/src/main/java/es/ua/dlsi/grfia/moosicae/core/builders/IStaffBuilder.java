package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IVoicedSingle;
import es.ua.dlsi.grfia.moosicae.core.IStaff;
import es.ua.dlsi.grfia.moosicae.core.properties.INotationType;
import es.ua.dlsi.grfia.moosicae.core.properties.IStaffLineCount;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class IStaffBuilder extends ISystemBuilder<IStaff> {
    private final List<IVoicedSingle> staffSymbols;
    protected IStaffLineCount lineCount;
    INotationType notationType;

    public IStaffBuilder() {
        this.staffSymbols = new LinkedList<>();
    }

    public IStaffBuilder from(IStaffLineCount staffLineCount) {
        this.lineCount = staffLineCount;
        return this;
    }

    public IStaffBuilder from(INotationType notationType) {
        this.notationType = notationType;
        return this;
    }

    public IStaffBuilder add(IVoicedSingle coreItem) {
        this.staffSymbols.add(coreItem);
        return this;
    }

    @Override
    public IStaff build() throws IMException {
        return ICoreAbstractFactory.getInstance().createStaff(getId(), lineCount, staffSymbols.toArray(new IVoicedSingle[0]), notationType); // recall the IVoicedSingle[0] is used to indicate the array type without cast
    }
}
