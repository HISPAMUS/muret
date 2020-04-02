package es.ua.dlsi.grfia.moosicae.io.mei.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.IClef;
import es.ua.dlsi.grfia.moosicae.core.IConventionalKeySignature;
import es.ua.dlsi.grfia.moosicae.core.IKey;
import es.ua.dlsi.grfia.moosicae.core.IMeter;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 25/03/2020
 */
public class MEIStaffDef extends MEISystemDef implements IMEIDef {
    private final IKey key;
    private final IConventionalKeySignature conventionalKeySignature;
    private IMeter meter;
    private IClef clef;

    @NotNull
    private Integer n;


    public MEIStaffDef(IId id, @NotNull Integer n, IClef clef, IConventionalKeySignature conventionalKeySignature, IKey key, IMeter meter) {
        super(id);
        this.key = key;
        this.conventionalKeySignature = conventionalKeySignature;
        this.meter = meter;
        this.clef = clef;
        this.n = n;
    }

    public Integer getN() {
        return n;
    }

    public Optional<IClef> getClef() {
        return Optional.ofNullable(clef);
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


    @Override
    public MEIStaffDef clone() {
        return new MEIStaffDef(null, n, clef, conventionalKeySignature, key, meter);
    }
}
