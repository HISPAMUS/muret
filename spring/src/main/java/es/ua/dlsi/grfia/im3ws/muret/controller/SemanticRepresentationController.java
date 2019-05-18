package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
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
import es.ua.dlsi.grfia.im3ws.muret.repository.SymbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author drizo
 */
@RequestMapping("semantic")
@RestController
public class SemanticRepresentationController extends MuRETBaseController {
    private final ProjectModel projectModel;
    SemanticRepresentationModel semanticRepresentationModel;
    PartsModel partsModel;

    @Autowired
    public SemanticRepresentationController(MURETConfiguration muretConfiguration, ImageRepository imageRepository, PageRepository pageRepository, RegionRepository regionRepository, SymbolRepository symbolRepository, ProjectModel projectModel) {
        super(muretConfiguration, imageRepository, pageRepository, regionRepository, symbolRepository);
        this.projectModel = projectModel;
        this.semanticRepresentationModel = new SemanticRepresentationModel(projectModel);
        this.partsModel = new PartsModel();
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
        Part part = partsModel.findPart(region);
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

    /**
     * @param staffID
     * @throws IM3WSException
     */
    @GetMapping(path = {"notation/{staffID}/{mensustriche}/{renderer}"})
    @Transactional
    public Notation getNotation(@PathVariable(name="staffID") Long staffID, @PathVariable(name="mensustriche") boolean mensustriche, @PathVariable(name="renderer") Renderer renderer) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Getting staff notation for region ID {0}", staffID);

        Region region = getRegion(staffID);
        Project project = region.getPage().getImage().getProject();
        Part part = partsModel.findPart(region);
        if (part == null) {
            throw new IM3WSException("The staff has not an associated part yet");
        }

        Notation result = semanticRepresentationModel.getNotation(project, part.getName(), region, mensustriche, renderer);
        return result;
    }

    @PutMapping(path = {"semanticEncoding/{staffID}/{mensustriche}/{renderer}"})
    @Transactional
    public Notation sendSemanticEncoding(@PathVariable(name="staffID") Long staffID, @PathVariable(name="mensustriche") boolean mensustriche, @PathVariable(name="renderer") Renderer renderer, @RequestBody String semanticEncoding) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Sending semantic encoding for region ID {0}", staffID);

        Region region = getRegion(staffID);
        Project project = region.getPage().getImage().getProject();
        Part part = partsModel.findPart(region);
        if (part == null) {
            throw new IM3WSException("The staff has not an associated part yet");
        }

        Notation result = semanticRepresentationModel.sendSemanticEncoding(project, part.getName(), region, mensustriche, renderer, semanticEncoding);
        return result;
    }

}
