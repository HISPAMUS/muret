package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

public class DocumentStatistics {
    int images;
    int pages;
    int regions;
    int staves;
    int agnosticSymbols;

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getRegions() {
        return regions;
    }

    public void setRegions(int regions) {
        this.regions = regions;
    }

    public int getStaves() {
        return staves;
    }

    public void setStaves(int staves) {
        this.staves = staves;
    }

    public int getAgnosticSymbols() {
        return agnosticSymbols;
    }

    public void setAgnosticSymbols(int agnosticSymbols) {
        this.agnosticSymbols = agnosticSymbols;
    }
}
