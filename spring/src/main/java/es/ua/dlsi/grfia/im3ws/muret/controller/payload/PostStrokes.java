package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.io.Serializable;

public class PostStrokes implements Serializable {
    long regionID;

    Point [][] points; // each array is an stroke

    public PostStrokes(long regionID, Point[][] points) {
        this.regionID = regionID;
        this.points = points;
    }

    public long getRegionID() {
        return regionID;
    }

    public void setRegionID(long regionID) {
        this.regionID = regionID;
    }

    public Point[][] getPoints() {
        return points;
    }

    public void setPoints(Point[][] points) {
        this.points = points;
    }
}
