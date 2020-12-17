package es.ua.dlsi.grfia.im3ws.muret.entity;

public class AgnosticOrSemanticSymbolTypeSVGPath {
    String agnosticTypeString;
    String svgPathD;
    int horizAdvX;
    String viewBox;
    String symbolTransform;
    String defaultPositionInStaff;

    public AgnosticOrSemanticSymbolTypeSVGPath(String agnosticTypeString, String svgPathD, int horizAdvX, String viewBox, String symbolTransform, String defaultLineSpace) {
        this.agnosticTypeString = agnosticTypeString;
        this.svgPathD = svgPathD;
        this.horizAdvX = horizAdvX;
        this.viewBox = viewBox;
        this.symbolTransform = symbolTransform;
        this.defaultPositionInStaff = defaultLineSpace;
    }

    public String getAgnosticOrSemanticTypeString() {
        return agnosticTypeString;
    }

    public String getSvgPathD() {
        return svgPathD;
    }

    public int getHorizAdvX() {
        return horizAdvX;
    }

    public String getViewBox() {
        return viewBox;
    }

    public String getSymbolTransform() {
        return symbolTransform;
    }

    public String getDefaultPositionInStaff() {
        return defaultPositionInStaff;
    }
}
