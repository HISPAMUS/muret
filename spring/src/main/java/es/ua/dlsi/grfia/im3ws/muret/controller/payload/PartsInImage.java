package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import java.util.HashSet;
import java.util.Set;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/2/21
 */
public class PartsInImage {
    private Long imageID;
    private Set<Long> idsOfParts;

    public PartsInImage(Long imageID, Set<Long> idsOfParts) {
        this.imageID = imageID;
        this.idsOfParts = idsOfParts;
    }

    public PartsInImage(Long imageID) {
        this.imageID = imageID;
        this.idsOfParts = new HashSet<>();
    }

    public void addPart(Long partID) {
        this.idsOfParts.add(partID);
    }

    public Long getImageID() {
        return imageID;
    }

    public void setImageID(Long imageID) {
        this.imageID = imageID;
    }

    public Set<Long> getIdsOfParts() {
        return idsOfParts;
    }

    public void setIdsOfParts(Set<Long> idsOfParts) {
        this.idsOfParts = idsOfParts;
    }
}
