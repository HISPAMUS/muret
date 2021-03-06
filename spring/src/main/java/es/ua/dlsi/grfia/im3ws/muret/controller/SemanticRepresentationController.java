package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Notation;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.Renderer;
import es.ua.dlsi.grfia.im3ws.muret.entity.Document;
import es.ua.dlsi.grfia.im3ws.muret.entity.Part;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.model.NotationModel;
import es.ua.dlsi.grfia.im3ws.muret.model.DocumentModel;
import es.ua.dlsi.grfia.im3ws.muret.model.PartsModel;
import es.ua.dlsi.grfia.im3ws.muret.model.SemanticRepresentationModel;
import es.ua.dlsi.grfia.im3ws.muret.repository.ImageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.PageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.SymbolRepository;
import es.ua.dlsi.im3.core.IM3Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.logging.Level;
import java.util.logging.Logger;
// !!! Important: no controller should throw any exception

/**
 * @author drizo
 */
@RequestMapping("semantic")
@RestController
public class SemanticRepresentationController extends MuRETBaseController {
    private final DocumentModel documentModel;
    SemanticRepresentationModel semanticRepresentationModel;
    PartsModel partsModel;
    private final NotationModel notationModel;

    @Autowired
    public SemanticRepresentationController(MURETConfiguration muretConfiguration, ImageRepository imageRepository, PageRepository pageRepository, RegionRepository regionRepository, SymbolRepository symbolRepository, DocumentModel documentModel) {
        super(muretConfiguration, imageRepository, pageRepository, regionRepository, symbolRepository);
        this.documentModel = documentModel;
        this.semanticRepresentationModel = new SemanticRepresentationModel(documentModel, regionRepository);
        this.partsModel = new PartsModel();
        this.notationModel = new NotationModel();
    }

    /**
     * @param staffID
     * @throws IM3WSException
     */
    @GetMapping(path = {"agnostic2semantic/{staffID}/{mensurstrich}/{renderer}"})
    @Transactional
    public Notation agnostic2semantic(@PathVariable(name="staffID") Long staffID, @PathVariable(name="mensurstrich") boolean mensurstrich, @PathVariable(name="renderer") Renderer renderer)  {
        try {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Converting semantic staff frin agnostic {0}", staffID);

            Region region = getRegion(staffID);
            Document document = region.getPage().getImage().getDocument();
            //TODO Ahora sólo lo guardo en la región
        /*Part part = partsModel.findPart(region);
        if (part == null) {
            throw new IM3WSException("The staff has not an associated part yet");
        }*/
            Part part = null;
            String partName = "";
            Notation result = semanticRepresentationModel.computeAndSaveSemanticFromAgnostic(document, partName, region, mensurstrich, renderer);
            return result;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot convert agnostic to semantic", e);
        }
    }

    /**
     * @param staffID
     * @throws IM3WSException
     */
    @GetMapping(path = {"notation/{staffID}/{mensustriche}/{renderer}"})
    @Transactional
    public Notation getNotation(@PathVariable(name="staffID") Long staffID, @PathVariable(name="mensustriche") boolean mensustriche, @PathVariable(name="renderer") Renderer renderer)  {
        try {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Getting staff notation for region ID {0}", staffID);

            Region region = getRegion(staffID);
            Document document = region.getPage().getImage().getDocument();
            //TODO Ahora sólo lo guardo en la región
        /*Part part = partsModel.findPart(region);
        if (part == null) {
            throw new IM3WSException("The staff has not an associated part yet");
        }*/
            Part part = null;
            String partName = "";

            Notation result = notationModel.getNotation(document, partName, region, mensustriche, renderer);
            return result;
        } catch (IM3WSException | IM3Exception e) {
            throw ControllerUtils.createServerError(this, "Cannot get notation", e);
        }
    }

    @PutMapping(path = {"semanticEncoding/{staffID}/{mensustriche}/{renderer}"})
    @Transactional
    public Notation sendSemanticEncoding(@PathVariable(name="staffID") Long staffID, @PathVariable(name="mensustriche") boolean mensustriche, @PathVariable(name="renderer") Renderer renderer, @RequestBody String semanticEncoding)  {
        try {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Sending semantic encoding for region ID {0}", staffID);
            Region region = getRegion(staffID);

            Document document = region.getPage().getImage().getDocument();

            //TODO Ahora sólo lo guardo en la región
        /*
        Part part = partsModel.findPart(region);
        if (part == null) {
            throw new IM3WSException("The staff has not an associated part yet");
        }*/

            Part part = null;
            String partName = "";

            Notation result = semanticRepresentationModel.sendSemanticEncoding(document, partName, region, mensustriche, renderer, semanticEncoding);
            return result;
        } catch (IM3WSException | IM3Exception e) {
            throw ControllerUtils.createServerError(this, "Cannot send semantic encoding", e);
        }
    }

    @DeleteMapping(path = {"clearSemanticEncoding/{staffID}"})
    @Transactional
    public void clearSemanticEncoding(@PathVariable(name="staffID") Long staffID)  {
        try {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Clearing semantic encoding for region ID {0}", staffID);
            Region region = getRegion(staffID);
            region.setSemanticEncoding(null);
            regionRepository.save(region);
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot clear semantic encoding", e);
        }
    }
}
