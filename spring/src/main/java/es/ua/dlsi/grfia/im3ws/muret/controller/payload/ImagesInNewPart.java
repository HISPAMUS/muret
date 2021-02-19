package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import es.ua.dlsi.grfia.im3ws.muret.entity.Part;

import java.util.HashSet;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 19/2/21
 */
public class ImagesInNewPart {
    HashSet<PartsInImage> partsInImage;
    Part part;

    public HashSet<PartsInImage> getPartsInImage() {
        return partsInImage;
    }

    public void setPartsInImage(HashSet<PartsInImage> partsInImage) {
        this.partsInImage = partsInImage;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
}
