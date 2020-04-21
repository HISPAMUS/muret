package es.ua.dlsi.grfia.moosicae.core.impl.properties;

import es.ua.dlsi.grfia.moosicae.core.properties.ICautionaryKeySignatureAccidentals;
import es.ua.dlsi.grfia.moosicae.core.properties.IId;

import javax.validation.constraints.NotNull;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 21/04/2020
 */
public class CautionaryKeySignatureAccidentals extends BooleanCoreProperty implements ICautionaryKeySignatureAccidentals {

    public CautionaryKeySignatureAccidentals(IId id, @NotNull Boolean value) {
        super(id, value);
    }

    @Override
    public CautionaryKeySignatureAccidentals clone() {
        return new CautionaryKeySignatureAccidentals(null, value);
    }
}
