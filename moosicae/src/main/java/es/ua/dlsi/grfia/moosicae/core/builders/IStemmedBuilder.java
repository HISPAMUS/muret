package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IPitchedDurationalSingle;
import es.ua.dlsi.grfia.moosicae.core.IStemmed;
import es.ua.dlsi.grfia.moosicae.core.properties.*;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IStemmedBuilder extends CoreObjectBuilder<IStemmed> {
    protected IStem stem;
    protected IPitchedDurationalSingle decoratesTo;

    public IStemmedBuilder(){
    }

    public IStemmedBuilder from(IStem stem) {
        this.stem = stem;
        return this;
    }

    public IStemmedBuilder from(IPitchedDurationalSingle decoratesTo) {
        this.decoratesTo = decoratesTo;
        return this;
    }

    @Override
    public IStemmed build() throws IMException {
        if (stem == null) {
            throw new IMException("Missing stem");
        }
        if (decoratesTo == null) {
            throw new IMException("Missing decorates to");
        }
        return ICoreAbstractFactory.getInstance().createStemmed(decoratesTo, stem);
    }
}
