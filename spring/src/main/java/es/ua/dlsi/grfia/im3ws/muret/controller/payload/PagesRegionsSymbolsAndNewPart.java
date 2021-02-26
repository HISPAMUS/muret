package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import es.ua.dlsi.grfia.im3ws.muret.entity.Page;
import es.ua.dlsi.grfia.im3ws.muret.entity.Part;

import java.util.Set;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 26/2/21
 */
public class PagesRegionsSymbolsAndNewPart {
    Set<Page> pagesRegionsSymbols;
    Part part;

    public Set<Page> getPagesRegionsSymbols() {
        return pagesRegionsSymbols;
    }

    public void setPagesRegionsSymbols(Set<Page> pagesRegionsSymbols) {
        this.pagesRegionsSymbols = pagesRegionsSymbols;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
}
