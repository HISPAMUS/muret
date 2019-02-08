package es.ua.dlsi.grfia.im3ws.muret.entity;

import java.util.List;

public class SVGSet {
    double x;
    double y;
    double em;

    /**
     * key = AgnosticTypeString
     * value = SVG d param of SVG path element
     */
    List<AgnosticTypeSVGPath> paths;

    public SVGSet(double x, double y, double em, List<AgnosticTypeSVGPath> paths) {
        this.x = x;
        this.y = y;
        this.em = em;
        this.paths = paths;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getEm() {
        return em;
    }

    public List<AgnosticTypeSVGPath> getPaths() {
        return paths;
    }
}
