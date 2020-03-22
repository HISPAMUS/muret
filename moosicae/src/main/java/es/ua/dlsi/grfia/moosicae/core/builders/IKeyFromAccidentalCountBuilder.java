package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IKeyFromAccidentalCountBuilder extends CoreObjectBuilder<IKey> {
    private IAccidentalCore accidentalSymbol;
    private Integer accidentalCount;
    private IMode mode;

    public IKeyFromAccidentalCountBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }

    public void setAccidentalSymbol(IAccidentalCore accidentalSymbol) {
        this.accidentalSymbol = accidentalSymbol;
    }

    public void setAccidentalCount(Integer accidentalCount) {
        this.accidentalCount = accidentalCount;
    }

    public void setMode(IMode mode) {
        this.mode = mode;
    }

    @Override
    public IKey build() throws IMException {
        assertRequired("accidentalSymbol", accidentalSymbol);
        assertRequired("accidentalCount", accidentalCount);
        assertRequired("mode", mode);
        return coreObjectFactory.createKey(getId(), accidentalCount, accidentalSymbol, mode);
    }
}
