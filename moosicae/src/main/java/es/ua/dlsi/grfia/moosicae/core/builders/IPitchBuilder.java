package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IPitchBuilder extends CoreObjectBuilder<IPitch> {
    private IOctave octave;
    private IAlteration alteration;
    private IDiatonicPitch diatonicPitch;

    public IPitchBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setOctave(IOctave octave) {
        this.octave = octave;
    }

    public void setAlteration(IAlteration alteration) {
        this.alteration = alteration;
    }

    public void setDiatonicPitch(IDiatonicPitch diatonicPitch) {
        this.diatonicPitch = diatonicPitch;
    }

    public void setOctave(int octave) {
        this.octave = coreObjectFactory.createOctave(getId(), octave);
    }

    /**
     * Convenience builder
     */
    public IPitch build(@NotNull EDiatonicPitches eDiatonicPitch, @Nullable EAccidentalSymbols accidentalSymbol,
                        int octaveNumber) throws IMException {
        octave = coreObjectFactory.createOctave(getId(), octaveNumber);
        if (accidentalSymbol != null) {
            alteration = coreObjectFactory.createAlteration(
                    getId(),
                    coreObjectFactory.createAccidentalSymbol(getId(), accidentalSymbol),
                    null
            );
        }
        diatonicPitch = coreObjectFactory.createDiatonicPitch(getId(), eDiatonicPitch);
        return build();
    }

    @Override
    public IPitch build() throws IMException {
        assertRequired("octave", octave);
        assertRequired("diatonicPitch", diatonicPitch);
        return coreObjectFactory.createPitch(getId(), octave, alteration, diatonicPitch);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importPitch(this, inputOutputType);
    }
}
