package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.entity.Page;

import java.util.HashSet;
import java.util.Set;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 26/2/21
 */
public class ImageRecognitionModel {
    /**
     * Note pages in images and regions in pages, and parts in these are EAGER
     * @param image
     * @return
     */
    public Set<Page> getPagesRegionsSymbols(Image image) {
        HashSet<Page> result = new HashSet<>();
        for (Page page: image.getPages()) {
            // nothing - just retrieve them - it
            result.add(page);
        }
        return result;
    }
}
