package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.muret.entity.Image;

import java.util.HashMap;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/08/2020
 */
public class IIIFModel {
    String manifestFile;
    HashMap<Image, String> imageCanvases;

    public IIIFModel() {
        this.imageCanvases = new HashMap<>();
    }

    public String getManifestFile() {
        return manifestFile;
    }

    public void setManifestFile(String manifestFile) {
        this.manifestFile = manifestFile;
    }

    public void addCanvas(Image image, String id) {
        this.imageCanvases.put(image, id);
    }

    public String getCanvas(Image image) {
        return this.imageCanvases.get(image);
    }
}
