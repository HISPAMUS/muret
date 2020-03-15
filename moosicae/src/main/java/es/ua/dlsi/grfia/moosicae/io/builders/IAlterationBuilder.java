package es.ua.dlsi.grfia.moosicae.io.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;

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

    public void setAlterationDisplayType(IAlterationDisplayType alterationDisplayType) {
        this.alterationDisplayType = alterationDisplayType;
    }

    @Override
    public IAlteration build() throws IMException {
        assertRequired("accidentalSymbol", accidentalSymbol);
        return coreObjectFactory.createAlteration(accidentalSymbol, Optional.ofNullable(alterationDisplayType));
    }
}
