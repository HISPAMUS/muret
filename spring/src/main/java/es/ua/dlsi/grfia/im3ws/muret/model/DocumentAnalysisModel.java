package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.AutoDocumentAnalysisModel;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.CoordinatesDocAnBounding;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
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
    int ONE_PAGE_MARGIN = 25;
    int ONE_PAGE_REGION_MARGIN = 50;
    private final MURETConfiguration muretConfiguration;
    private final ImageRepository imageRepository;
    private final RegionRepository regionRepository;
    private final PageRepository pageRepository;
    private final SymbolRepository symbolRepository;
    private final RegionTypeRepository regionTypeRepository;
    RegionType undefinedRegionType;

    @Autowired
    public DocumentAnalysisModel(MURETConfiguration muretConfiguration, ImageRepository imageRepository, RegionRepository regionRepository, PageRepository pageRepository, SymbolRepository symbolRepository, RegionTypeRepository regionTypeRepository) {
        this.muretConfiguration = muretConfiguration;
        this.imageRepository = imageRepository;
        this.regionRepository = regionRepository;
        this.pageRepository = pageRepository;
        this.symbolRepository = symbolRepository;
        this.regionTypeRepository = regionTypeRepository;
        this.undefinedRegionType = regionTypeRepository.findByName("undefined");
        if (this.undefinedRegionType == null) {
            throw new RuntimeException("Cannot find 'undefined' region type");
        }
    }

    /**
     * @param image
     * @param x
     * @return list of all pages including new ones
     */
    @Transactional
    public List<Page> pageSplit(Image image, int x) throws IM3WSException {
        //TODO Transaction

        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Splitting page at {0}", x);

        if (image.getPages() == null || image.getPages().isEmpty()) {
            Page omrPage1 = new Page(image, 0, 0, x, image.getHeight(), null, null, null);
            Page omrPage2 = new Page(image, x + 1, 0, image.getWidth(), image.getHeight(), null, null, null);

            image.addPage(pageRepository.save(omrPage1));
            image.addPage(pageRepository.save(omrPage2));
        } else {
            for (Page page : image.getPages()) {
                if (page.getBoundingBox().getFromX() == x) {
                    throw new IM3WSException("The specified position is the same as the stating of page " + page);
                }
                if (page.getBoundingBox().getFromX() + page.getBoundingBox().getWidth() == x) {
                    throw new IM3WSException("The specified position is the same as the end of page " + page);
                }

                if (page.getBoundingBox().getFromX() < x && x < page.getBoundingBox().getFromX() + page.getBoundingBox().getWidth()) {
                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Splitting page {0}", page);

                    Page newPage = new Page(image, x, 0, page.getBoundingBox().getFromX() + page.getBoundingBox().getWidth(), image.getHeight(), null, null, null);
                    page.getBoundingBox().setWidth(x - page.getBoundingBox().getFromX() - 1);
                    pageRepository.save(page);

                    newPage = pageRepository.save(newPage);
                    image.addPage(newPage);

                    // create a region for new page
                    Region newRegion = new Region(newPage, null,
                            newPage.getBoundingBox().getFromX(), newPage.getBoundingBox().getFromY(),
                            newPage.getBoundingBox().getToX(), newPage.getBoundingBox().getToY(), null);
                    newRegion = regionRepository.save(newRegion);
                    newPage.addRegion(newRegion);

                    // not move all symbols in new page and change the width of previous regions
                    for (Region region : page.getRegions()) {
                        region.getBoundingBox().setWidth(page.getBoundingBox().getWidth()); // change the width of all regions inside

                        LinkedList<Symbol> symbols = new LinkedList<>();
                        for (Symbol symbol : region.getSymbols()) {
                            if (!region.getBoundingBox().contains(symbol.getBoundingBox().getFromX(), symbol.getBoundingBox().getFromY())) {
                                if (newRegion.getBoundingBox().contains(symbol.getBoundingBox().getFromX(), symbol.getBoundingBox().getFromY())) {
                                    symbols.add(symbol);
                                } else {
                                    throw new IM3WSException("No region contains the symbol!!!");
                                }
                            }
                        }
                        for (Symbol symbol : symbols) { // avoid concurrent modification above
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
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Splitting region at {0},{1}", new Object[]{x, y});
        if (image.getPages() == null || image.getPages().isEmpty()) {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "No page, creating a single page");
            Page omrPage1 = new Page(image, 0, 0, image.getWidth(), image.getHeight(), null, null, null);
            image.addPage(pageRepository.save(omrPage1));
        }

        // first locate the page
        for (Page page : image.getPages()) {
            if (page.getBoundingBox().getFromX() == x) {
                throw new IM3WSException("The specified position is the same as the stating of page " + page);
            }
            if (page.getBoundingBox().getFromX() + page.getBoundingBox().getWidth() == x) {
                throw new IM3WSException("The specified position is the same as the end of page " + page);
            }

            if (page.getBoundingBox().getFromX() < x && x < page.getBoundingBox().getFromX() + page.getBoundingBox().getWidth()) {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Splitting region at {0},{1} in page {2}", new Object[]{x, y, page});
                splitRegionAt(page, y);
            }
        }
        return image.getPages();
    }

    /**
     * It creates one page and, when there are symbols, one region and puts every symbol inside it
     *
     * @param image
     */
    @Transactional
    public List<Page> leaveJustOnePageAndRegion(Image image) throws IM3WSException {
        RegionType regionType = this.regionTypeRepository.findByName("undefined");
        if (regionType == null) {
            throw new IM3WSException("Cannot find 'undefined' region type");
        }

        Page onePage = new Page(image, ONE_PAGE_MARGIN, ONE_PAGE_MARGIN, image.getWidth()-ONE_PAGE_MARGIN, image.getHeight()-ONE_PAGE_MARGIN, null, null, null);

        LinkedList<Symbol> symbols = new LinkedList<>();
        for (Page page : image.getPages()) {
            for (Region omrRegion : page.getRegions()) {
                if (omrRegion.getSymbols() != null) {
                    symbols.addAll(omrRegion.getSymbols());
                }
            }
            //pageRepository.delete(page.getId());
        }

        if (symbols.size() > 0) {
            Region oneRegion = new Region(onePage, regionType, ONE_PAGE_REGION_MARGIN, ONE_PAGE_REGION_MARGIN, image.getWidth()-ONE_PAGE_REGION_MARGIN, image.getHeight()-ONE_PAGE_REGION_MARGIN, null);
            onePage.addRegion(oneRegion);

            for (Symbol omrSymbol : symbols) { // avoid concurrent modification above
                omrSymbol.setRegion(oneRegion);
            }
        }
        for (Page page : image.getPages()) {
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
            Region omrRegion1 = regionRepository.save(new Region(page, null, page.getBoundingBox().getFromX(), 0, page.getBoundingBox().getToX(), y - 1, null));
            Region omrRegion2 = regionRepository.save(new Region(page, null, page.getBoundingBox().getFromX(), y, page.getBoundingBox().getToX(), page.getBoundingBox().getToY(), null));
            page.addRegion(omrRegion1);
            page.addRegion(omrRegion2);
        } else {
            for (Region region : page.getRegions()) {
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

                    LinkedList<Symbol> symbolsToMoveToNewRegion = new LinkedList<>();
                    int splitYTakingIntoAccountTopSymbol = y; // by default it is the drawn y
                    for (Symbol symbol : region.getSymbols()) {
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
                            region.getBoundingBox().getToX(), toY, null));
                    page.addRegion(newRegion);

                    for (Symbol symbol : symbolsToMoveToNewRegion) {
                        symbol.setRegion(newRegion);
                        symbolRepository.save(symbol);
                    }
                    break;
                }
            }
        }
    }

    public List<Page> createPages(Image persistentImage, int numPages) throws IM3WSException {
        ArrayList<Page> newPages = new ArrayList<>();
        int width = persistentImage.getWidth() / numPages;
        int height = persistentImage.getHeight();

        int fromX = 0;
        for (int i=0; i<numPages; i++) {
            Page page = new Page(persistentImage, fromX, 0, fromX + width, height, null, null, null);
            fromX += width;
            Page savedPage = pageRepository.save(page);
            newPages.add(savedPage);
            persistentImage.getPages().add(savedPage);
        }
        imageRepository.save(persistentImage);
        return newPages;
    }

    public List<Page> createPages(long imageID, int numPages) throws IM3WSException {
        Image persistentImage = getImage(imageID);
        return createPages(persistentImage, numPages);
    }


    @Transactional
    /**
     * It moves the current regions to the new page if its center is contained inside the new page
     */
    public List<Page> createPage(long imageID, BoundingBox boundingBox) throws IM3WSException {
        Image persistentImage = getImage(imageID);

        List<Region> regionsToBeMoved = new ArrayList<>();
        for (Page previousPage : persistentImage.getPages()) { // new page has not been inserted
            for (Region region : previousPage.getRegions()) {
                if (boundingBox.containsCenterOf(region.getBoundingBox())) {
                    regionsToBeMoved.add(region);
                }
            }
        }

        Page persistentPage = new Page();
        persistentPage.setBoundingBox(boundingBox);
        persistentPage.setImage(persistentImage);
        persistentPage = pageRepository.save(persistentPage);
        persistentImage.getPages().add(persistentPage);

        for (Region region : regionsToBeMoved) {
            region.setPage(persistentPage);
        }


        regionRepository.saveAll(regionsToBeMoved);
        return persistentImage.getPages();
    }

    @Transactional
    public List<Page> createRegion(long imageID, int regionTypeID, BoundingBox boundingBox) throws IM3WSException {
        Image persistentImage = getImage(imageID);

        Optional<RegionType> persistentRegionType = regionTypeRepository.findById(regionTypeID);
        if (!persistentRegionType.isPresent()) {
            throw new IM3WSException("Cannot find a region type with id " + regionTypeID);
        }

        // if there is not any page, a new page is created spaning the whole image
        List<Page> pages;
        if (persistentImage.getPages() == null || persistentImage.getPages().isEmpty()) {
            pages = this.createPage(imageID, new BoundingBox(0, 0, persistentImage.getWidth(), persistentImage.getHeight()));
        } else {
            pages = persistentImage.getPages();
        }

        // look for the page that will create the region
        Page parentPage = null;
        for (Page page : pages) {
            if (page.getBoundingBox().containsCenterOf(boundingBox)) {
                parentPage = page;
                break;
            }
        }

        if (parentPage == null) {
            throw new IM3WSException("Cannot find a page to insert the region");
        }

        Region region = new Region();
        region.setRegionType(persistentRegionType.get());
        region.setPage(parentPage);
        region.setBoundingBox(boundingBox);
        regionRepository.save(region);
        if (parentPage.getRegions() == null) {
            parentPage.setRegions(new ArrayList<>());
        }
        parentPage.getRegions().add(region);

        return persistentImage.getPages();
    }

    /**
     *
     * @param pageID
     * @return Deleted pageID
     * @throws IM3WSException
     */
    @Transactional
    public long deletePage(long pageID) throws IM3WSException {
        Optional<Page> persistentPage = pageRepository.findById(pageID);
        if (!persistentPage.isPresent()) {
            throw new IM3WSException("Cannot find a page with id " + pageID);
        }

        if (persistentPage.get().getRegions() != null) {
            if (persistentPage.get().getRegions().size() == 1) {
                Region persistentRegion = getRegion(persistentPage.get().getRegions().get(0).getId());
                if (persistentRegion.getSymbols() != null && !persistentRegion.getSymbols().isEmpty()) {
                    throw new IM3WSException("Cannot remove a page that with a region containing " + persistentRegion.getSymbols() + " symbols");
                } else {
                    persistentPage.get().getRegions().remove(persistentRegion);
                }
            } else if (persistentPage.get().getRegions().size() > 1) {
                throw new IM3WSException("Cannot remove a page that has " + persistentPage.get().getRegions().size() + " regions inside");
            }
        }

        // pageRepository.delete(persistentPage.get());
        Image image = getImage(persistentPage.get().getImage().getId());
        image.getPages().remove(persistentPage.get());// it is the correct way of deleting, removing from the owner class for being a composition
        // For deleting this way the orphan = true and CASCADE.ALL must be set

        return pageID;
    }

    /**
     *
     * @param regionID
     * @return Deleted regionID
     * @throws IM3WSException
     */
    @Transactional
    public long deleteRegion(long regionID) throws IM3WSException {
        Region persistentRegion = getRegion(regionID);

        if (persistentRegion.getSymbols() != null && !persistentRegion.getSymbols().isEmpty()) {
            throw new IM3WSException("Cannot remove a region that has symbols inside");
        }

        Optional<Page> persistentPage = pageRepository.findById(persistentRegion.getPage().getId());
        if (!persistentPage.isPresent()) {
            throw new IM3WSException("Cannot find page with id " + persistentRegion.getPage().getId());
        }

        //regionRepository.delete(persistentRegion.get());
        persistentPage.get().getRegions().remove(persistentRegion); // it is the correct way of deleting, removing from the owner class for being a composition
        // For deleting this way the orphan = true and CASCADE.ALL must be set
        return regionID;
    }

    private Image getImage(long imageID) throws IM3WSException {
        Optional<Image> persistentImage = imageRepository.findById(imageID);

        if (!persistentImage.isPresent()) {
            throw new IM3WSException("Cannot find an image with id " + imageID);
        }

        return persistentImage.get();
    }

    private Region getRegion(long regionID) throws IM3WSException {
        Optional<Region> persistentRegion = regionRepository.findById(regionID);
        if (!persistentRegion.isPresent()) {
            throw new IM3WSException("Cannot find a region with id " + regionID);
        }

        return persistentRegion.get();
    }

    public void clear(Image image) throws IM3WSException {
        if (image.getPages() != null) {
            for (Page page: image.getPages()) {
                if (page.getRegions() != null) {
                    for (Region region: page.getRegions()) {
                        if (region.getSemanticEncoding() != null && !region.getSemanticEncoding().trim().isEmpty()) {
                            throw new IM3WSException("A region has a semantic encoding, delete it first");
                        }
                        if (region.getSymbols() != null && region.getSymbols().size() > 0) {
                            throw new IM3WSException("A region has a an agnostic encoding, delete them first");
                        }
                    }
                    page.getRegions().clear();
                    pageRepository.save(page);
                }
            }
            image.getPages().clear();
            imageRepository.save(image);
        }

    }

    public List<Page> createAutomaticDocumentAnalysis(Image image, int numPages, AutoDocumentAnalysisModel autoDocumentAnalysisModel) throws IM3WSException {
        this.clear(image);
        List<Page> pages = createPages(image, numPages);

        List<Region> newRegions = new ArrayList<>();
        BoundingBox imageBoundingBox = new BoundingBox();
        imageBoundingBox.setToX(image.getWidth());
        imageBoundingBox.setToY(image.getHeight());

        for (CoordinatesDocAnBounding coordinatesDocAnBounding: autoDocumentAnalysisModel.getRegions()) {
            if (coordinatesDocAnBounding.getX0() != null) {
                Region region = new Region();
                BoundingBox boundingBox = new BoundingBox(coordinatesDocAnBounding.getX0(), coordinatesDocAnBounding.getY0(),
                        coordinatesDocAnBounding.getXf(), coordinatesDocAnBounding.getYf());
                region.setBoundingBox(boundingBox);

                boundingBox.adjustToFitInto(imageBoundingBox); // sometimes, classify return wrong dimensions

                if (coordinatesDocAnBounding.getRegionType() != null && !coordinatesDocAnBounding.getRegionType().trim().isEmpty()) {
                    RegionType regionType = regionTypeRepository.findByName(coordinatesDocAnBounding.getRegionType().trim());
                    if (regionType == null) {
                        throw new IM3WSException("Cannot find a region type name = '" + coordinatesDocAnBounding.getRegionType() + "'");
                    }
                    region.setRegionType(regionType);
                } else {
                    region.setRegionType(undefinedRegionType);
                }

                // now locate page for the region
                for (Page page : pages) {
                    if (page.getBoundingBox().containsCenterOf(boundingBox)) {
                        region.setPage(page);
                        page.addRegion(region);
                        break;
                    }
                }

                if (region.getPage() == null) {
                    throw new IM3WSException("Cannot find a page that can contain region center of " + region);
                }

                newRegions.add(region);
            }
        }

        regionRepository.saveAll(newRegions);

        return pages;
    }
}
