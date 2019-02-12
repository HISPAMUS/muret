package es.ua.dlsi.grfia.im3ws.muret.controller;


import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.controller.CRUDController;
import es.ua.dlsi.grfia.im3ws.muret.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.PostStrokes;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.ImageModel;
import es.ua.dlsi.grfia.im3ws.muret.service.*;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author drizo
 */
@RequestMapping("/muretapi/image")
@RestController
public class ImageController extends CRUDController<Image, Long, ImageService> {
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

    @Override
    protected ImageService initService() {
        return imageService;
    }

    @Autowired
    private ImageModel imageModel;

    /**
     * It returns the new list of pages of the image
     * @param id
     * @param x
     * @return
     * @throws IM3WSException
     */
    @GetMapping(path = {"pageSplit/{id}/{x}"})
    public List<Page> pageSplit(@PathVariable("id") Long id, @PathVariable("x") Double x) throws IM3WSException {
        Optional<Image> image = imageService.findById(id);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find an image with id " + id);
        }
        return imageModel.pageSplit(image.get(), x.intValue());
    }

    /**
     * It returns the new list of pages of the image
     * @param id
     * @param x
     * @return
     * @throws IM3WSException
     */
    @GetMapping(path = {"regionSplit/{id}/{x}/{y}"})
    public List<Page> regionSplit(@PathVariable("id") Long id, @PathVariable("x") Double x, @PathVariable("y") Double y) throws IM3WSException {
        Optional<Image> image = imageService.findById(id);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find an image with id " + id);
        }
        return imageModel.regionSplit(image.get(), x.intValue(), y.intValue());
    }


    @GetMapping(path = {"documentAnalysisClear/{id}"})
    public List<Page>  documentAnalysisClear(@PathVariable("id") Long id) throws IM3WSException {
        Optional<Image> image = imageService.findById(id);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find an image with id " + id);
        }
        return imageModel.leaveJustOnePageAndRegion(image.get());
    }

    @GetMapping(path = {"pageUpdate/{id}/{fromX}/{fromY}/{toX}/{toY}"})
    public Page pageUpdate(@PathVariable("id") Long id,
                             @PathVariable("fromX") Double fromX,
                             @PathVariable("fromY") Double fromY,
                             @PathVariable("toX") Double toX,
                             @PathVariable("toY") Double toY) throws IM3WSException {
        Optional<Page> page = pageService.findById(id);
        if (!page.isPresent()) {
            throw new IM3WSException("Cannot find a page with id " + id);
        }
        page.get().getBoundingBox().setFromX(fromX.intValue());
        page.get().getBoundingBox().setFromY(fromY.intValue());
        page.get().getBoundingBox().setToX(toX.intValue());
        page.get().getBoundingBox().setToY(toY.intValue());
        return pageService.update(page.get());
    }

    @GetMapping(path = {"regionUpdate/{id}/{fromX}/{fromY}/{toX}/{toY}"})
    public Region regionUpdate(@PathVariable("id") Long id,
                             @PathVariable("fromX") Double fromX,
                             @PathVariable("fromY") Double fromY,
                             @PathVariable("toX") Double toX,
                             @PathVariable("toY") Double toY) throws IM3WSException {
        Optional<Region> region = regionService.findById(id);
        if (!region.isPresent()) {
            throw new IM3WSException("Cannot find a region with id " + id);
        }
        region.get().getBoundingBox().setFromX(fromX.intValue());
        region.get().getBoundingBox().setFromY(fromY.intValue());
        region.get().getBoundingBox().setToX(toX.intValue());
        region.get().getBoundingBox().setToY(toY.intValue());
        return regionService.update(region.get());
    }

    @GetMapping(path = {"regionUpdateType/{id}/{regionTypeId}"})
    public Region regionUpdate(@PathVariable("id") Long id,
                               @PathVariable("regionTypeId") Integer regionTypeId) throws IM3WSException {
        Optional<Region> region = regionService.findById(id);
        if (!region.isPresent()) {
            throw new IM3WSException("Cannot find a region with id " + id);
        }
        Optional<RegionType> regionType = regionTypeService.findById(regionTypeId);
        if (!regionType.isPresent()) {
            throw new IM3WSException("Cannot find a region type with id " + regionTypeId);
        }

        region.get().setRegionType(regionType.get());
        return regionService.update(region.get());
    }

    @GetMapping(path = {"createSymbolFromBoundingBox/{regionID}/{fromX}/{fromY}/{toX}/{toY}"})
    public Symbol createSymbolFromBoundingBox(@PathVariable("regionID") Long regionID,
                               @PathVariable("fromX") Double fromX,
                               @PathVariable("fromY") Double fromY,
                               @PathVariable("toX") Double toX,
                               @PathVariable("toY") Double toY) throws IM3WSException, IM3Exception {
        Optional<Region> region = regionService.findById(regionID);
        if (!region.isPresent()) {
            throw new IM3WSException("Cannot find a region with id " + regionID);
        }

        AgnosticSymbol agnosticSymbol = imageModel.classifySymbolFromImageBoundingBox(region.get().getPage().getImage(),
                fromX.intValue(), fromY.intValue(), toX.intValue(), toY.intValue(), "TO-DO"); //TODO

        Logger.getLogger(this.getClass().getName()).severe("TO-DO CLASSIFIER"); //TODO Urgent

        Symbol symbol = new Symbol(region.get(), agnosticSymbol,
                new BoundingBox(fromX.intValue(), fromY.intValue(), toX.intValue(), toY.intValue()),
                null, null);

        return symbolService.create(symbol);
    }

    //TODO Generalizar a cualquier tipo de strokes
    @RequestMapping(value="/createSymbolFromStrokes", method=RequestMethod.POST)
    @ResponseBody
    public Symbol createSymbol(@RequestBody PostStrokes requestObject) throws IM3WSException, IM3Exception {
        Optional<Region> region = regionService.findById(requestObject.getRegionID());
        if (!region.isPresent()) {
            throw new IM3WSException("Cannot find a region with id " + requestObject.getRegionID());
        }

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int npoints=0;
        CalcoStrokes calcoStrokes = new CalcoStrokes();
        for (es.ua.dlsi.grfia.im3ws.muret.controller.payload.Point[] strokePoints: requestObject.getPoints()) {
            CalcoStroke calcoStroke = new CalcoStroke();
            calcoStrokes.addStroke(calcoStroke);
            for (es.ua.dlsi.grfia.im3ws.muret.controller.payload.Point point: strokePoints) {
                calcoStroke.addPoint(new es.ua.dlsi.grfia.im3ws.muret.entity.Point(point.getTimestamp(), point.getX(), point.getY()));

                minX = Math.min(minX, point.getX());
                minY = Math.min(minY, point.getY());
                maxX = Math.max(maxX, point.getX());
                maxY = Math.max(maxY, point.getY());

                npoints++;
            }
        }

        if (npoints < 2) {
            throw new IM3WSException("Cannot classify with just one point");
        }

        BoundingBox boundingBox = new BoundingBox(minX, minY, maxX, maxY);

        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Bounding box from strokes {0}", boundingBox);
        //TODO Que busque (si está seleccionado) también en el clasificador por strokes

        AgnosticSymbol agnosticSymbol = imageModel.classifySymbolFromImageBoundingBox(region.get().getPage().getImage(),
                minX, minY, maxX, maxY, "TO-DO"); //TODO

        Logger.getLogger(this.getClass().getName()).severe("TO-DO CLASSIFIER"); //TODO Urgent

        Symbol symbol = new Symbol(region.get(), agnosticSymbol,
                boundingBox,null, calcoStrokes);

        return symbolService.create(symbol);
    }

    // with SymbolController --> repository --> delete it does not work
    @GetMapping(path = {"removeSymbol/{regionID}/{symbolID}"})
    public boolean removeSymbol(@PathVariable("regionID") Long regionID,
                               @PathVariable("symbolID") Long symbolID) throws IM3WSException {
        Optional<Region> region = regionService.findById(regionID);
        if (!region.isPresent()) {
            throw new IM3WSException("Cannot find a region with id " + regionID);
        }

        // the number of symbols is tiny
        for (Symbol symbol: region.get().getSymbols()) {
            if (symbol.getId().equals(symbolID)) {
                region.get().getSymbols().remove(symbol);
                regionService.update(region.get()); // it removes the symbol
                return true;
            }
        }

        throw new IM3WSException("Cannot find a symbol in region " + regionID + " with id " + symbolID);
    }

    private ResponseEntity<InputStreamResource> getImage(Long imageID, String imagesRelativePath) throws IM3WSException, FileNotFoundException {
        Optional<Image> image = imageService.findById(imageID);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find an image with id " + imageID);
        }

        File projectFolder = new File(muretConfiguration.getFolder(), image.get().getProject().getPath());
        File masterImagesFolder = new File(projectFolder, imagesRelativePath);
        File imageFile = new File(masterImagesFolder, image.get().getFilename());
        if (!imageFile.exists()) {
            throw new IM3WSException("Image '" + imageFile.getAbsolutePath() + "' for image with ID=" + imageID + " does not exist");
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG) //TODO Siempre devolver JPEG, si no los tenemos cambiarlos
                .body(new InputStreamResource(new FileInputStream(imageFile)));

    }

    @GetMapping(value = "master/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getMasterImage(@PathVariable("imageID") Long imageID) throws IM3WSException, FileNotFoundException {
        return getImage(imageID,  MURETConfiguration.MASTER_IMAGES);
    }

    @GetMapping(value = "thumbnail/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getThumbnailImage(@PathVariable("imageID") Long imageID) throws IM3WSException, FileNotFoundException {
        return getImage(imageID,  MURETConfiguration.THUMBNAIL_IMAGES);
    }
    @GetMapping(value = "preview/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getPreviewImage(@PathVariable("imageID") Long imageID) throws IM3WSException, FileNotFoundException {
        return getImage(imageID,  MURETConfiguration.PREVIEW_IMAGES);
    }

}
