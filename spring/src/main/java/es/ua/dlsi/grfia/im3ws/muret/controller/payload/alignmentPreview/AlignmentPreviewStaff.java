package es.ua.dlsi.grfia.im3ws.muret.controller.payload.alignmentPreview;

import es.ua.dlsi.grfia.im3ws.muret.entity.BoundingBox;

import java.util.ArrayList;
import java.util.List;

public class AlignmentPreviewStaff {
    /**
     * region ID
     */
    long id;
    /**
     * Image where it is located
     */
    long imageID;
    /**
     * the number of page (1 for left, 2 for right ...)
     */
    int pageNumber;
    /**
     * the order number among the staves from top to bottom in the page
     */
    int order;
    /**
     * The bounding box of the region inside the image
     */
    BoundingBox boundingBox;

    List<AlignmentPreviewItem> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getImageID() {
        return imageID;
    }

    public void setImageID(long imageID) {
        this.imageID = imageID;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<AlignmentPreviewItem> getItems() {
        return items;
    }

    public void setItems(List<AlignmentPreviewItem> items) {
        this.items = items;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public void add(AlignmentPreviewItem item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }
}
