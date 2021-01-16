package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.properties.INoteHead;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitch;
import es.ua.dlsi.grfia.moosicae.core.properties.ITie;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class INoteHeadBuilder extends CoreObjectBuilder<INoteHead> {
    private IPitch pitch;
    private ITie tieToNext;


    public INoteHeadBuilder() {}

    public INoteHeadBuilder from(IPitch pitch) {
        this.pitch = pitch;
        return this;
    }

    public INoteHeadBuilder from(ITie tieToNext) {
        this.tieToNext = tieToNext;
        return this;
    }
    @Override
    public INoteHead build() throws IMException {
        //TODO ties
        return ICoreAbstractFactory.getInstance().createNoteHead(null, pitch, tieToNext);
    }
}
