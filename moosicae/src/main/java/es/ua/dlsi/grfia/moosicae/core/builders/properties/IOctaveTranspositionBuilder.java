package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class IOctaveTranspositionBuilder extends IIntegerPropertyBuilder<IOctaveTransposition>  {
    public IOctaveTranspositionBuilder(){
    }

    @Override
    public IOctaveTransposition build() throws IMException {
        return ICoreAbstractFactory.getInstance().createOctaveTransposition(getId(), value);
    }


}
