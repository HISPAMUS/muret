package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.IConventionalKeySignature;
import es.ua.dlsi.grfia.moosicae.core.IKey;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIScoreDef extends MEIObject implements IMEIDef {
    private final IKey key;
    private final IConventionalKeySignature conventionalKeySignature;
    private final IMeter meter;
    private final MEIStaffGroupDef meiStaffGroupDef;

    public MEIScoreDef(IId id, IKey key, IConventionalKeySignature conventionalKeySignature, IMeter meter, MEIStaffGroupDef meiStaffGroupDef) {
        super(id);
        this.key = key;
        this.conventionalKeySignature = conventionalKeySignature;
        this.meter = meter;
        this.meiStaffGroupDef = meiStaffGroupDef;
    }

    @Override
    public Optional<IKey> getKey() {
        return Optional.ofNullable(key);
    }

    @Override
    public Optional<IConventionalKeySignature> getConventionalKeySignature() {
        return Optional.ofNullable(conventionalKeySignature);
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
        return new MEIScoreDef(id, key, conventionalKeySignature, meter, meiStaffGroupDef);
    }

    @Override
    public String toString() {
        return "MEIScoreDef{" +
                "key=" + key +
                ", conventionalKeySignature=" + conventionalKeySignature +
                ", meter=" + meter +
                ", meiStaffGroupDef=" + meiStaffGroupDef +
                "} " + super.toString();
    }
}
