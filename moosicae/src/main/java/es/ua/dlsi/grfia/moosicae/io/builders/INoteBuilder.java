package es.ua.dlsi.grfia.moosicae.io.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class INoteBuilder extends IDurationalSingleBuilder<INote> {
    private IPitch pitch;

    public INoteBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setPitch(IPitch pitch) {
        this.pitch = pitch;
    }

    @Override
    public INote build() throws IMException {
        super.assertRequired();
        assertRequired("pitch", pitch);
        return coreObjectFactory.createNote(figure, Optional.ofNullable(dots), pitch);
    }
}
