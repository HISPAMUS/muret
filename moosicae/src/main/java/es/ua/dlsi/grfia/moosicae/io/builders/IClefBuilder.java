package es.ua.dlsi.grfia.moosicae.io.builders;

import es.ua.dlsi.grfia.moosicae.core.ClefSignTypes;
import es.ua.dlsi.grfia.moosicae.core.IClef;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.IMException;

public class IClefBuilder extends SymbolFromPropertiesBuilder<IClef> {
    public static final String PROP_LINE = "line";
    public static final String PROP_SHAPE = "shape";

    public IClefBuilder(ICoreAbstractFactory coreSymbolFactory) {
        super(coreSymbolFactory);
    }

    @Override
    public IClef build() throws IMException {
        String lineStr = getRequiredProperty(PROP_LINE);
        String noteStr = getRequiredProperty(PROP_SHAPE);

        ClefSignTypes clefSignType = ClefSignTypes.valueOf(noteStr.toUpperCase());
        if (clefSignType == null) {
            throw new IMException("Cannot find a clef sign for '" + noteStr + "'");
        }

        int line = Integer.parseInt(lineStr);
        return coreSymbolFactory.createClef(line, clefSignType);
    }
}
