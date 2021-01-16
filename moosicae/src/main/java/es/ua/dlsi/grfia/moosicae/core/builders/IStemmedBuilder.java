package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.core.IStemmed;
import es.ua.dlsi.grfia.moosicae.core.properties.*;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class IStemmedBuilder<T extends IStemmed> extends IDurationalSingleBuilder<T> {
    protected IStem stem;

    public IStemmedBuilder(){
    }

    public IStemmedBuilder from(IStem stem) {
        this.stem = stem;
        return this;
    }
}
