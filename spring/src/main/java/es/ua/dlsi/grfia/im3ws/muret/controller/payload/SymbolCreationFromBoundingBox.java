package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import es.ua.dlsi.grfia.im3ws.muret.entity.BoundingBox;
import es.ua.dlsi.im3.core.score.PositionInStaff;

public class SymbolCreationFromBoundingBox {
    long regionID;
    String agnosticSymbolType;
    String positionInStaff;
    BoundingBox boundingBox;

    public SymbolCreationFromBoundingBox() {
    }

    public SymbolCreationFromBoundingBox(long regionID, String agnosticSymbolType, String positionInStaff, BoundingBox boundingBox) {
        this.regionID = regionID;
        this.agnosticSymbolType = agnosticSymbolType;
        this.positionInStaff = positionInStaff;
        this.boundingBox = boundingBox;
    }

    public long getRegionID() {
        return regionID;
    }

    public String getAgnosticSymbolType() {
        return agnosticSymbolType;
    }

    public String getPositionInStaff() {
        return positionInStaff;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }
}
