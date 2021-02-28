package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 28/2/21
 */
public class ImagesVisibility {
    LongArray imageIDS;
    boolean hidden;

    public LongArray getImageIDS() {
        return imageIDS;
    }

    public void setImageIDS(LongArray imageIDS) {
        this.imageIDS = imageIDS;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
