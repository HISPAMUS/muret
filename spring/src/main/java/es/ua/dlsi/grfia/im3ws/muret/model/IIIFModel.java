package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.muret.entity.Image;

import java.util.HashMap;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/08/2020
 */
public class IIIFModel {
    public static final String MASTERS = ":masters:";
    public static final String FULL_FILL_0_DEFAULT_JPG = "/full/full/0/default.jpg";
    String manifestFile;
    HashMap<Image, String> imageCanvases;

    public IIIFModel() {
        this.imageCanvases = new HashMap<>();
    }

    public static String getMasterImageURL(String baseIIIFImagesURI, String documentPath, String filename) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(baseIIIFImagesURI);
        stringBuilder.append('/');
        stringBuilder.append(documentPath);
        stringBuilder.append(MASTERS);
        stringBuilder.append(filename);
        stringBuilder.append(FULL_FILL_0_DEFAULT_JPG);
        return stringBuilder.toString();
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
