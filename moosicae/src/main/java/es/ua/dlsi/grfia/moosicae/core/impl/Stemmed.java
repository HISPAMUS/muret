package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IStemmed;
import es.ua.dlsi.grfia.moosicae.core.properties.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 29/10/2020
 */
public abstract class Stemmed extends DurationalSingle implements IStemmed {
    protected final IStem stem;

    public Stemmed(IId id, @NotNull IFigure figure, IDots dots, IStem stem) {
        super(id, figure, dots);
        this.stem = stem;
    }

    public Stemmed(IId id, @NotNull IFigure figure, IDots dots) {
        super(id, figure, dots);
        this.stem = null;
    }

    @Override
    public Optional<IStem> getStem() {
        return Optional.ofNullable(stem);
    }
}
