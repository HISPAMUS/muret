package es.ua.dlsi.grfia.moosicae.core.builders;


import es.ua.dlsi.grfia.moosicae.core.IPitchedDurationalSingle;
import es.ua.dlsi.grfia.moosicae.core.properties.IGraceNoteType;
import es.ua.dlsi.grfia.moosicae.core.properties.IStem;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public abstract class IPitchedDurationalSingleBuilder<T extends IPitchedDurationalSingle> extends IDurationalSingleBuilder<T> {
    protected IGraceNoteType graceNoteType;
    protected IStem stem;

    public IPitchedDurationalSingleBuilder(){
    }


    public IPitchedDurationalSingleBuilder from(IGraceNoteType graceNoteType) {
        this.graceNoteType = graceNoteType;
        return this;
    }

    public IPitchedDurationalSingleBuilder from(IStem stem) {
        this.stem = stem;
        return this;
    }

}
