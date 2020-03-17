package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IChordBuilder extends IDurationalSingleBuilder<IChord> {
    private List<IPitch> pitchList;

    public IChordBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
        pitchList = new LinkedList<>();
    }

    public void addPitch(IPitch pitch) {
        pitchList.add(pitch);
    }
    @Override
    public IChord build() throws IMException {
        if (pitchList.isEmpty()) {
            throw new IMException("Missing at least one pitch");
        }

        super.assertRequired();
        return coreObjectFactory.createChord(figure, Optional.ofNullable(dots), pitchList.toArray(new IPitch[pitchList.size()]));
    }
}
