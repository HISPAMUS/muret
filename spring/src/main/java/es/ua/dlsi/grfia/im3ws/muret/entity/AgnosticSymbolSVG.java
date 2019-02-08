package es.ua.dlsi.grfia.im3ws.muret.entity;

public class AgnosticSymbolSVG {
    String agnosticSymolType;
    String svg;

    public AgnosticSymbolSVG(String agnosticSymolType, String svg) {
        this.agnosticSymolType = agnosticSymolType;
        this.svg = svg;
    }

    public String getAgnosticSymolType() {
        return agnosticSymolType;
    }

    public String getSvg() {
        return svg;
    }
}
