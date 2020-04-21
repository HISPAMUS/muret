package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.IConventionalKeySignature;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.DiatonicPitch;
import es.ua.dlsi.grfia.moosicae.core.impl.properties.PitchClass;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.core.utils.ICircleOfFifths;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;
import javax.validation.constraints.NotNull;


import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class ConventionalKeySignature extends KeySignature implements IConventionalKeySignature {
    @NotNull
    private final IKeyAccidentalCount accidentalCount;

    private final IAccidentalSymbol accidentalSymbol;

    ConventionalKeySignature(IId id, @NotNull IKeyAccidentalCount accidentalCount, IAccidentalSymbol accidentalSymbol, ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals) {
        super(id, buildPitchClasses(accidentalCount, accidentalSymbol), cautionaryKeySignatureAccidentals);
        this.accidentalCount = accidentalCount;
        this.accidentalSymbol = accidentalSymbol;
    }

    private static IPitchClass[] buildPitchClasses(IKeyAccidentalCount keyAccidentalCount, IAccidentalSymbol accidentalSymbol) {
        int accidentalCount = keyAccidentalCount.getValue();

        if (accidentalCount < 0) {
            throw new IMRuntimeException("The number of accidentals cannot be negative");
        }
        if (accidentalCount > 7) {
            throw new IMRuntimeException("The number of accidentals cannot be > 7, and it is " + accidentalCount);
        }

        EDiatonicPitches [] diatonicPitches;
        IPitchClass [] result = new IPitchClass[accidentalCount];
        if (accidentalCount > 0) {
            if (accidentalSymbol.getValue() == EAccidentalSymbols.FLAT) {
                diatonicPitches = ICircleOfFifths.KEY_SIGNATURE_STAFF_FLATS;
            } else if (accidentalSymbol.getValue() == EAccidentalSymbols.SHARP) {
                diatonicPitches = ICircleOfFifths.KEY_SIGNATURE_STAFF_SHARPS;
            } else {
                throw new IMRuntimeException("Invalid accidental for the key conventional signature: " + accidentalSymbol.getValue());
            }
            for (int i = 0; i < accidentalCount; i++) {
                IPitchClass pitchClass = new PitchClass(null, new DiatonicPitch(null, diatonicPitches[i]), accidentalSymbol);
                result[i] = pitchClass;
            }
        }
        return result;
    }

    @Override
    public IKeyAccidentalCount getAccidentalCount() {
        return accidentalCount;
    }

    @Override
    public Optional<IAccidentalSymbol> getAccidentalSymbol() {
        return Optional.ofNullable(accidentalSymbol);
    }

    @Override
    public ConventionalKeySignature clone() {
        return new ConventionalKeySignature(null, accidentalCount, accidentalSymbol, cautionaryKeySignatureAccidentals);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConventionalKeySignature)) return false;
        if (!super.equals(o)) return false;

        ConventionalKeySignature that = (ConventionalKeySignature) o;

        if (!accidentalCount.equals(that.accidentalCount)) return false;
        return accidentalSymbol != null ? accidentalSymbol.equals(that.accidentalSymbol) : that.accidentalSymbol == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + accidentalCount.hashCode();
        result = 31 * result + (accidentalSymbol != null ? accidentalSymbol.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CommonKey{" +
                "accidentalCount=" + accidentalCount +
                ", accidentalSymbol=" + accidentalSymbol +
                ", cautionary=" + cautionaryKeySignatureAccidentals +
                "} " + super.toString();
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportConventionalKeySignature(this, inputOutput);
    }


}
