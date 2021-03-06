package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.muret.entity.*;
// !!! Important: no controller should launch any exception

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

    public Part findPart(Symbol symbol) {
        if (symbol.getPart() == null) {
            return findPart(symbol.getRegion());
        } else {
            return symbol.getPart();
        }
    }

}
