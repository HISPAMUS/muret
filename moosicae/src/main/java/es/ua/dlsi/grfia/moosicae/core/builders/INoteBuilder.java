package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IAlterationBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IDiatonicPitchBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IDotsBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IFigureBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.core.properties.*;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class INoteBuilder extends IDurationalSingleBuilder<INote> {
    private IPitch pitch;

    public INoteBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public INoteBuilder from(IPitch pitch) {
        this.pitch = pitch;
        return this;
    }

    @Override
    public INote build() throws IMException {
        return coreObjectFactory.createNote(getId(), figure, dots, pitch);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importNote(this, inputOutputType);
    }

    /**
     * Convenience build method, that uses the most usual parameters of notes
     */
    public INote build(EDiatonicPitches ediatonicPitch, EAccidentalSymbols eAccidentalSymbol, int octave, EFigures efigure, int ndots) throws IMException {
        IDiatonicPitch diatonicPitch = new IDiatonicPitchBuilder(coreObjectFactory).from(ediatonicPitch).build();
        IAlteration alteration = new IAlterationBuilder(coreObjectFactory).from(eAccidentalSymbol).build();
        IDots dots = null;
        if (ndots > 0) {
            dots = new IDotsBuilder(coreObjectFactory).from(ndots).build();
        }
        IPitch pitch = new IPitchBuilder(coreObjectFactory).from(diatonicPitch).from(alteration).from(octave).build();
        from(pitch);
        from(efigure);
        from(dots);
        return build();
    }
}
