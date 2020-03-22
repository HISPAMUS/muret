package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
        return coreObjectFactory.createNote(getId(), figure, dots, pitch);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importNote(this, inputOutputType);
    }

    /**
     * Convenience builder
     */
    public INote build(@NotNull EDiatonicPitches eDiatonicPitch, @Nullable EAccidentalSymbols accidentalSymbol,
                       int octaveNumber, EFigures efigure, int ndots) throws IMException {
        IPitchBuilder pitchBuilder = new IPitchBuilder(coreObjectFactory);
        pitch = pitchBuilder.build(eDiatonicPitch, accidentalSymbol, octaveNumber);
        setFigure(efigure);
        if (ndots > 0) {
            setDots(ndots);
        }
        return build();
    }
}
