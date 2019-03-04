package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import es.ua.dlsi.grfia.im3ws.muret.entity.BoundingBox;

public class PageCreation {
    long imageID;
    BoundingBox boundingBox;

    public PageCreation() {
    }

    public PageCreation(long imageID, BoundingBox boundingBox) {
        this.imageID = imageID;
        this.boundingBox = boundingBox;
    }

    public long getImageID() {
        return imageID;
    }

    public void setImageID(long imageID) {
        this.imageID = imageID;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }
}
