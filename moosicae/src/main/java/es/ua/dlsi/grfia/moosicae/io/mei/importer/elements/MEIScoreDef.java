package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.ICommonAlterationKey;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIScoreDef extends MEIObject {
    private final ICommonAlterationKey commonAlterationKey;
    private final IMeter meter;
    private final MEIStaffGroupDef meiStaffGroupDef;

    public MEIScoreDef(IId id, ICommonAlterationKey commonAlterationKey, IMeter meter, MEIStaffGroupDef meiStaffGroupDef) {
        super(id);
        this.commonAlterationKey = commonAlterationKey;
        this.meter = meter;
        this.meiStaffGroupDef = meiStaffGroupDef;
    }

    public ICommonAlterationKey getCommonAlterationKey() {
        return commonAlterationKey;
    }

    public IMeter getMeter() {
        return meter;
    }

    public MEIStaffGroupDef getMeiStaffGroupDef() {
        return meiStaffGroupDef;
    }

    @Override
    public MEIScoreDef clone() {
        return new MEIScoreDef(id, commonAlterationKey, meter, meiStaffGroupDef);
    }

    @Override
    public String toString() {
        return "MEIScoreDef{" +
                "commonAlterationKey=" + commonAlterationKey +
                ", meter=" + meter +
                ", meiStaffGroupDef=" + meiStaffGroupDef +
                "} " + super.toString();
    }
}
