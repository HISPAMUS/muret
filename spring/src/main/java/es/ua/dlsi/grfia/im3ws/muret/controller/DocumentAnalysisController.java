package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.entity.Page;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.entity.RegionType;
import es.ua.dlsi.grfia.im3ws.muret.model.DocumentAnalysisModel;
import es.ua.dlsi.grfia.im3ws.muret.repository.ImageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.PageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    /**
     * It returns the new list of pages of the image
     * @param id
     * @param x
     * @return
     * @throws IM3WSException
     */
    @GetMapping(path = {"pageSplit/{id}/{x}"})
    public List<Page> pageSplit(@PathVariable("id") Long id, @PathVariable("x") Double x) throws IM3WSException {
        Optional<Image> image = imageRepository.findById(id);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find an image with id " + id);
        }
        return documentAnalysisModel.pageSplit(image.get(), x.intValue());
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
    }

    @GetMapping(path = {"pageUpdate/{id}/{fromX}/{fromY}/{toX}/{toY}"})
    public Page pageUpdate(@PathVariable("id") Long id,
                           @PathVariable("fromX") Double fromX,
                           @PathVariable("fromY") Double fromY,
                           @PathVariable("toX") Double toX,
                           @PathVariable("toY") Double toY) throws IM3WSException {
        Optional<Page> page = pageRepository.findById(id);
        if (!page.isPresent()) {
            throw new IM3WSException("Cannot find a page with id " + id);
        }
        page.get().getBoundingBox().setFromX(fromX.intValue());
        page.get().getBoundingBox().setFromY(fromY.intValue());
        page.get().getBoundingBox().setToX(toX.intValue());
        page.get().getBoundingBox().setToY(toY.intValue());
        return pageRepository.save(page.get());
    }

    @GetMapping(path = {"regionUpdate/{id}/{fromX}/{fromY}/{toX}/{toY}"})
    public Region regionUpdate(@PathVariable("id") Long id,
                               @PathVariable("fromX") Double fromX,
                               @PathVariable("fromY") Double fromY,
                               @PathVariable("toX") Double toX,
                               @PathVariable("toY") Double toY) throws IM3WSException {
        Optional<Region> region = regionRepository.findById(id);
        if (!region.isPresent()) {
            throw new IM3WSException("Cannot find a region with id " + id);
        }
        region.get().getBoundingBox().setFromX(fromX.intValue());
        region.get().getBoundingBox().setFromY(fromY.intValue());
        region.get().getBoundingBox().setToX(toX.intValue());
        region.get().getBoundingBox().setToY(toY.intValue());
        return regionRepository.save(region.get());
    }

    @GetMapping(path = {"regionUpdateType/{id}/{regionTypeId}"})
    public Region regionUpdate(@PathVariable("id") Long id,
                               @PathVariable("regionTypeId") Integer regionTypeId) throws IM3WSException {
        Optional<Region> region = regionRepository.findById(id);
        if (!region.isPresent()) {
            throw new IM3WSException("Cannot find a region with id " + id);
        }
        Optional<RegionType> regionType = regionTypeRepository.findById(regionTypeId);
        if (!regionType.isPresent()) {
            throw new IM3WSException("Cannot find a region type with id " + regionTypeId);
        }

        region.get().setRegionType(regionType.get());
        return regionRepository.save(region.get());
    }

}
