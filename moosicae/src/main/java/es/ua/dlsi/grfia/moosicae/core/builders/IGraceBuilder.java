package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IGrace;
import es.ua.dlsi.grfia.moosicae.core.IPitchedDurationalSingle;
import es.ua.dlsi.grfia.moosicae.core.IStemmed;
import es.ua.dlsi.grfia.moosicae.core.properties.IGraceNoteType;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IGraceBuilder extends CoreObjectBuilder<IGrace> {
    protected IGraceNoteType graceNoteType;
    protected IPitchedDurationalSingle decoratesTo;

    public IGraceBuilder(){
    }

    public IGraceBuilder from(IGraceNoteType graceNoteType) {
        this.graceNoteType = graceNoteType;
        return this;
    }

    public IGraceBuilder from(IPitchedDurationalSingle decoratesTo) {
        this.decoratesTo = decoratesTo;
        return this;
    }
    @Override
    public IGrace build() throws IMException {
        if (graceNoteType == null) {
            throw new IMException("Missing grace note type");
        }
        if (decoratesTo == null) {
            throw new IMException("Missing decorates to");
        }
        return ICoreAbstractFactory.getInstance().createGrace(decoratesTo, graceNoteType);
    }
}
