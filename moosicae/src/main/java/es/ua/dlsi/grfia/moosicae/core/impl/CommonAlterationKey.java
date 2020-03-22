package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class CommonAlterationKey extends Key implements ICommonAlterationKey {
    @NotNull
    private final int accidentalCount;
    @NotNull
    private final IAccidentalCore accidentalSymbol;

    CommonAlterationKey(@NotNull IId id, @NotNull IPitchClass pitchClass, @NotNull IMode mode, @NotNull IKeySignature keySignature, @NotNull Integer accidentalCount, @Nullable IAccidentalCore accidentalSymbol) {
        super(id, pitchClass, mode, keySignature);
        this.accidentalCount = accidentalCount;
        this.accidentalSymbol = accidentalSymbol;
    }

    @Override
    public int getAccidentalCount() {
        return accidentalCount;
    }

    @Override
    public Optional<IAccidentalCore> getAccidentalSymbol() {
        return Optional.ofNullable(accidentalSymbol);
    }

    @Override
    public Key clone() {
        return new CommonAlterationKey(IdGenerator.getInstance().generateUniqueId(), getPitchClass(), getMode(), getKeySignature(), accidentalCount, accidentalSymbol);
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
        exportVisitor.export(this, inputOutput);
    }
}
