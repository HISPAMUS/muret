package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import es.ua.dlsi.grfia.im3ws.muret.entity.Part;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class UsesOfParts {
    /**
     * key = part id
     */
    List<PartUses> uses;

    public UsesOfParts() {
        uses = new ArrayList<>();
    }

    class PartUses {
        Part part;
        List<BigInteger> images;
        /**
         * Image, page
         */
        List<PartUse> pages;
        /**
         * Image, region
         */
        List<PartUse> regions;
        /**
         * Image, symbol
         */
        List<PartUse> symbols;

        public PartUses() {
        }

        public List<BigInteger> getImages() {
            return images;
        }

        public void setImages(List<BigInteger> images) {
            this.images = images;
        }

        public Part getPart() {
            return part;
        }

        public void setPart(Part part) {
            this.part = part;
        }

        public List<PartUse> getPages() {
            return pages;
        }

        public void setPages(List<PartUse> pages) {
            this.pages = pages;
        }

        public List<PartUse> getRegions() {
            return regions;
        }

        public void setRegions(List<PartUse> regions) {
            this.regions = regions;
        }

        public List<PartUse> getSymbols() {
            return symbols;
        }

        public void setSymbols(List<PartUse> symbols) {
            this.symbols = symbols;
        }
    }

    public List<PartUses> getUses() {
        return uses;
    }

    public void add(Part part, List<BigInteger> images, List<PartUse> pages,
                    List<PartUse> regions, List<PartUse> symbols) {

        PartUses pu = new PartUses();
        pu.setPart(part);
        pu.setImages(images);
        pu.setPages(pages);
        pu.setRegions(regions);
        pu.setSymbols(symbols);

        this.uses.add(pu);
    }
}
