package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

public class PagesCreation {
    long imageID;
    int numPages;

    public PagesCreation() {
    }

    public PagesCreation(long imageID, int numPages) {
        this.imageID = imageID;
        this.numPages = numPages;
    }

    public long getImageID() {
        return imageID;
    }

    public void setImageID(long imageID) {
        this.imageID = imageID;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
}
