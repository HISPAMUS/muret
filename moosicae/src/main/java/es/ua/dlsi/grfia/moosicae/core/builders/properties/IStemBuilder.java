package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.CoreObjectBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EStemDirection;
import es.ua.dlsi.grfia.moosicae.core.properties.IStem;
import es.ua.dlsi.grfia.moosicae.core.properties.IStemDirection;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/03/2020
 */
public class IStemBuilder extends CoreObjectBuilder<IStem> {
    private IStemDirection stemDirection;

    public IStemBuilder from(IStemDirection value) {
        this.stemDirection = value;
        return this;
    }

    public IStemBuilder from(EStemDirection value) {
        this.stemDirection = ICoreAbstractFactory.getInstance().createStemDirection(null, value);
        return this;
    }

    @Override
    public IStem build() throws IMException {
        return ICoreAbstractFactory.getInstance().createStem(getId(), stemDirection);
    }

}
