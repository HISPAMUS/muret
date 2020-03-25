package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.IClefLine;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class ClefLine extends IntegerCoreCoreProperty implements IClefLine {


    public ClefLine(IId id, @NotNull Integer value) {
        super(id, value);
    }

    @Override
    public ClefLine clone() {
        return new ClefLine(id, value);
    }
}
