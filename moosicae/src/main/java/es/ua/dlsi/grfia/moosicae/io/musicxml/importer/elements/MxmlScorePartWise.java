package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.IPart;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmlScorePartWise extends MxmlObject {
    @NotNull
    private final IPart [] coreParts;
    @NotNull
    private final MxmlPartContents [] mxmlPartsContents;

    public MxmlScorePartWise(IId id, @NotNull IPart[] coreParts, @NotNull MxmlPartContents[] mxmlPartsContents) {
        super(id);
        this.coreParts = coreParts;
        this.mxmlPartsContents = mxmlPartsContents;
    }

    @Override
    public MxmlScorePartWise clone() {
        return new MxmlScorePartWise(null, coreParts, mxmlPartsContents);
    }


    public IPart[] getCoreParts() {
        return coreParts;
    }

    public MxmlPartContents[] getMxmlPartsContents() {
        return mxmlPartsContents;
    }
}
