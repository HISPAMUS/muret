package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.core.IClef;
import es.ua.dlsi.grfia.moosicae.core.IClefSign;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.IMException;
/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IClefBuilder extends CoreObjectBuilder<IClef> {
    public IClefBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }
    private Integer line;
    private IClefSign clefSign;

    public void setLine(Integer line) {
        this.line = line;
    }

    public void setClefSign(IClefSign clefSign) {
        this.clefSign = clefSign;
    }

    @Override
    public IClef build() throws IMException {
        assertRequired("clefSign", clefSign);
        assertRequired("line", line);
        return coreObjectFactory.createClef(line, clefSign);
    }
}
