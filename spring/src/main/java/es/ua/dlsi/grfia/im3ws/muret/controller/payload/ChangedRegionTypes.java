package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 7/3/21
 */
public class ChangedRegionTypes {
    LongArray regionIDs;
    int regionTypeID;

    public LongArray getRegionIDs() {
        return regionIDs;
    }

    public void setRegionIDs(LongArray regionIDs) {
        this.regionIDs = regionIDs;
    }

    public int getRegionTypeID() {
        return regionTypeID;
    }

    public void setRegionTypeID(int regionTypeID) {
        this.regionTypeID = regionTypeID;
    }
}
