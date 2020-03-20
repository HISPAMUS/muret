package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EAlterationDisplayTypes;

import java.util.Optional;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IAlterationBuilder extends CoreObjectBuilder<IAlteration> {
    private IAccidentalSymbol accidentalSymbol;
    private IAlterationDisplayType alterationDisplayType;

    public IAlterationBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setAccidentalSymbol(IAccidentalSymbol accidentalSymbol) {
        this.accidentalSymbol = accidentalSymbol;
    }

    public void setAccidentalSymbol(EAccidentalSymbols accidentalSymbol) {
        this.accidentalSymbol = coreObjectFactory.createAccidentalSymbol(accidentalSymbol);
    }

    public void setAlterationDisplayType(IAlterationDisplayType alterationDisplayType) {
        this.alterationDisplayType = alterationDisplayType;
    }

    public void setAlterationDisplayType(EAlterationDisplayTypes alterationDisplayType) {
        this.alterationDisplayType = coreObjectFactory.createAlterationDisplayType(alterationDisplayType);
    }


    @Override
    public IAlteration build() throws IMException {
        assertRequired("accidentalSymbol", accidentalSymbol);
        return coreObjectFactory.createAlteration(accidentalSymbol, Optional.ofNullable(alterationDisplayType));
    }
}
