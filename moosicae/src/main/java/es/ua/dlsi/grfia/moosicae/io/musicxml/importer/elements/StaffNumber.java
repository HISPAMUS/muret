package es.ua.dlsi.grfia.moosicae.io.musicxml.importer.elements;

import es.ua.dlsi.grfia.moosicae.core.impl.properties.IntegerCoreCoreProperty;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 23/03/2020
 */
public class StaffNumber extends IntegerCoreCoreProperty {
    public StaffNumber(IId id, @NotNull Integer value) {
        super(id, value);
    }

    @Override
    public StaffNumber clone() {
        return new StaffNumber(id, value);
    }
}
