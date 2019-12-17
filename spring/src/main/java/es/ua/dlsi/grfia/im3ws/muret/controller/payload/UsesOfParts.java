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
        List<IPartUse> pages;
        /**
         * Image, region
         */
        List<IPartUse> regions;
        /**
         * Image, symbol
         */
        List<IPartUse> symbols;

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

        public List<IPartUse> getPages() {
            return pages;
        }

        public void setPages(List<IPartUse> pages) {
            this.pages = pages;
        }

        public List<IPartUse> getRegions() {
            return regions;
        }

        public void setRegions(List<IPartUse> regions) {
            this.regions = regions;
        }

        public List<IPartUse> getSymbols() {
            return symbols;
        }

        public void setSymbols(List<IPartUse> symbols) {
            this.symbols = symbols;
        }
    }

    public List<PartUses> getUses() {
        return uses;
    }

    public void add(Part part, List<BigInteger> images, List<IPartUse> pages,
                    List<IPartUse> regions, List<IPartUse> symbols) {

        PartUses pu = new PartUses();
        pu.setPart(part);
        pu.setImages(images);
        pu.setPages(pages);
        pu.setRegions(regions);
        pu.setSymbols(symbols);

        this.uses.add(pu);
    }
}
