package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.muret.entity.AgnosticOrSemanticSymbolTypeSVGPath;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.layout.LayoutFont;
import es.ua.dlsi.im3.core.score.layout.svg.Glyph;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It returns the font symbol associated to an agnostic or semantic symbol depending on the notation type
 * @autor drizo
 */
public class AgnosticOrSemanticSymbolFont {
    private LayoutFont layoutFont;

    public AgnosticOrSemanticSymbolFont(LayoutFont layoutFont) {
        this.layoutFont = layoutFont;
    }

    public LayoutFont getLayoutFont() {
        return layoutFont;
    }

    /**
     * @return Map<AgnosticTypeString, SVG d param of SVG path element>
     */
    public List<AgnosticOrSemanticSymbolTypeSVGPath> getFullSVGSetPathd() throws IM3Exception {
        HashMap<String, String> codePointGrlyphMap = this.layoutFont.getCodepointGlyphMap();

        int em = this.layoutFont.getSVGFont().getUnitsPerEM();
        int descent = this.layoutFont.getSVGFont().getDescent();
        List<AgnosticOrSemanticSymbolTypeSVGPath> result = new LinkedList<>();
        for (Map.Entry<String, String> entry: codePointGrlyphMap.entrySet()) {
            String agnosticSymbolType = entry.getValue();
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

                StringBuilder viewBox = new StringBuilder("0 ");
                viewBox.append(-(em - descent));
                viewBox.append(' ');
                viewBox.append(em + glyph.getDefaultHorizontalAdvance());
                viewBox.append(' ');
                viewBox.append(em);

                //return `0 ${-(svgSet.em - svgSet.descent)} ${svgSet.em + svgSymbol.horizAdvX} ${svgSet.em}`;
                //[attr.transform]="'scale(1, -1) translate(0, ' + computeSVGSymbolTranslateY(svgAgnosticSymbolSet)+ ')' "
                String symbolTransform = "scale(1, -1) translate(0, " + (em - descent) + ")";
                result.add(new AgnosticOrSemanticSymbolTypeSVGPath(agnosticSymbolType, glyph.getPath(), glyph.getDefaultHorizontalAdvance(),
                        viewBox.toString(), symbolTransform, layoutFont.getDefaultPositionInStaff(agnosticSymbolType)));
            } catch (Throwable t) {
                // TODO
                // TODO Si algún glifo no está es porque la tipografía no lo tiene, y puede que esté bien que esté ausente (p.ej. # en mensural printed)
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "TO-DO: ", t);
            }
        }

        return result;
    }

}
