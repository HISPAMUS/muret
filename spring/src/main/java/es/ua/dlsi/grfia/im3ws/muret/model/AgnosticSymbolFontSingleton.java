package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.entity.ManuscriptType;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.layout.LayoutFont;
import es.ua.dlsi.im3.core.score.layout.fonts.AgnosticMensuralHandwrittenFont;
import es.ua.dlsi.im3.core.score.layout.fonts.AgnosticMensuralPrintedFont;
import es.ua.dlsi.im3.core.score.layout.fonts.AgnosticModernHandwrittenFont;
import es.ua.dlsi.im3.core.score.layout.fonts.AgnosticModernPrintedFont;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton for avoiding the creation of the same fonts for all requests
 */
public class AgnosticSymbolFontSingleton {
    /**
     * Array indexed, first by notation type, then by manuscript type
     */
    AgnosticSymbolFont [][] layoutFonts;
    private static AgnosticSymbolFontSingleton ourInstance = new AgnosticSymbolFontSingleton();

    public static AgnosticSymbolFontSingleton getInstance() {
        return ourInstance;
    }

    private AgnosticSymbolFontSingleton() {
        layoutFonts = new AgnosticSymbolFont[NotationType.values().length][ManuscriptType.values().length];
        try {
            layoutFonts[NotationType.eMensural.ordinal()][ManuscriptType.eHandwritten.ordinal()] = new AgnosticSymbolFont(new AgnosticMensuralHandwrittenFont());
            layoutFonts[NotationType.eMensural.ordinal()][ManuscriptType.ePrinted.ordinal()] = new AgnosticSymbolFont(new AgnosticMensuralPrintedFont());
            layoutFonts[NotationType.eModern.ordinal()][ManuscriptType.ePrinted.ordinal()] = new AgnosticSymbolFont(new AgnosticModernPrintedFont());
            layoutFonts[NotationType.eModern.ordinal()][ManuscriptType.eHandwritten.ordinal()] = new AgnosticSymbolFont(new AgnosticModernHandwrittenFont());
        } catch (IM3Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Cannot load font", e);
            throw new RuntimeException(e);
        }
    }

    public AgnosticSymbolFont getLayoutFont(NotationType notationType, ManuscriptType manuscriptType) throws IM3WSException {
        AgnosticSymbolFont result = layoutFonts[notationType.ordinal()][manuscriptType.ordinal()];
        if (result == null) {
            throw new IM3WSException("Agnostic font not found for notationType " + notationType + " and manuscript type " + manuscriptType);
        }
        return result;
    }

}
