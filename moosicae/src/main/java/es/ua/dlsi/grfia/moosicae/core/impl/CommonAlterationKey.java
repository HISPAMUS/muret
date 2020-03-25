package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.IdGenerator;
import es.ua.dlsi.grfia.moosicae.core.properties.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IMode;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import javax.validation.constraints.NotNull;


import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class CommonAlterationKey extends Key implements ICommonAlterationKey {
    @NotNull
    private final int accidentalCount;
    @NotNull
    private final IAccidentalSymbol accidentalSymbol;

    CommonAlterationKey(IId id, @NotNull IPitchClass pitchClass, @NotNull IMode mode, @NotNull IKeySignature keySignature, @NotNull Integer accidentalCount,  IAccidentalSymbol accidentalSymbol) {
        super(id, pitchClass, mode, keySignature);
        this.accidentalCount = accidentalCount;
        this.accidentalSymbol = accidentalSymbol;
    }

    @Override
    public int getAccidentalCount() {
        return accidentalCount;
    }

    @Override
    public Optional<IAccidentalSymbol> getAccidentalSymbol() {
        return Optional.ofNullable(accidentalSymbol);
    }

    @Override
    public Key clone() {
        return new CommonAlterationKey(null, getPitchClass(), getMode(), getKeySignature(), accidentalCount, accidentalSymbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommonAlterationKey)) return false;

        CommonAlterationKey that = (CommonAlterationKey) o;

        if (accidentalCount != that.accidentalCount) return false;
        return accidentalSymbol.equals(that.accidentalSymbol);
    }

    @Override
    public int hashCode() {
        int result = accidentalCount;
        result = 31 * result + accidentalSymbol.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CommonKey{" +
                "accidentalCount=" + accidentalCount +
                ", accidentalSymbol=" + accidentalSymbol +
                "} " + super.toString();
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportCommonAlterationKey(this, inputOutput);
    }
}
