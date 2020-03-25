package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmlMeasure extends MxmlObject {
    //TODO number y otros atributos

    @NotNull
    private final IMxmlPartItem[] items;

    public MxmlMeasure(@NotNull IId id, IMxmlPartItem[] items) {
        super(id);
        this.items = items;
    }

    public IMxmlPartItem[] getItems() {
        return items;
    }

    @Override
    public MxmlMeasure clone() {
        return new MxmlMeasure(id, items);
    }
}
