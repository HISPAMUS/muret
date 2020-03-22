package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IClefLine;
import es.ua.dlsi.grfia.moosicae.core.IId;
import org.jetbrains.annotations.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class ClefLine extends IntegerCoreCoreProperty implements IClefLine {


    public ClefLine(@NotNull IId id, @NotNull Integer value) {
        super(id, value);
    }

    @Override
    public ClefLine clone() {
        return new ClefLine(id, value);
    }
}
