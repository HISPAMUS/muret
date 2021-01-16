package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.core.IClef;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IOctaveTransposition;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefLine;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefSign;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.IMException;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IClefBuilder extends CoreObjectBuilder<IClef> {
    public IClefBuilder() {}
    protected IClefLine line;
    protected IClefSign clefSign;
    protected IOctaveTransposition octaveTransposition;

    public IClefBuilder from(IClefLine line) {
        this.line = line;
        return this;
    }

    public IClefBuilder from(IClefSign clefSign) {
        this.clefSign = clefSign;
        return this;
    }

    public IClefBuilder from(IOctaveTransposition octaveTransposition) {
        this.octaveTransposition = octaveTransposition;
        return this;
    }

    public void from(EClefSigns clefSign) {
        this.clefSign = ICoreAbstractFactory.getInstance().createClefSign(null, clefSign);
    }

    @Override
    public IClef build() throws IMException {
        return ICoreAbstractFactory.getInstance().createClef(getId(), clefSign, line, octaveTransposition);
    }

}
