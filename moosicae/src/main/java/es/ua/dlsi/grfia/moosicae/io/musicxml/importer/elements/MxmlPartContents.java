package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmlPartContents extends MxmlObject {
    @NotNull
    private final MxmlMeasure[] measures;

    public MxmlPartContents(@NotNull IId id, MxmlMeasure[] measures) {
        super(id);
        this.measures = measures;
    }

    public MxmlMeasure[] getMeasures() {
        return measures;
    }

    @Override
    public MxmlPartContents clone() {
        return new MxmlPartContents(id, measures);
    }
}
