package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IIntegerCoreProperty;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/03/2020
 */
public class MxmlDivisions extends MxmlObject implements IIntegerCoreProperty {
    @NotNull
    private final Integer value;

    public MxmlDivisions(IId id, @NotNull Integer value) {
        super(id);
        this.value = value;
    }

    @Override
    public MxmlDivisions clone() {
        return new MxmlDivisions(null, value);
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MxmlDivisions{" +
                "value=" + value +
                "} " + super.toString();
    }
}
