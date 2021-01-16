package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IConventionalKeySignature;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.properties.IAccidentalSymbol;
import es.ua.dlsi.grfia.moosicae.core.properties.ICautionaryKeySignatureAccidentals;
import es.ua.dlsi.grfia.moosicae.core.properties.IKeyAccidentalCount;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IConventionalKeySignatureBuilder extends CoreObjectBuilder<IConventionalKeySignature> {
    private IAccidentalSymbol accidentalSymbol;
    protected IKeyAccidentalCount accidentalCount;
    private ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals;

    public IConventionalKeySignatureBuilder() {}

    public IConventionalKeySignatureBuilder from(IAccidentalSymbol accidentalSymbol) {
        this.accidentalSymbol = accidentalSymbol;
        return this;
    }

    public IConventionalKeySignatureBuilder from(IKeyAccidentalCount accidentalCount) {
        this.accidentalCount = accidentalCount;
        return this;
    }

    public IConventionalKeySignatureBuilder from(ICautionaryKeySignatureAccidentals cautionaryKeySignatureAccidentals) {
        this.cautionaryKeySignatureAccidentals = cautionaryKeySignatureAccidentals;
        return this;
    }
    @Override
    public IConventionalKeySignature build() throws IMException {
        return ICoreAbstractFactory.getInstance().createConventionalKeySignature(getId(), accidentalCount, accidentalSymbol, cautionaryKeySignatureAccidentals);
    }

}
