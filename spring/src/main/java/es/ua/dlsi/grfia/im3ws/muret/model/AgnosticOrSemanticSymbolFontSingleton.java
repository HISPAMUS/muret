package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.entity.ManuscriptType;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.layout.fonts.MensuralHandwrittenFont;
import es.ua.dlsi.im3.core.score.layout.fonts.MensuralPrintedFont;
import es.ua.dlsi.im3.core.score.layout.fonts.ModernHandwrittenFont;
import es.ua.dlsi.im3.core.score.layout.fonts.ModernPrintedFont;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton for avoiding the creation of the same fonts for all requests
 */
public class AgnosticOrSemanticSymbolFontSingleton {
    /**
     * Array indexed, first by notation type, then by manuscript type
     */
    AgnosticOrSemanticSymbolFont[][] layoutFonts;
    private static AgnosticOrSemanticSymbolFontSingleton ourInstance = new AgnosticOrSemanticSymbolFontSingleton();

    public static AgnosticOrSemanticSymbolFontSingleton getInstance() {
        return ourInstance;
    }

    private AgnosticOrSemanticSymbolFontSingleton() {
        layoutFonts = new AgnosticOrSemanticSymbolFont[NotationType.values().length][ManuscriptType.values().length];
        try {
            layoutFonts[NotationType.eMensural.ordinal()][ManuscriptType.eHandwritten.ordinal()] = new AgnosticOrSemanticSymbolFont(new MensuralHandwrittenFont());
            layoutFonts[NotationType.eMensural.ordinal()][ManuscriptType.ePrinted.ordinal()] = new AgnosticOrSemanticSymbolFont(new MensuralPrintedFont());
            layoutFonts[NotationType.eModern.ordinal()][ManuscriptType.ePrinted.ordinal()] = new AgnosticOrSemanticSymbolFont(new ModernPrintedFont());
            layoutFonts[NotationType.eModern.ordinal()][ManuscriptType.eHandwritten.ordinal()] = new AgnosticOrSemanticSymbolFont(new ModernHandwrittenFont());
        } catch (IM3Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Cannot load font", e);
            throw new RuntimeException(e);
        }
    }

    public AgnosticOrSemanticSymbolFont getLayoutFont(NotationType notationType, ManuscriptType manuscriptType) throws IM3WSException {
        AgnosticOrSemanticSymbolFont result = layoutFonts[notationType.ordinal()][manuscriptType.ordinal()];
        if (result == null) {
            throw new IM3WSException("Agnostic font not found for notationType " + notationType + " and manuscript type " + manuscriptType);
        }
        return result;
    }

}
