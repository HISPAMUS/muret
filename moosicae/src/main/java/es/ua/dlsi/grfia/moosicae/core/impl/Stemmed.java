package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IPitchedDurationalSingle;
import es.ua.dlsi.grfia.moosicae.core.IStemmed;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 29/10/2020
 */
public class Stemmed extends PitchedAbstractDecorator implements IStemmed {
    protected final IStem stem;

    public Stemmed(IPitchedDurationalSingle ipitchedDurationalSingle, IStem stem) {
        super(ipitchedDurationalSingle);
        this.stem = stem;
    }

    @Override
    public IStem getStem() {
        return stem;
    }

    @Override
    public Stemmed clone() {
        return new Stemmed((IPitchedDurationalSingle) decoratesTo.clone(), stem);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportStemmed(this, inputOutput);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stemmed)) return false;
        if (!super.equals(o)) return false;

        Stemmed stemmed = (Stemmed) o;

        return stem.equals(stemmed.stem);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + stem.hashCode();
        return result;
    }
}
