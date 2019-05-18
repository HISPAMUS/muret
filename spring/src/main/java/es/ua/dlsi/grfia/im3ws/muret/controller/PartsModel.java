package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.muret.entity.*;

public class PartsModel {
    public Part findPart(Image image) {
        return image.getPart();
    }

    public Part findPart(Page page) {
        if (page.getPart() == null) {
            return findPart(page.getImage());
        } else {
            return page.getPart();
        }
    }

    public Part findPart(Region region) {
        if (region.getPart() == null) {
            return findPart(region.getPage());
        } else {
            return region.getPart();
        }
    }

    /*public Part findPart(Symbol symbol) {
        if (symbol.getPart() == null) {
            return findPart(symbol.getPage());
        } else {
            return symbol.getPart();
        }
    }*/

}
