package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IDurationalSingle;
import es.ua.dlsi.grfia.moosicae.core.IPitched;
import es.ua.dlsi.grfia.moosicae.core.properties.IDots;
import es.ua.dlsi.grfia.moosicae.core.properties.IFigure;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class PitchedDurationalSingle extends DurationalSingle implements IDurationalSingle, IPitched {
    public PitchedDurationalSingle(IId id, @NotNull IFigure figure, IDots dots) {
        super(id, figure, dots);
    }
}
