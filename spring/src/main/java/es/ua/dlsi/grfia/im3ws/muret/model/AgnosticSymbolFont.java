package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.muret.entity.AgnosticTypeSVGPath;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.layout.LayoutFont;
import es.ua.dlsi.im3.core.score.layout.svg.Glyph;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolType;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It returns the font symbol associated to an agnostic symbol depending on the notation type
 * @autor drizo
 */
public class AgnosticSymbolFont {
    private LayoutFont layoutFont;

    public AgnosticSymbolFont(LayoutFont layoutFont) {
        this.layoutFont = layoutFont;
    }

    public LayoutFont getLayoutFont() {
        return layoutFont;
    }

    /**
     * @return Map<AgnosticTypeString, SVG d param of SVG path element>
     */
    public List<AgnosticTypeSVGPath> getFullSVGSetPathd() throws IM3Exception {
        HashMap<String, String> codePointGrlyphMap = this.layoutFont.getCodepointGlyphMap();

        List<AgnosticTypeSVGPath> result = new LinkedList<>();
        for (Map.Entry<String, String> entry: codePointGrlyphMap.entrySet()) {
            String agnosticSymbolType = entry.getValue();
            System.out.println(agnosticSymbolType + " " + entry.getKey());
            try {
                Glyph glyph = layoutFont.getGlyph(agnosticSymbolType);
                if (glyph == null) {
                    throw new IM3Exception("Cannot find a glyph for key '" + entry.getKey() + "'");
                }
                if (glyph.getDefaultHorizontalAdvance() == null) {
                    glyph.setDefaultHorizontalAdvance(0);
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "TO-DO Glyph for key '" + entry.getKey() + "' has not the horizontal advance value");
                    //throw new IM3Exception("Glyph for key '" + entry.getKey() + "' has not the horizontal advance value");
                }
                result.add(new AgnosticTypeSVGPath(agnosticSymbolType, glyph.getPath(), glyph.getDefaultHorizontalAdvance()));
            } catch (Throwable t) {
                // TODO
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "TO-DO: ", t);
            }
        }
        return result;
    }

}
