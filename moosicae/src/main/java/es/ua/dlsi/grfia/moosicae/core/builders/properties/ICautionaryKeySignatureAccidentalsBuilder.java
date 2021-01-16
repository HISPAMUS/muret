package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.properties.ICautionaryKeySignatureAccidentals;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class ICautionaryKeySignatureAccidentalsBuilder extends IBooleanPropertyBuilder<ICautionaryKeySignatureAccidentals>  {
    public ICautionaryKeySignatureAccidentalsBuilder() {
    }

    @Override
    public ICautionaryKeySignatureAccidentals build() throws IMException {
        return ICoreAbstractFactory.getInstance().createCautionaryKeySignatureAccidentals(getId(), value);
    }


}
