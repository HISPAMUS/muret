package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import es.ua.dlsi.grfia.im3ws.muret.entity.BoundingBox;

public class RegionCreation {
    long imageID;
    Integer regionTypeID;
    BoundingBox boundingBox;

    public RegionCreation() {
    }

    public RegionCreation(long imageID, int regionTypeID, BoundingBox boundingBox) {
        this.imageID = imageID;
        this.regionTypeID = regionTypeID;
        this.boundingBox = boundingBox;
    }

    public long getImageID() {
        return imageID;
    }

    public void setImageID(long imageID) {
        this.imageID = imageID;
    }

    public Integer getRegionTypeID() {
        return regionTypeID;
    }

    public void setRegionTypeID(Integer regionTypeID) {
        this.regionTypeID = regionTypeID;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }
}
