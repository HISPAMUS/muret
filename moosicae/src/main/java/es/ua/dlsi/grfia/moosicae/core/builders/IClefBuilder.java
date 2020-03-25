package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.core.IClef;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefLine;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefSign;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.IMException;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IClefBuilder extends CoreObjectBuilder<IClef> {
    public IClefBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }
    private IClefLine line;
    private IClefSign clefSign;

    public IClefBuilder from(IClefLine line) {
        this.line = line;
        return this;
    }

    public IClefBuilder from(IClefSign clefSign) {
        this.clefSign = clefSign;
        return this;
    }

    @Override
    public IClef build() throws IMException {
        return coreObjectFactory.createClef(getId(), line, clefSign);
    }

}
