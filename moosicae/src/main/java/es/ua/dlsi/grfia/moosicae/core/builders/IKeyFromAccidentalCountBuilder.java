package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.properties.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.properties.IKeyAccidentalCount;
import es.ua.dlsi.grfia.moosicae.core.properties.IMode;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IKeyFromAccidentalCountBuilder extends CoreObjectBuilder<ICommonAlterationKeySignature> {
    private IAccidentalSymbol accidentalSymbol;
    protected IKeyAccidentalCount accidentalCount;
    private IMode mode;

    public IKeyFromAccidentalCountBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public IKeyFromAccidentalCountBuilder from(IAccidentalSymbol accidentalSymbol) {
        this.accidentalSymbol = accidentalSymbol;
        return this;
    }

    public IKeyFromAccidentalCountBuilder from(IKeyAccidentalCount accidentalCount) {
        this.accidentalCount = accidentalCount;
        return this;
    }

    public IKeyFromAccidentalCountBuilder from(IMode mode) {
        this.mode = mode;
        return this;
    }

    @Override
    public ICommonAlterationKeySignature build() throws IMException {
        return coreObjectFactory.createCommonAlterationKey(getId(), accidentalCount, accidentalSymbol, mode);
    }

}
