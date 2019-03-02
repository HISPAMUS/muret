package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.controller.ChangeResponse;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.DocumentAnalysisModel;
import es.ua.dlsi.grfia.im3ws.muret.repository.ImageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.PageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author drizo
 */
@RequestMapping("documentanalysis")
@RestController
public class DocumentAnalysisController {

    private final ImageRepository imageRepository;

    private final RegionRepository regionRepository;

    private final PageRepository pageRepository;

    private final RegionTypeRepository regionTypeRepository;

    private final DocumentAnalysisModel documentAnalysisModel;

    @Autowired
    public DocumentAnalysisController(ImageRepository imageRepository, RegionRepository regionRepository, PageRepository pageRepository, RegionTypeRepository regionTypeRepository, DocumentAnalysisModel documentAnalysisModel) {
        this.imageRepository = imageRepository;
        this.regionRepository = regionRepository;
        this.pageRepository = pageRepository;
        this.regionTypeRepository = regionTypeRepository;
        this.documentAnalysisModel = documentAnalysisModel;
    }


    @PutMapping(path = {"pageBoundingBoxUpdate"})
    public ChangeResponse pageBoundingBoxUpdate(@RequestBody BoundingBox boundingBox) throws IM3WSException {
        try {
            Optional<Page> page = pageRepository.findById(boundingBox.getId());
            if (!page.isPresent()) {
                throw new IM3WSException("Cannot find a page with id " + boundingBox.getId());
            }
            page.get().setBoundingBox(boundingBox);
            pageRepository.save(page.get());
            return new ChangeResponse();
        } catch (Throwable t) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot update page boundingBox", t);
            return new ChangeResponse(false, null, t.getMessage());
        }
    }

    @PutMapping(path = {"regionUpdate"})
    public ChangeResponse regionUpdate(@RequestBody Region region) throws IM3WSException {
        try {
            Optional<Region> persistentRegion = regionRepository.findById(region.getId());
            if (!persistentRegion.isPresent()) {
                throw new IM3WSException("Cannot find a region with id " + region.getId());
            }
            if (region.getBoundingBox() != null) {
                persistentRegion.get().setBoundingBox(region.getBoundingBox());
            }
            if (region.getRegionType() != null && !Objects.equals(persistentRegion.get().getRegionType(), region.getRegionType())) {
                Optional<RegionType> persistentRegionType = regionTypeRepository.findById(region.getRegionType().getId());
                if (!persistentRegionType.isPresent()) {
                    throw new IM3WSException("Cannot find a region type with id " + region.getRegionType().getId());
                }

                persistentRegion.get().setRegionType(persistentRegionType.get());
            }
            regionRepository.save(persistentRegion.get());
            return new ChangeResponse();
        } catch (Throwable t) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot update region boundingBox", t);
            return new ChangeResponse(false, null, t.getMessage());
        }
    }

    @Transactional // keep session open - avoid "failed to lazily initialize a collection" error
    @DeleteMapping(path = {"clear/{imageID}"})
    public ChangeResponse<List<Page>> clear(@PathVariable("imageID") long imageID) throws IM3WSException {
        try {
            Optional<Image> persistentImage = imageRepository.findById(imageID);
            if (!persistentImage.isPresent()) {
                throw new IM3WSException("Cannot find a image with id " + imageID);
            }
            List<Page> createdPages = this.documentAnalysisModel.leaveJustOnePageAndRegion(persistentImage.get());
            return new ChangeResponse<>(true, createdPages, null);
        } catch (Throwable t) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot update region boundingBox", t);
            return new ChangeResponse(false, null, t.getMessage());
        }
    }

    /**
     * It returns the new list of pages of the image
     * @param id
     * @param x
     * @return
     * @throws IM3WSException
     */
    /*@GetMapping(path = {"pageSplit/{id}/{x}"})
    public List<Page> pageSplit(@PathVariable("id") Long id, @PathVariable("x") Double x) throws IM3WSException {
        Optional<Image> image = imageRepository.findById(id);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find an image with id " + id);
        }
        return documentAnalysisModel.pageSplit(image.get(), x.intValue());
    }*/

    /**
     * It returns the new list of pages of the image
     * @param id
     * @param x
     * @return
     * @throws IM3WSException
     */
   /* @GetMapping(path = {"regionSplit/{id}/{x}/{y}"})
    public List<Page> regionSplit(@PathVariable("id") Long id, @PathVariable("x") Double x, @PathVariable("y") Double y) throws IM3WSException {
        Optional<Image> image = imageRepository.findById(id);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find an image with id " + id);
        }
        return documentAnalysisModel.regionSplit(image.get(), x.intValue(), y.intValue());
    }


    @GetMapping(path = {"documentAnalysisClear/{id}"})
    public List<Page>  documentAnalysisClear(@PathVariable("id") Long id) throws IM3WSException {
        Optional<Image> image = imageRepository.findById(id);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find an image with id " + id);
        }
        return documentAnalysisModel.leaveJustOnePageAndRegion(image.get());
    }*/


}
