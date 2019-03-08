package es.ua.dlsi.grfia.im3ws.muret.entity;

public class AgnosticTypeSVGPath {
    String agnosticTypeString;
    String svgPathD;
    int horizAdvX;

    public AgnosticTypeSVGPath(String agnosticTypeString, String svgPathD, int horizAdvX) {
        this.agnosticTypeString = agnosticTypeString;
        this.svgPathD = svgPathD;
        this.horizAdvX = horizAdvX;
    }

    public String getAgnosticTypeString() {
        return agnosticTypeString;
    }

    public String getSvgPathD() {
        return svgPathD;
    }

    public int getHorizAdvX() {
        return horizAdvX;
    }
}
