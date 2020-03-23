package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EAlterationDisplayTypes;
import es.ua.dlsi.grfia.moosicae.core.properties.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.properties.IAlteration;
import es.ua.dlsi.grfia.moosicae.core.properties.IAlterationDisplayType;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IAlterationBuilder extends CoreObjectBuilder<IAlteration> {
    private IAccidentalSymbol accidentalSymbol;
    private IAlterationDisplayType alterationDisplayType;

    public IAlterationBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public IAlterationBuilder from(IAccidentalSymbol accidentalSymbol) {
        this.accidentalSymbol = accidentalSymbol;
        return this;
    }

    public IAlterationBuilder from(EAccidentalSymbols accidentalSymbol) {
        this.accidentalSymbol = coreObjectFactory.createAccidentalSymbol(getId(), accidentalSymbol);
        return this;
    }

    public IAlterationBuilder from(IAlterationDisplayType alterationDisplayType) {
        this.alterationDisplayType = alterationDisplayType;
        return this;
    }

    public IAlterationBuilder from(EAlterationDisplayTypes alterationDisplayType) {
        this.alterationDisplayType = coreObjectFactory.createAlterationDisplayType(getId(), alterationDisplayType);
        return this;
    }


    @Override
    public IAlteration build() throws IMException {
        return coreObjectFactory.createAlteration(getId(), accidentalSymbol, alterationDisplayType);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importAlteration(this, inputOutputType);
    }
}
