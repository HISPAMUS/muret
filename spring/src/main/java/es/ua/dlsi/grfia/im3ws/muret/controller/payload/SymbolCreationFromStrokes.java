package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import es.ua.dlsi.im3.core.score.PositionInStaff;

public class SymbolCreationFromStrokes {
    long regionID;
    String agnosticSymbolType;
    String positionInStaff;
    Point[][] points;

    public SymbolCreationFromStrokes() {
    }

    public SymbolCreationFromStrokes(long regionID, String agnosticSymbolType, String positionInStaff, Point[][] points) {
        this.regionID = regionID;
        this.agnosticSymbolType = agnosticSymbolType;
        this.positionInStaff = positionInStaff;
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

    public String getPositionInStaff() {
        return positionInStaff;
    }

    public void setPositionInStaff(String positionInStaff) {
        this.positionInStaff = positionInStaff;
    }

    public Point[][] getPoints() {
        return points;
    }

    public void setPoints(Point[][] points) {
        this.points = points;
    }
}
