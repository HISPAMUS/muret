package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IPitchClassBuilder extends CoreObjectBuilder<IPitchClass> {
    IDiatonicPitch diatonicPitch;
    IAccidentalSymbol accidentalSymbol;

    public IPitchClassBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setDiatonicPitch(IDiatonicPitch diatonicPitch) {
        this.diatonicPitch = diatonicPitch;
    }

    public void setAccidentalSymbol(IAccidentalSymbol accidentalSymbol) {
        this.accidentalSymbol = accidentalSymbol;
    }

    @Override
    public IPitchClass build() throws IMException {
        assertRequired("diatonicPitch", diatonicPitch);
        return coreObjectFactory.createPitchClass(getId(), diatonicPitch, accidentalSymbol);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importPitchClass(this, inputOutputType);
    }
}
