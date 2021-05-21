package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.IMark;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;
import es.ua.dlsi.grfia.moosicae.core.properties.IMarkAnchor;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 21/5/21
 */
public abstract class Mark extends MooObject implements IMark {
    @NotNull
    IMarkAnchor start;

    /**
     * @param id If id is null, a new id is generated. If not null, the value is assigned
     */
    public Mark(IId id, @NotNull IMarkAnchor start) {
        super(id);
        this.start = start;
    }

    @Override
    public IMarkAnchor getStart() {
        return start;
    }

}
