package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.PageCreation;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

@Component
public class DocumentAnalysisModel {
    private final MURETConfiguration muretConfiguration;
    private final ImageRepository imageRepository;
    private final RegionRepository regionRepository;
    private final PageRepository pageRepository;
    private final SymbolRepository symbolRepository;
    private final RegionTypeRepository regionTypeRepository;
    RegionType unknownRegionType;

    @Autowired
    public DocumentAnalysisModel(MURETConfiguration muretConfiguration, ImageRepository imageRepository, RegionRepository regionRepository, PageRepository pageRepository, SymbolRepository symbolRepository, RegionTypeRepository regionTypeRepository) {
        this.muretConfiguration = muretConfiguration;
        this.imageRepository = imageRepository;
        this.regionRepository = regionRepository;
        this.pageRepository = pageRepository;
        this.symbolRepository = symbolRepository;
        this.regionTypeRepository = regionTypeRepository;
    }

    /**
     * @param image
     * @param x
     * @return list of all pages including new ones
     */
    @Transactional
    public List<Page> pageSplit(Image image, int x) throws IM3WSException {
        //TODO Transaction

        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Splitting page at {0}" , x);

        if (image.getPages() == null || image.getPages().isEmpty()) {
            Page omrPage1 = new Page(image, 0, 0, x, image.getHeight(), null, null);
            Page omrPage2 = new Page(image, x+1, 0, image.getWidth(), image.getHeight(), null, null);

            image.addPage(pageRepository.save(omrPage1));
            image.addPage(pageRepository.save(omrPage2));
        } else {
            for (Page page: image.getPages()) {
                if (page.getBoundingBox().getFromX() == x) {
                    throw new IM3WSException("The specified position is the same as the stating of page " + page);
                }
                if (page.getBoundingBox().getFromX()+page.getBoundingBox().getWidth() == x) {
                    throw new IM3WSException("The specified position is the same as the end of page " + page);
                }

                if (page.getBoundingBox().getFromX() < x && x < page.getBoundingBox().getFromX()+page.getBoundingBox().getWidth()) {
                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Splitting page {0}", page);

                    Page newPage = new Page(image, x, 0, page.getBoundingBox().getFromX()+page.getBoundingBox().getWidth(), image.getHeight(), null, null);
                    page.getBoundingBox().setWidth(x - page.getBoundingBox().getFromX()-1);
                    pageRepository.save(page);

                    newPage = pageRepository.save(newPage);
                    image.addPage(newPage);

                    // create a region for new page
                    Region newRegion = new Region(newPage, null,
                            newPage.getBoundingBox().getFromX(), newPage.getBoundingBox().getFromY(),
                            newPage.getBoundingBox().getToX(), newPage.getBoundingBox().getToY());
                    newRegion = regionRepository.save(newRegion);
                    newPage.addRegion(newRegion);

                    // not move all symbols in new page and change the width of previous regions
                    for (Region region: page.getRegions()) {
                        region.getBoundingBox().setWidth(page.getBoundingBox().getWidth()); // change the width of all regions inside

                        LinkedList<Symbol> symbols = new LinkedList<>();
                        for (Symbol symbol: region.getSymbols()) {
                            if (!region.getBoundingBox().contains(symbol.getBoundingBox().getFromX(),symbol.getBoundingBox().getFromY())) {
                                if (newRegion.getBoundingBox().contains(symbol.getBoundingBox().getFromX(), symbol.getBoundingBox().getFromY())) {
                                    symbols.add(symbol);
                                } else {
                                    throw new IM3WSException("No region contains the symbol!!!");
                                }
                            }
                        }
                        for (Symbol symbol: symbols) { // avoid concurrent modification above
                            symbol.setRegion(newRegion);
                            symbolRepository.save(symbol);
                        }
                    }
                    break;
                }
            }
        }
        return image.getPages();
    }

