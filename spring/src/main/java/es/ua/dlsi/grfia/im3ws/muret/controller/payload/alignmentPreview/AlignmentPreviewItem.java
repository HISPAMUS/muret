package es.ua.dlsi.grfia.im3ws.muret.controller.payload.alignmentPreview;

public class AlignmentPreviewItem {
    /**
     * Time relative to the region
     */
    double time;
    AlignmentPreviewItemType type;
    String description;

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public AlignmentPreviewItemType getType() {
        return type;
    }

    public void setType(AlignmentPreviewItemType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
