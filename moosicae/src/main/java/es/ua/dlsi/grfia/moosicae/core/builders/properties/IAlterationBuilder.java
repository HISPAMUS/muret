package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EAlterationDisplayTypes;
import es.ua.dlsi.grfia.moosicae.core.properties.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.properties.IAlteration;
import es.ua.dlsi.grfia.moosicae.core.properties.IAlterationDisplayType;



/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IAlterationBuilder extends CoreObjectBuilder<IAlteration> {
    private IAccidentalSymbol accidentalSymbol;
    private IAlterationDisplayType alterationDisplayType;

    public IAlterationBuilder() {}

    public IAlterationBuilder from(IAccidentalSymbol accidentalSymbol) {
        this.accidentalSymbol = accidentalSymbol;
        return this;
    }

    public IAlterationBuilder from(EAccidentalSymbols accidentalSymbol) {
        this.accidentalSymbol = ICoreAbstractFactory.getInstance().createAccidentalSymbol(getId(), accidentalSymbol);
        return this;
    }

    public IAlterationBuilder from(IAlterationDisplayType alterationDisplayType) {
        this.alterationDisplayType = alterationDisplayType;
        return this;
    }

    public IAlterationBuilder from(EAlterationDisplayTypes alterationDisplayType) {
        this.alterationDisplayType = ICoreAbstractFactory.getInstance().createAlterationDisplayType(getId(), alterationDisplayType);
        return this;
    }


    @Override
    public IAlteration build() throws IMException {
        return ICoreAbstractFactory.getInstance().createAlteration(getId(), accidentalSymbol, alterationDisplayType);
    }

}
