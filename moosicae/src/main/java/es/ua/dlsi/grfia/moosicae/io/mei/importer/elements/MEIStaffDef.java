package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.ICommonAlterationKey;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIStaffDef extends MEISystemDef {
    private ICommonAlterationKey commonAlterationKey;
    private IMeter meter;
    @NotNull
    private Integer n;

    public MEIStaffDef(IId id, ICommonAlterationKey commonAlterationKey, IMeter meter, Integer n) {
        super(id);
        this.commonAlterationKey = commonAlterationKey;
        this.meter = meter;
        this.n = n;
    }

    public Integer getN() {
        return n;
    }

    public Optional<ICommonAlterationKey> getCommonAlterationKey() {
        return Optional.of(commonAlterationKey);
    }

    public Optional<IMeter> getMeter() {
        return Optional.of(meter);
    }

    @Override
    public MEIStaffDef clone() {
        return new MEIStaffDef(id, commonAlterationKey, meter, n);
    }

    @Override
    public String toString() {
        return "MEIStaffDef{" +
                "commonAlterationKey=" + commonAlterationKey +
                ", meter=" + meter +
                ", n=" + n +
                "} " + super.toString();
    }
}
