package es.ua.dlsi.grfia.im3ws.muret.model.trainingsets;

import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticSymbolFont;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.layout.fonts.AgnosticModernPrintedFont;

/**
 * @autor drizo
 */
public class PrintedMensuralAgnosticSymbolFont extends AgnosticSymbolFont {
    public PrintedMensuralAgnosticSymbolFont() throws IM3Exception {
        super(new AgnosticModernPrintedFont());
    }
}