    @Transactional
    public List<Page> regionSplit(Image image, int x, int y) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Splitting region at {0},{1}" , new Object[]{x, y});
        if (image.getPages() == null || image.getPages().isEmpty()) {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "No page, creating a single page");
            Page omrPage1 = new Page(image, 0, 0, image.getWidth(), image.getHeight(), null, null);
            image.addPage(pageRepository.save(omrPage1));
        }

        // first locate the page
        for (Page page: image.getPages()) {
            if (page.getBoundingBox().getFromX() == x) {
                throw new IM3WSException("The specified position is the same as the stating of page " + page);
            }
            if (page.getBoundingBox().getFromX() + page.getBoundingBox().getWidth() == x) {
                throw new IM3WSException("The specified position is the same as the end of page " + page);
            }

            if (page.getBoundingBox().getFromX() < x && x < page.getBoundingBox().getFromX() + page.getBoundingBox().getWidth()) {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Splitting region at {0},{1} in page {2}" , new Object[]{x, y, page});
                splitRegionAt(page, y);
            }
        }
        return image.getPages();
    }

    /**
     * It creates one page and region and puts every symbol inside it
     * @param image
     */
    @Transactional
    public List<Page> leaveJustOnePageAndRegion(Image image) throws IM3WSException {
        RegionType regionType = this.regionTypeRepository.findByName("undefined");
        if (regionType == null) {
            throw new IM3WSException("Cannot find 'undefined' region type");
        }

        Page onePage = new Page(image, 0, 0, image.getWidth(), image.getHeight(), null, null);
        //Region oneRegion = regionRepository.save(new Region(onePage, 0, 0, image.getWidth(), image.getHeight()));
        Region oneRegion = new Region(onePage, regionType, 0, 0, image.getWidth(), image.getHeight());
        onePage.addRegion(oneRegion);

        LinkedList<Symbol> symbols = new LinkedList<>();
        for (Page page: image.getPages()) {
            for (Region omrRegion: page.getRegions()) {
                if (omrRegion.getSymbols() != null) {
                    symbols.addAll(omrRegion.getSymbols());
                }
            }
            //pageRepository.delete(page.getId());
        }
        for (Symbol omrSymbol: symbols) { // avoid concurrent modification above
            omrSymbol.setRegion(oneRegion);
        }
        for (Page page: image.getPages()) {
            page.setImage(null); // to force the delete instead of an update
        }
        image.getPages().clear();
        image.addPage(onePage);
        imageRepository.save(image);
        return image.getPages();
    }

    @Transactional
    public void splitRegionAt(Page page, int y) throws IM3WSException {
        if (page.getRegions() == null || page.getRegions().isEmpty()) {
            Region omrRegion1 = regionRepository.save(new Region(page, null, page.getBoundingBox().getFromX(), 0, page.getBoundingBox().getToX(), y-1));
            Region omrRegion2 = regionRepository.save(new Region(page, null, page.getBoundingBox().getFromX(), y, page.getBoundingBox().getToX(), page.getBoundingBox().getToY()));
            page.addRegion(omrRegion1);
            page.addRegion(omrRegion2);
        } else {
            for (Region region: page.getRegions()) {
                int fromY = region.getBoundingBox().getFromY();
                int toY = region.getBoundingBox().getToY();
                if (y == fromY) {
                    throw new IM3WSException("Splitting region at other region beginning " + region);
                }
                if (y == toY) {
                    throw new IM3WSException("Splitting region at other region ending " + region);
                }
                if (y > fromY && y < toY) { // then split this region
                    // All symbols whose bottomY lay below y are attached to the new region. Regions above it will remain in the current region
                    // bounding box is computed taking into account the symbols, so two regions may overlap

                    LinkedList<Symbol> symbolsToMoveToNewRegion= new LinkedList<>();
                    int splitYTakingIntoAccountTopSymbol = y; // by default it is the drawn y
                    for (Symbol symbol: region.getSymbols()) {
                        if (symbol.getBoundingBox().getToY() > y) {
                            symbolsToMoveToNewRegion.add(symbol);
                            if (symbol.getBoundingBox().getFromY() < splitYTakingIntoAccountTopSymbol) {
                                splitYTakingIntoAccountTopSymbol = symbol.getBoundingBox().getFromY();
                            }
                        }
                    }
                    region.getBoundingBox().setHeight(y - 1 - fromY);
                    regionRepository.save(region);

                    Region newRegion = regionRepository.save(new Region(page, null, region.getBoundingBox().getFromX(), splitYTakingIntoAccountTopSymbol,
                            region.getBoundingBox().getToX(), toY));
                    page.addRegion(newRegion);

                    for (Symbol symbol: symbolsToMoveToNewRegion) {
                        symbol.setRegion(newRegion);
                        symbolRepository.save(symbol);
                    }
                    break;
                }
            }
        }
    }

    @Transactional
    /**
     * It moves the current regions to the new page if its center is contained inside the new page
     */
    public List<Page> createPage(PageCreation pageCreation) throws IM3WSException {
        Optional<Image> persistentImage = imageRepository.findById(pageCreation.getImageID());
        if (!persistentImage.isPresent()) {
            throw new IM3WSException("Cannot find a image with id " + pageCreation.getImageID());
        }

        List<Region> regionsToBeMoved = new ArrayList<>();
        for (Page previousPage: persistentImage.get().getPages()) { // new page has not been inserted
            for (Region region: previousPage.getRegions()) {
                if (pageCreation.getBoundingBox().containsCenterOf(region.getBoundingBox())) {
                    regionsToBeMoved.add(region);
                }
            }
        }


        Page persistentPage = new Page();
        persistentPage.setBoundingBox(pageCreation.getBoundingBox());
        persistentPage.setImage(persistentImage.get());
        persistentPage = pageRepository.save(persistentPage);
        persistentImage.get().getPages().add(persistentPage);

        for (Region region: regionsToBeMoved) {
            region.setPage(persistentPage);
        }


        regionRepository.saveAll(regionsToBeMoved);
        return persistentImage.get().getPages();
    }

    @Transactional
    public List<Page> createRegion(long imageID, int regionTypeID, BoundingBox boundingBox) throws IM3WSException {
        throw new IM3WSException("Cannot create region");
    }
}
