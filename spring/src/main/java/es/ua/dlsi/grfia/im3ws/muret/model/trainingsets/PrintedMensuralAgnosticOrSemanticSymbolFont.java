package es.ua.dlsi.grfia.im3ws.muret.model.trainingsets;

import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticOrSemanticSymbolFont;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.layout.fonts.ModernPrintedFont;

/**
 * @autor drizo
 */
public class PrintedMensuralAgnosticOrSemanticSymbolFont extends AgnosticOrSemanticSymbolFont {
    public PrintedMensuralAgnosticOrSemanticSymbolFont() throws IM3Exception {
        super(new ModernPrintedFont());
    }
}
