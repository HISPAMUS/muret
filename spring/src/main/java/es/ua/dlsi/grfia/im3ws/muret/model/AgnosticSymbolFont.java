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
public abstract class AgnosticSymbolFont {
    /**
     * Key is agnostic string, avoid hashCode just in case. We want the order to be maintained as we add symbols
     */
    private LinkedHashMap<String, Glyph> glyphs;
    /**
     * Key is agnostic string (aligned to glyphs map)
     */
    private HashMap<String, AgnosticSymbolType> agnosticSymbolTypes;

    private LayoutFont layoutFont;

    public AgnosticSymbolFont(LayoutFont layoutFont) {
        this.layoutFont = layoutFont;
        glyphs = new LinkedHashMap<>();
        agnosticSymbolTypes = new HashMap<>();
    }

    protected void add(AgnosticSymbolType agnosticSymbolType, String codepoint) throws IM3Exception {
        Glyph glyph = layoutFont.getGlyph(codepoint);
        glyphs.put(agnosticSymbolType.toAgnosticString(), glyph);
        agnosticSymbolTypes.put(agnosticSymbolType.toAgnosticString(), agnosticSymbolType);
    }

    /**
     * @param agnosticTypeString
     * @return SVG d param of SVG path element
     */
    public String getSVGPathd(String agnosticTypeString) throws IM3Exception {
        Glyph glyph = glyphs.get(agnosticTypeString);
        if (glyph == null) {
            throw new IM3Exception("Cannot find glyph for agnostic symbol type " + agnosticTypeString + " in class " + this.getClass().getName());
        }
        return glyph.getPath();
    }

    public LayoutFont getLayoutFont() {
        return layoutFont;
    }

    /**
     * @return Map<AgnosticTypeString, SVG d param of SVG path element>
     */
    public List<AgnosticTypeSVGPath> getFullSVGSetPathd() throws IM3Exception {
        List<AgnosticTypeSVGPath> result = new LinkedList<>();
        for (Map.Entry<String, Glyph> entry: glyphs.entrySet()) {
            String agnosticSymbolType = entry.getKey();
            Glyph glyph = entry.getValue();
            if (glyph == null) {
                throw new IM3Exception("Cannot find a glyph for key '" + entry.getKey() + "'");
            }
            if (glyph.getDefaultHorizontalAdvance() == null) {
                glyph.setDefaultHorizontalAdvance(0);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "TO-DO Glyph for key '" + entry.getKey() + "' has not the horizontal advance value");
                //throw new IM3Exception("Glyph for key '" + entry.getKey() + "' has not the horizontal advance value");
            }
            result.add(new AgnosticTypeSVGPath(agnosticSymbolType, glyph.getPath(), glyph.getDefaultHorizontalAdvance()));
        }
        return result;
    }

}
