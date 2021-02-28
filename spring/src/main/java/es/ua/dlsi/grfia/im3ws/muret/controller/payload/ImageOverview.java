package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import es.ua.dlsi.grfia.im3ws.muret.entity.ImageRecognitionProgressStatus;
import es.ua.dlsi.grfia.im3ws.muret.entity.Part;

import java.util.List;
import java.util.Set;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/2/21
 */
public class ImageOverview {
    Long imageID;
    Integer documentID;
    String documentPath;
    String comments;
    List<Part> documentParts; // ordered
    Part imagePart;
    boolean hidden;
    Set<ImageRecognitionProgressStatus> imageRecognitionProgressStatusSet;

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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<Part> getDocumentParts() {
        return documentParts;
    }

    public void setDocumentParts(List<Part> documentParts) {
        this.documentParts = documentParts;
    }

    public Part getImagePart() {
        return imagePart;
    }

    public void setImagePart(Part imagePart) {
        this.imagePart = imagePart;
    }

    public Set<ImageRecognitionProgressStatus> getImageRecognitionProgressStatusSet() {
        return imageRecognitionProgressStatusSet;
    }

    public void setImageRecognitionProgressStatusSet(Set<ImageRecognitionProgressStatus> imageRecognitionProgressStatusSet) {
        this.imageRecognitionProgressStatusSet = imageRecognitionProgressStatusSet;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
