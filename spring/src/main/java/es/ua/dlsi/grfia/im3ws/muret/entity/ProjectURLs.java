package es.ua.dlsi.grfia.im3ws.muret.entity;

/**
 * Used to transmit with JSON the project image URLS
 */
public class ProjectURLs {
    String masters;
    String thumbnails;
    String previews;

    public ProjectURLs() {
    }

    public ProjectURLs(String masters, String thumbnails, String previews) {
        this.masters = masters;
        this.thumbnails = thumbnails;
        this.previews = previews;
    }

    public String getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(String thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getPreviews() {
        return previews;
    }

    public void setPreviews(String previews) {
        this.previews = previews;
    }

    public String getMasters() {
        return masters;
    }

    public void setMasters(String masters) {
        this.masters = masters;
    }
}
