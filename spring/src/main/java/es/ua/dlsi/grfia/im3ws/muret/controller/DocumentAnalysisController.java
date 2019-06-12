package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.PageCreation;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.RegionCreation;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.DocumentAnalysisModel;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author drizo
 */
@RequestMapping("documentanalysis")
@RestController
public class DocumentAnalysisController extends MuRETBaseController {

    private final RegionTypeRepository regionTypeRepository;

    private final DocumentAnalysisModel documentAnalysisModel;

    @Autowired
    public DocumentAnalysisController(MURETConfiguration muretConfiguration, ImageRepository imageRepository, PageRepository pageRepository, RegionRepository regionRepository, SymbolRepository symbolRepository, RegionTypeRepository regionTypeRepository, DocumentAnalysisModel documentAnalysisModel) {
        super(muretConfiguration, imageRepository, pageRepository, regionRepository, symbolRepository);
        this.regionTypeRepository = regionTypeRepository;
        this.documentAnalysisModel = documentAnalysisModel;
    }

    @PutMapping(path = {"pageBoundingBoxUpdate"})
    public Page pageBoundingBoxUpdate(@RequestBody BoundingBox boundingBox) throws IM3WSException {
        Page page = getPage(boundingBox.getId());
        page.setBoundingBox(boundingBox);
        pageRepository.save(page);
        return page;
    }

    @PutMapping(path = {"regionUpdate"})
    public Region regionUpdate(@RequestBody Region region) throws IM3WSException {
        Region persistentRegion = getRegion(region.getId());

        if (region.getBoundingBox() != null) {
            persistentRegion.setBoundingBox(region.getBoundingBox());
        }
        if (region.getRegionType() != null && !Objects.equals(persistentRegion.getRegionType(), region.getRegionType())) {
            Optional<RegionType> persistentRegionType = regionTypeRepository.findById(region.getRegionType().getId());
            if (!persistentRegionType.isPresent()) {
                throw new IM3WSException("Cannot find a region type with id " + region.getRegionType().getId());
            }

            persistentRegion.setRegionType(persistentRegionType.get());
        }
        regionRepository.save(persistentRegion);
        return persistentRegion;
    }

    @Transactional // keep session open - avoid "failed to lazily initialize a collection" error
    @DeleteMapping(path = {"clear/{imageID}"})
    public List<Page> clear(@PathVariable("imageID") long imageID) throws IM3WSException {
        Image persistentImage = getImage(imageID);
        List<Page> createdPages = this.documentAnalysisModel.leaveJustOnePageAndRegion(persistentImage);
        return createdPages;
    }

    /**
     * Returns the whole list of pages because some regions may have changed from page
     * @param pageCreation
     * @return
     * @throws IM3WSException
     */
    @PostMapping(path = {"createPage"})
    public List<Page> createPage(@RequestBody PageCreation pageCreation) throws IM3WSException {
        List<Page> createdPages = this.documentAnalysisModel.createPage(pageCreation.getImageID(), pageCreation.getBoundingBox());
        return createdPages;
    }

    /**
     * Returns the whole list of pages because we don't known a priori where the region is to be created
     * @param regionCreation
     * @return
     * @throws IM3WSException
     */
    @PostMapping(path = {"createRegion"})
    public List<Page> createRegion(@RequestBody RegionCreation regionCreation) throws IM3WSException {
        List<Page> pages = this.documentAnalysisModel.createRegion(regionCreation.getImageID(), regionCreation.getRegionTypeID(), regionCreation.getBoundingBox());
        return pages;
    }

    @DeleteMapping(path = {"deletePage/{pageID}"})
    public long deletePage(@PathVariable("pageID") long pageID) throws IM3WSException {
        return this.documentAnalysisModel.deletePage(pageID);
    }

    @DeleteMapping(path = {"deleteRegion/{regionID}"})
    public long deleteRegion(@PathVariable("regionID") long regionID) throws IM3WSException {
        return this.documentAnalysisModel.deleteRegion(regionID);
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
