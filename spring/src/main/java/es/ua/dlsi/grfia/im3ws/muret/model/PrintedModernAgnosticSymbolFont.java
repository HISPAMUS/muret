package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.layout.fonts.BravuraFont;

/**
 * @autor drizo
 */
public class PrintedModernAgnosticSymbolFont extends AgnosticSymbolFont {
    public PrintedModernAgnosticSymbolFont() throws IM3Exception {
        super(new BravuraFont());
    }
}
