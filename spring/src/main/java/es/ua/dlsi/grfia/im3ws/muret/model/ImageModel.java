package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.service.*;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.adt.graphics.BoundingBox;
import es.ua.dlsi.im3.core.adt.graphics.BoundingBoxXY;
import es.ua.dlsi.im3.omr.classifiers.symbolrecognition.DLSymbolAndPositionClassifier;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

@Component
public class ImageModel {
    @Autowired
    MURETConfiguration muretConfiguration;

    @Autowired
    ImageService imageService;

    @Autowired
    RegionService regionService;

    @Autowired
    PageService pageService;

    @Autowired
    SymbolService symbolService;

    @Autowired
    RegionTypeService regionTypeService;

    RegionType unknownRegionType;

    /*public ImageModel(ImageService imageService, PageService pageService, RegionService regionService, SymbolService symbolService) {
        this.imageService = imageService;
        this.regionService = regionService;
        this.pageService = pageService;
        this.symbolService = symbolService;
    }*/

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

            image.addPage(pageService.create(omrPage1));
            image.addPage(pageService.create(omrPage2));
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
                    pageService.update(page);

                    newPage = pageService.create(newPage);
                    image.addPage(newPage);

                    // create a region for new page
                    Region newRegion = new Region(newPage, null,
                            newPage.getBoundingBox().getFromX(), newPage.getBoundingBox().getFromY(),
                            newPage.getBoundingBox().getToX(), newPage.getBoundingBox().getToY());
                    newRegion = regionService.create(newRegion);
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
                            symbolService.update(symbol);
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
            image.addPage(pageService.create(omrPage1));
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
    public List<Page> leaveJustOnePageAndRegion(Image image) {
        Page onePage = new Page(image, 0, 0, image.getWidth(), image.getHeight(), null, null);
        //Region oneRegion = regionService.create(new Region(onePage, 0, 0, image.getWidth(), image.getHeight()));
        Region oneRegion = new Region(onePage, null, 0, 0, image.getWidth(), image.getHeight());
        onePage.addRegion(oneRegion);

        LinkedList<Symbol> symbols = new LinkedList<>();
        for (Page page: image.getPages()) {
            for (Region omrRegion: page.getRegions()) {
                if (omrRegion.getSymbols() != null) {
                    symbols.addAll(omrRegion.getSymbols());
                }
            }
            //pageService.delete(page.getId());
        }
        for (Symbol omrSymbol: symbols) { // avoid concurrent modification above
            omrSymbol.setRegion(oneRegion);
        }
        for (Page page: image.getPages()) {
            page.setImage(null); // to force the delete instead of an update
        }
        image.getPages().clear();
        image.addPage(onePage);
        imageService.update(image);
        return image.getPages();
    }

    @Transactional
    public void splitRegionAt(Page page, int y) throws IM3WSException {
        if (page.getRegions() == null || page.getRegions().isEmpty()) {
            Region omrRegion1 = regionService.create(new Region(page, null, page.getBoundingBox().getFromX(), 0, page.getBoundingBox().getToX(), y-1));
            Region omrRegion2 = regionService.create(new Region(page, null, page.getBoundingBox().getFromX(), y, page.getBoundingBox().getToX(), page.getBoundingBox().getToY()));
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
                    regionService.update(region);

                    Region newRegion = regionService.create(new Region(page, null, region.getBoundingBox().getFromX(), splitYTakingIntoAccountTopSymbol,
                            region.getBoundingBox().getToX(), toY));
                    page.addRegion(newRegion);

                    for (Symbol symbol: symbolsToMoveToNewRegion) {
                        symbol.setRegion(newRegion);
                        symbolService.update(symbol);
                    }
                    break;
                }
            }
        }
    }

    public AgnosticSymbol classifySymbolFromImageBoundingBox(Image image, int fromX, int fromY, int toX, int toY, String classifierName) throws IM3Exception {
        //TODO generalizar - coger el clasificador cargado - ¿si está el python en memoria tb.?

        boolean usePythonClassifiers = false;
        ////TODO
        Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "TO-DO HE DESACTIVADO LAS PETICIONES A PYTHON");
        if (!usePythonClassifiers) {
            return AgnosticSymbol.parseAgnosticString(AgnosticVersion.v2, "clef.C:L3"); // TODO - siempre devuelvo lo mismo
        } else {
            File localClassifierPath = new File(muretConfiguration.getPythonclassifiers(), "symbol-classification");

            // just execute test in drizo's computer :(
            if (!localClassifierPath.exists()) {
                throw new IM3Exception("Python classifier path not found: '" + localClassifierPath.getAbsolutePath() + "'");
            } else {
                DLSymbolAndPositionClassifier classifier = new DLSymbolAndPositionClassifier(localClassifierPath);
                BoundingBox boundingBox = new BoundingBoxXY(fromX, fromY, toX, toY);

                File muretProjectsFolder = new File(image.getProject().getPath()); // TODO estático
                File imagesFolder = new File(muretProjectsFolder, MURETConfiguration.MASTER_IMAGES);
                File imageFile = new File(imagesFolder, image.getFilename());
                if (!imageFile.exists()) {
                    throw new IM3Exception("Image to classify '" + imageFile + "' does not exist");
                }
                AgnosticSymbol agnosticSymbol = classifier.recognize(imageFile, boundingBox);
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "DL classifier returned {0}", agnosticSymbol);
                return agnosticSymbol;
            }
        }
    }
}
