package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 13/2/21
 */
public class SectionImages {
    private Long newSectionID;
    private Long [] imageIDS;
    private Long [] previousSectionIDs;

    public SectionImages(Long newSectionID, Long[] imageIDS, Long [] previousSectionIDs) {
        this.previousSectionIDs = previousSectionIDs;
        this.newSectionID = newSectionID;
        this.imageIDS = imageIDS;
    }

    public SectionImages(Long newSectionID, Long[] imageIDS) {
        this.newSectionID = newSectionID;
        this.imageIDS = imageIDS;
    }

    public SectionImages() {
    }

    public Long[] getPreviousSectionIDs() {
        return previousSectionIDs;
    }

    public void setPreviousSectionIDs(Long[] previousSectionIDs) {
        this.previousSectionIDs = previousSectionIDs;
    }

    public Long getNewSectionID() {
        return newSectionID;
    }

    public void setNewSectionID(Long newSectionID) {
        this.newSectionID = newSectionID;
    }

    public Long[] getImageIDS() {
        return imageIDS;
    }

    public void setImageIDS(Long[] imageIDS) {
        this.imageIDS = imageIDS;
    }
}
