package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.IClef;
import es.ua.dlsi.grfia.moosicae.core.ICommonAlterationKeySignature;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIStaffDef extends MEISystemDef implements IMEIDef {
    private ICommonAlterationKeySignature commonAlterationKey;
    private IMeter meter;
    private IClef clef;

    @NotNull
    private Integer n;

    public MEIStaffDef(IId id, IClef clef, ICommonAlterationKeySignature commonAlterationKey, IMeter meter, Integer n) {
        super(id);
        this.clef = clef;
        this.commonAlterationKey = commonAlterationKey;
        this.meter = meter;
        this.n = n;
    }

    public Integer getN() {
        return n;
    }

    public Optional<IClef> getClef() {
        return Optional.ofNullable(clef);
    }

    @Override
    public Optional<ICommonAlterationKeySignature> getCommonAlterationKey() {
        return Optional.ofNullable(commonAlterationKey);
    }

    @Override
    public Optional<IMeter> getMeter() {
        return Optional.ofNullable(meter);
    }

    @Override
    public MEIStaffDef clone() {
        return new MEIStaffDef(id, clef, commonAlterationKey, meter, n);
    }

    @Override
    public String toString() {
        return "MEIStaffDef{" +
                "commonAlterationKey=" + commonAlterationKey +
                ", meter=" + meter +
                ", clef=" + clef +
                ", n=" + n +
                "} " + super.toString();
    }
}
