package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Notation;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Renderer;
import es.ua.dlsi.grfia.im3ws.muret.entity.Part;
import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.model.ProjectModel;
import es.ua.dlsi.grfia.im3ws.muret.model.SemanticRepresentationModel;
import es.ua.dlsi.grfia.im3ws.muret.repository.ImageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.PageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author drizo
 */
@RequestMapping("semantic")
@RestController
public class SemanticRepresentationController {
    private final ProjectModel projectModel;
    private final RegionRepository regionRepository;
    private final PageRepository pageRepository;
    private final ImageRepository imageRepository;

    SemanticRepresentationModel semanticRepresentationModel;

    @Autowired
    public SemanticRepresentationController(ProjectModel projectModel, ImageRepository imageRepository, PageRepository pageRepository, RegionRepository regionRepository) {
        this.projectModel = projectModel;
        this.semanticRepresentationModel = new SemanticRepresentationModel(projectModel);
        this.imageRepository = imageRepository;
        this.pageRepository = pageRepository;
        this.regionRepository = regionRepository;
    }

    private Part findPart(Region region) {
        if (region.getPart() == null) {
            if (region.getPage().getPart() == null) {
                return region.getPage().getImage().getPart();
            } else {
                return region.getPage().getPart();
            }
        } else {
            return region.getPart();
        }
    }

    /**
     * @param staffID
     * @throws IM3WSException
     */
    @GetMapping(path = {"haspart/{staffID}"})
    @Transactional
    public Part getPartName(@PathVariable(name="staffID") Long staffID) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Converting semantic staff frin agnostic {0}", staffID);

        Region region = getRegion(staffID);
        return findPart(region);
    }

    /**
     * @param staffID
     * @throws IM3WSException
     */
    @GetMapping(path = {"agnostic2semantic/{staffID}/{mensustriche}/{renderer}"})
    @Transactional
    public Notation agnostic2semantic(@PathVariable(name="staffID") Long staffID, @PathVariable(name="mensustriche") boolean mensustriche, @PathVariable(name="renderer") Renderer renderer) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Converting semantic staff frin agnostic {0}", staffID);

        Region region = getRegion(staffID);
        Project project = region.getPage().getImage().getProject();
        Part part = findPart(region);
        if (part == null) {
            throw new IM3WSException("The staff has not an associated part yet");
        }
        try {
            Notation result = semanticRepresentationModel.computeSemanticFromAgnostic(project, part.getName(), region, mensustriche, renderer);
            return result;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot convert to semantic", e);
            throw new IM3WSException(e);
        }
    }

    private Region getRegion(Long staffID) throws IM3WSException {
        Objects.requireNonNull(staffID, "staffID cannot be null");

        Optional<Region> region = regionRepository.findById(staffID);
        if (!region.isPresent()) {
            throw new IM3WSException("Cannot find region with ID = " + staffID);
        }

        return region.get();
    }

    /**
     * @param staffID
     * @throws IM3WSException
     */
    @GetMapping(path = {"notation/{staffID}/{mensustriche}/{renderer}"})
    @Transactional
    public Notation getNotation(@PathVariable(name="staffID") Long staffID, @PathVariable(name="mensustriche") boolean mensustriche, @PathVariable(name="renderer") Renderer renderer) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Getting statff notation {0}", staffID);

        Region region = getRegion(staffID);
        Project project = region.getPage().getImage().getProject();
        Part part = findPart(region);
        if (part == null) {
            throw new IM3WSException("The staff has not an associated part yet");
        }

        try {
            Notation result = semanticRepresentationModel.getNotation(project, part.getName(), region, mensustriche, renderer);
            return result;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot get notation", e);
            throw new IM3WSException(e);
        }
    }

}
