package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import es.ua.dlsi.grfia.im3ws.muret.entity.ImageRecognitionProgressStatus;
import es.ua.dlsi.grfia.im3ws.muret.entity.ManuscriptType;
import es.ua.dlsi.grfia.im3ws.muret.entity.Part;
import es.ua.dlsi.im3.core.score.NotationType;

import java.util.List;
import java.util.Set;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/2/21
 */
public class ImageOverview {
    Long imageID;
    Long prevImageID;
    Long nextImageID;
    //int imageWidth;
    String filename;
    Float rotation;
    Integer documentID;
    String documentPath;
    String comments;
    List<Part> documentParts; // ordered
    Part imagePart;
    boolean hidden;
    NotationType notationType;
    ManuscriptType manuscriptType;
    Set<ImageRecognitionProgressStatus> imageRecognitionProgressStatuses;

    public ImageOverview() {
    }

    public Long getImageID() {
        return imageID;
    }

    public void setImageID(Long imageID) {
        this.imageID = imageID;
    }

    public Long getPrevImageID() {
        return prevImageID;
    }

    public void setPrevImageID(Long prevImageID) {
        this.prevImageID = prevImageID;
    }

    public Long getNextImageID() {
        return nextImageID;
    }

    public void setNextImageID(Long nextImageID) {
        this.nextImageID = nextImageID;
    }

/*public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }*/

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

    public Set<ImageRecognitionProgressStatus> getImageRecognitionProgressStatuses() {
        return imageRecognitionProgressStatuses;
    }

    public void setImageRecognitionProgressStatuses(Set<ImageRecognitionProgressStatus> imageRecognitionProgressStatuses) {
        this.imageRecognitionProgressStatuses = imageRecognitionProgressStatuses;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public NotationType getNotationType() {
        return notationType;
    }

    public void setNotationType(NotationType notationType) {
        this.notationType = notationType;
    }

    public ManuscriptType getManuscriptType() {
        return manuscriptType;
    }

    public void setManuscriptType(ManuscriptType manuscriptType) {
        this.manuscriptType = manuscriptType;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Float getRotation() {
        return rotation;
    }

    public void setRotation(Float rotation) {
        this.rotation = rotation;
    }
}
