package es.ua.dlsi.grfia.moosicae.core.builders.properties;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.properties.IOctave;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class IOctaveBuilder extends IIntegerPropertyBuilder<IOctave>  {
    public IOctaveBuilder() {
    }

    @Override
    public IOctave build() throws IMException {
        return ICoreAbstractFactory.getInstance().createOctave(getId(), value);
    }


}
