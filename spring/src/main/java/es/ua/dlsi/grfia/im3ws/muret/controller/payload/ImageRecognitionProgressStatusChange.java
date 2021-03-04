package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import es.ua.dlsi.grfia.im3ws.muret.entity.ImageRecognitionPhase;
import es.ua.dlsi.grfia.im3ws.muret.entity.ProgressStatus;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 4/3/21
 */
public class ImageRecognitionProgressStatusChange {
    long imageID;
    ImageRecognitionPhase phase;
    ProgressStatus status;

    public long getImageID() {
        return imageID;
    }

    public void setImageID(long imageID) {
        this.imageID = imageID;
    }

    public ImageRecognitionPhase getPhase() {
        return phase;
    }

    public void setPhase(ImageRecognitionPhase phase) {
        this.phase = phase;
    }

    public ProgressStatus getStatus() {
        return status;
    }

    public void setStatus(ProgressStatus status) {
        this.status = status;
    }
}
