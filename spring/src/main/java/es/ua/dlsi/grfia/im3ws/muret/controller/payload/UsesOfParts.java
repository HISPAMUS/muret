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
        List<BigInteger> pages;
        List<BigInteger> regions;
        List<BigInteger> symbols;

        public PartUses() {
        }

        public List<BigInteger> getImages() {
            return images;
        }

        public void setImages(List<BigInteger> images) {
            this.images = images;
        }

        public List<BigInteger> getPages() {
            return pages;
        }

        public void setPages(List<BigInteger> pages) {
            this.pages = pages;
        }

        public List<BigInteger> getRegions() {
            return regions;
        }

        public void setRegions(List<BigInteger> regions) {
            this.regions = regions;
        }

        public List<BigInteger> getSymbols() {
            return symbols;
        }

        public void setSymbols(List<BigInteger> symbols) {
            this.symbols = symbols;
        }

        public Part getPart() {
            return part;
        }

        public void setPart(Part part) {
            this.part = part;
        }
    }

    public List<PartUses> getUses() {
        return uses;
    }

    public void add(Part part, List<BigInteger> images, List<BigInteger> pages, List<BigInteger> regions, List<BigInteger> symbols) {
        PartUses pu = new PartUses();
        pu.setPart(part);
        pu.setImages(images);
        pu.setPages(pages);
        pu.setRegions(regions);
        pu.setSymbols(symbols);

        this.uses.add(pu);
    }
}
