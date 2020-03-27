package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.INoteHead;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitch;


import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IChordBuilder extends IDurationalSingleBuilder<IChord> {
    private List<INoteHead> noteHeads;

    public IChordBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
        noteHeads = new LinkedList<>();
    }

    public IChordBuilder add(INoteHead noteHead) {
        noteHeads.add(noteHead);
        return this;
    }

    @Override
    public IChord build() throws IMException {
        return coreObjectFactory.createChord(getId(), figure, dots, noteHeads.toArray(new INoteHead[0]));
    }


}
