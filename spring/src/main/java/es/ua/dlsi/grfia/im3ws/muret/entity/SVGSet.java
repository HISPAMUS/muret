package es.ua.dlsi.grfia.im3ws.muret.entity;

import java.util.List;

public class SVGSet {
    double ascent;
    double descent;
    double em;

    /**
     * key = AgnosticTypeString
     * value = SVG d param of SVG path element
     */
    List<AgnosticTypeSVGPath> paths;

    public SVGSet(double ascent, double descent, double em, List<AgnosticTypeSVGPath> paths) {
        this.em = em;
        this.paths = paths;
        this.ascent = ascent;
        this.descent = descent;
    }

    public double getEm() {
        return em;
    }

    public double getAscent() {
        return ascent;
    }

    public double getDescent() {
        return descent;
    }

    public List<AgnosticTypeSVGPath> getPaths() {
        return paths;
    }
}
