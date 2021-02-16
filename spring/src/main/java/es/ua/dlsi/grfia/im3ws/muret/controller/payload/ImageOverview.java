package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/2/21
 */
public class ImageOverview {
    Long imageID;
    Integer documentID;
    String documentPath;

    public ImageOverview() {
    }

    public Long getImageID() {
        return imageID;
    }

    public void setImageID(Long imageID) {
        this.imageID = imageID;
    }

    public Integer getDocumentID() {
        return documentID;
    }

    public void setDocumentID(Integer documentID) {
        this.documentID = documentID;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }
}
