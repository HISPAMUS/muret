package es.ua.dlsi.grfia.im4.io.mei;

import es.ua.dlsi.grfia.im4.io.IExporterContext;
import es.ua.dlsi.grfia.im4.utils.visitor.VisitorBaseDecorator;

public class MEIExporterAttrOrElement extends VisitorBaseDecorator<MEIExporterContext> implements IExporterContext {
    private final boolean resultAddedAsAttribute;

    public MEIExporterAttrOrElement(MEIExporterContext MEIExporterContext, boolean resultAddedAsAttribute) {
        super(MEIExporterContext);
        this.resultAddedAsAttribute = resultAddedAsAttribute;
    }

    public boolean isResultAddedAsAttribute() {
        return resultAddedAsAttribute;
    }
}
