package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

public class PreflightCkeckResult {
    int imageID;
    long regionID;
    String result;

    public PreflightCkeckResult(int imageID, long regionID, String result) {
        this.imageID = imageID;
        this.regionID = regionID;
        this.result = result;
    }

    public PreflightCkeckResult() {
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public long getRegionID() {
        return regionID;
    }

    public void setRegionID(long regionID) {
        this.regionID = regionID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
