package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 04/04/2020
 */
public class AdditiveMeter extends CompositeMeter implements IAdditiveMeter {
    @NotNull
    private final ITimeSignatureNumerator[] numerators;

    @NotNull
    private final ITimeSignatureDenominator denominator;

    AdditiveMeter(IId id, @NotNull ITimeSignatureNumerator[] numerators, @NotNull ITimeSignatureDenominator denominator) {
        super(id, createSubmeters(numerators, denominator));
        this.numerators = numerators;
        this.denominator = denominator;
    }

    private static IMeter[] createSubmeters(ITimeSignatureNumerator[] numerators, ITimeSignatureDenominator denominator) {
        IMeter [] meters = new IMeter[numerators.length];
        for (int i=0; i<numerators.length; i++) {
            meters[i] = new StandardTimeSignature(null,
                    new TimeSignatureNumerator(null, numerators[i].getValue()),
                    new TimeSignatureDenominator(null, denominator.getValue()));
        }
        return meters;
    }

    @Override
    public ITimeSignatureNumerator[] getNumerators() {
        return numerators;
    }

    @Override
    public ITimeSignatureDenominator getDenominator() {
        return denominator;
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportAdditiveMeter(this, inputOutput);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdditiveMeter)) return false;
        if (!super.equals(o)) return false;

        AdditiveMeter that = (AdditiveMeter) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(numerators, that.numerators)) return false;
        return denominator.equals(that.denominator);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(numerators);
        result = 31 * result + denominator.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CompoundMeter{" +
                "numerators=" + Arrays.toString(numerators) +
                ", denominator=" + denominator +
                "} " + super.toString();
    }

    @Override
    public AdditiveMeter clone() {
        return new AdditiveMeter(null, numerators, denominator);
    }
}
