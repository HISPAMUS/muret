package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import es.ua.dlsi.grfia.im3ws.muret.entity.BoundingBox;

public class SymbolCreation {
    long regionID;
    String agnosticSymbolType;
    BoundingBox boundingBox;

    public SymbolCreation() {
    }

    public SymbolCreation(long regionID, String agnosticSymbolType, BoundingBox boundingBox) {
        this.regionID = regionID;
        this.agnosticSymbolType = agnosticSymbolType;
        this.boundingBox = boundingBox;
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

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }
}
