package es.ua.dlsi.grfia.im3ws.muret.controller.payload.alignmentPreview;

public class AlignmentPreviewProblem {
    Long imageID;
    Long regionID;
    String problem;

    public AlignmentPreviewProblem() {
    }

    public Long getImageID() {
        return imageID;
    }

    public void setImageID(Long imageID) {
        this.imageID = imageID;
    }

    public Long getRegionID() {
        return regionID;
    }

    public void setRegionID(Long regionID) {
        this.regionID = regionID;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}
