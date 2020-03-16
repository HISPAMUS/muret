package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class CommonAlterationKey extends Key implements ICommonAlterationKey {
    private final int accidentalCount;
    private final Optional<IAccidentalSymbol> accidentalSymbol;

    CommonAlterationKey(IPitchClass pitchClass, IMode mode, IKeySignature keySignature, int accidentalCount, Optional<IAccidentalSymbol> accidentalSymbol) {
        super(pitchClass, mode, keySignature);
        this.accidentalCount = accidentalCount;
        this.accidentalSymbol = accidentalSymbol;
    }

    @Override
    public int getAccidentalCount() {
        return accidentalCount;
    }

    @Override
    public Optional<IAccidentalSymbol> getAccidentalSymbol() {
        return accidentalSymbol;
    }

    @Override
    public Key clone() {
        return new CommonAlterationKey(getPitchClass(), getMode(), getKeySignature(), accidentalCount, accidentalSymbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommonAlterationKey)) return false;

        CommonAlterationKey commonKey = (CommonAlterationKey) o;

        if (accidentalCount != commonKey.accidentalCount) return false;
        return accidentalSymbol.equals(commonKey.accidentalSymbol);
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
    public <InputOutputType> void export(IExporterVisitor exportVisitor, InputOutputType inputOutput) {
        exportVisitor.export(this, inputOutput);
    }
}
