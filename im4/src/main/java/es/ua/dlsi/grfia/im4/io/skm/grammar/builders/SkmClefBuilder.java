package es.ua.dlsi.grfia.im4.io.skm.grammar.builders;

import es.ua.dlsi.grfia.im4.core.ClefSignTypes;
import es.ua.dlsi.grfia.im4.core.IClef;
import es.ua.dlsi.grfia.im4.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.io.builders.impl.SymbolBuilder;

public class SkmClefBuilder extends SymbolBuilder<IClef> {
    public static final String PROP_LINE = "line";
    public static final String PROP_NOTE = "sign";

    public SkmClefBuilder(ICoreAbstractFactory coreSymbolFactory) {
        super(coreSymbolFactory);
    }

    @Override
    public IClef build() throws IM4Exception {
        String lineStr = getRequiredProperty(PROP_LINE);
        String noteStr = getRequiredProperty(PROP_NOTE);

        ClefSignTypes clefSignType = ClefSignTypes.valueOf(noteStr.toUpperCase());
        if (clefSignType == null) {
            throw new IM4Exception("Cannot find a clef sign for '" + noteStr + "'");
        }

        int line = Integer.parseInt(lineStr);
        return coreSymbolFactory.createClef(line, clefSignType);
    }
}
