package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitch;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IChordBuilder extends IDurationalSingleBuilder<IChord> {
    private List<IPitch> pitchList;

    public IChordBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
        pitchList = new LinkedList<>();
    }

    public IChordBuilder add(IPitch pitch) {
        pitchList.add(pitch);
        return this;
    }

    @Override
    public IChord build() throws IMException {
        return coreObjectFactory.createChord(getId(), figure, dots, pitchList.toArray(new IPitch[pitchList.size()]));
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importChord(this, inputOutputType);
    }
}
