package es.ua.dlsi.grfia.im3ws.muret.entity;

public class AgnosticTypeSVGPath {
    String agnosticTypeString;
    String svgPathD;

    public AgnosticTypeSVGPath(String agnosticTypeString, String svgPathD) {
        this.agnosticTypeString = agnosticTypeString;
        this.svgPathD = svgPathD;
    }

    public String getAgnosticTypeString() {
        return agnosticTypeString;
    }

    public String getSvgPathD() {
        return svgPathD;
    }
}
