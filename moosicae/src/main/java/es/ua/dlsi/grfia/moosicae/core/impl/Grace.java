package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IGrace;
import es.ua.dlsi.grfia.moosicae.core.IPitchedDurationalSingle;
import es.ua.dlsi.grfia.moosicae.core.properties.IGraceNoteType;
import es.ua.dlsi.grfia.moosicae.io.IExporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 29/10/2020
 */
public class Grace extends PitchedAbstractDecorator implements IGrace {
    protected final IGraceNoteType graceNoteType;

    public Grace(IPitchedDurationalSingle ipitchedDurationalSingle, IGraceNoteType graceNoteType) {
        super(ipitchedDurationalSingle);
        this.graceNoteType = graceNoteType;
    }

    @Override
    public IGraceNoteType getGraceNoteType() {
        return graceNoteType;
    }

    @Override
    public Grace clone() {
        return new Grace((IPitchedDurationalSingle) decoratesTo.clone(), graceNoteType);
    }

    @Override
    public <InputOutputType> void export(IExporterVisitor<InputOutputType> exportVisitor, InputOutputType inputOutput) throws IMException {
        exportVisitor.exportGrace(this, inputOutput);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grace)) return false;
        if (!super.equals(o)) return false;

        Grace grace = (Grace) o;

        return graceNoteType.equals(grace.graceNoteType);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + graceNoteType.hashCode();
        return result;
    }
}
