package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

public class PreflightCkeckResult {
    long regionID;
    String result;

    public PreflightCkeckResult(long regionID, String result) {
        this.regionID = regionID;
        this.result = result;
    }

    public PreflightCkeckResult() {
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
