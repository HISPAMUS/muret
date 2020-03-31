package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.ICommonAlterationKey;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIScoreDef extends MEIObject implements IMEIDef {
    private final ICommonAlterationKey commonAlterationKey;
    private final IMeter meter;
    private final MEIStaffGroupDef meiStaffGroupDef;

    public MEIScoreDef(IId id, ICommonAlterationKey commonAlterationKey, IMeter meter, MEIStaffGroupDef meiStaffGroupDef) {
        super(id);
        this.commonAlterationKey = commonAlterationKey;
        this.meter = meter;
        this.meiStaffGroupDef = meiStaffGroupDef;
    }

    @Override
    public Optional<ICommonAlterationKey> getCommonAlterationKey() {
        return Optional.ofNullable(commonAlterationKey);
    }

    @Override
    public Optional<IMeter> getMeter() {
        return Optional.ofNullable(meter);
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
