package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.*;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author drizo
 */
@RequestMapping("parts")
@RestController
public class PartsController extends MuRETBaseController {
    private final PartRepository partRepository;
    PartsModel partsModel;

    @Autowired
    public PartsController(MURETConfiguration muretConfiguration, ImageRepository imageRepository, PageRepository pageRepository, RegionRepository regionRepository, SymbolRepository symbolRepository, PartRepository partRepository) {
        super(muretConfiguration, imageRepository, pageRepository, regionRepository, symbolRepository);
        partsModel = new PartsModel();
        this.partRepository = partRepository;
    }


    @GetMapping(path = {"get/{partAssignedToType}/{targetID}"})
    @Transactional
    public Part getPart(@PathVariable(name="partAssignedToType") PartAssignedToType partAssignedToType, @PathVariable(name="targetID") Long targetID) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Getting part name of type {0} with id {1}", new Object[] {partAssignedToType, targetID});

        IAssignableToPart assignableToPart;
        switch (partAssignedToType) {
            case image:
                return partsModel.findPart(getImage(targetID));
            case page:
                return partsModel.findPart(getPage(targetID));
            case region:
                return partsModel.findPart(getRegion(targetID));
            default:
                throw new IM3WSException("Invalid assignable to part type: " + partAssignedToType);
        }
    }

    Part getPart(Integer partID) throws IM3WSException {
        Optional<Part> part = partRepository.findById(partID);
        if (!part.isPresent()) {
            throw new IM3WSException("Cannot find a part with id " + partID);
        }
        return part.get();
    }

    @PutMapping(path = {"set/{partAssignedToType}/{targetID}/{partID}"})
    @Transactional
    public IAssignableToPart setPart(@PathVariable(name="partAssignedToType") PartAssignedToType partAssignedToType, @PathVariable(name="targetID") Long targetID, @PathVariable(name="partID") Integer partID) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Setting part name of type {0} with id {1} to part with ID {2}", new Object[] {partAssignedToType, targetID, partID});
        Part part = getPart(partID);

        switch (partAssignedToType) {
            case image:
                Image image = getImage(targetID);
                image.setPart(part);
                imageRepository.save(image);
                return image;
            case page:
                Page page = getPage(targetID);
                page.setPart(part);
                pageRepository.save(page);
                return page;
            case region:
                Region region = getRegion(targetID);
                region.setPart(part);
                regionRepository.save(region);
                return region;
            default:
                throw new IM3WSException("Invalid assignable to part type: " + partAssignedToType);
        }
    }
}
