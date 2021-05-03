package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 3/5/21
 */
public class RotatedImage {
    long imageID;
    float rotation;

    public RotatedImage(long imageID, float rotation) {
        this.imageID = imageID;
        this.rotation = rotation;
    }

    public long getImageID() {
        return imageID;
    }

    public void setImageID(long imageID) {
        this.imageID = imageID;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
