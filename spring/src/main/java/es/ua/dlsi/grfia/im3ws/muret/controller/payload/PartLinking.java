package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 26/2/21
 */
public class PartLinking {
    /**
     * Used when a new part is created, to return all the image overview data
     */
    Long imageID;
    /**
     * when linking to existing part or returning a new one
     */
    Long partID;
    /**
     * Used when creating new part
     */
    Integer documentID;
    /**
     * When creating a new part
     */
    String partName;

    PartLinkedTo partAssignedTo;

    LongArray toIDs;

    public PartLinking() {
    }

    public Long getImageID() {
        return imageID;
    }

    public void setImageID(Long imageID) {
        this.imageID = imageID;
    }

    public Long getPartID() {
        return partID;
    }

    public void setPartID(Long partID) {
        this.partID = partID;
    }

    public Integer getDocumentID() {
        return documentID;
    }

    public void setDocumentID(Integer documentID) {
        this.documentID = documentID;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public PartLinkedTo getPartAssignedTo() {
        return partAssignedTo;
    }

    public void setPartAssignedTo(PartLinkedTo partAssignedTo) {
        this.partAssignedTo = partAssignedTo;
    }

    public LongArray getToIDs() {
        return toIDs;
    }

    public void setToIDs(LongArray toIDs) {
        this.toIDs = toIDs;
    }

    @Override
    public String toString() {
        return "PartLinking{" +
                "partID=" + partID +
                ", partName='" + partName + '\'' +
                ", partAssignedTo=" + partAssignedTo +
                ", toIDs=" + toIDs +
                '}';
    }
}
