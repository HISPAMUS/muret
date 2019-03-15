package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

public class SymbolCreationFromStrokes {
    long regionID;
    String agnosticSymbolType;
    Point[][] points;

    public SymbolCreationFromStrokes() {
    }

    public SymbolCreationFromStrokes(long regionID, String agnosticSymbolType, Point[][] points) {
        this.regionID = regionID;
        this.agnosticSymbolType = agnosticSymbolType;
        this.points = points;
    }

    public long getRegionID() {
        return regionID;
    }

    public void setRegionID(long regionID) {
        this.regionID = regionID;
    }

    public String getAgnosticSymbolType() {
        return agnosticSymbolType;
    }

    public void setAgnosticSymbolType(String agnosticSymbolType) {
        this.agnosticSymbolType = agnosticSymbolType;
    }

    public Point[][] getPoints() {
        return points;
    }

    public void setPoints(Point[][] points) {
        this.points = points;
    }
}
