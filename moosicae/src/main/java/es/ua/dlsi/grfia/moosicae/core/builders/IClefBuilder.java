package es.ua.dlsi.grfia.moosicae.core.builders;

import es.ua.dlsi.grfia.moosicae.core.IClef;
import es.ua.dlsi.grfia.moosicae.core.IClefLine;
import es.ua.dlsi.grfia.moosicae.core.IClefSign;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.io.IImporterVisitor;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class IClefBuilder extends CoreObjectBuilder<IClef> {
    public IClefBuilder(ICoreAbstractFactory coreObjectFactory) {
        super(coreObjectFactory);
    }
    private IClefLine line;
    private IClefSign clefSign;

    public void setLine(IClefLine line) {
        this.line = line;
    }

    public void setClefSign(IClefSign clefSign) {
        this.clefSign = clefSign;
    }

    @Override
    public IClef build() throws IMException {
        assertRequired("clefSign", clefSign);
        assertRequired("line", line);
        return coreObjectFactory.createClef(getId(), line, clefSign);
    }

    @Override
    public <InputOutputType> void doImport(IImporterVisitor<InputOutputType> importerVisitor, InputOutputType inputOutputType) {
        importerVisitor.importClef(this, inputOutputType);
    }
}
