package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.*;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author drizo
 */
@RequestMapping("parts")
@RestController
public class PartsController extends MuRETBaseController {
    private final ProjectRepository projectRepository;
    private final PartRepository partRepository;
    PartsModel partsModel;

    @Autowired
    public PartsController(MURETConfiguration muretConfiguration, ProjectRepository projectRepository, ImageRepository imageRepository, PageRepository pageRepository, RegionRepository regionRepository, SymbolRepository symbolRepository, PartRepository partRepository) {
        super(muretConfiguration, imageRepository, pageRepository, regionRepository, symbolRepository);
        partsModel = new PartsModel();
        this.projectRepository = projectRepository;
        this.partRepository = partRepository;
    }

    @GetMapping(path = {"uses/{projectID}"})
    @Transactional
    public UsesOfParts getUsesOfParts(@PathVariable(name="projectID") Integer projectID) throws IM3WSException {
        UsesOfParts usesOfParts = new UsesOfParts();

        Optional<Project> project = projectRepository.findById(projectID);
        if (!project.isPresent()) {
            throw new IM3WSException("Cannot find a project with id " + project);
        }

        for (Part part: project.get().getParts()) {
            Long partID = part.getId();
            usesOfParts.add(part,
                    partRepository.getImages(partID),
                    partRepository.getPages(partID),
                    partRepository.getRegions(partID),
                    partRepository.getSymbols(partID));
        }
        return usesOfParts;
    }

    @GetMapping(path = {"project/{projectID}"})
    @Transactional
    public List<Part> getProjectParts(@PathVariable(name="projectID") Integer projectID) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Getting parts of project with id {0}", projectID);
        /*Optional<Project> project = projectRepository.findById(projectID);
        if (!project.isPresent()) {
            throw new IM3WSException("Cannot find a project with ID = " + projectID);
        }*
        List<Part> result = project.get().getParts();*/
        List<Part> result = partRepository.findByProjectId(projectID);
        return result;
    }

    @GetMapping(path = {"imageProjectParts/{imageID}"})
    @Transactional
    public List<Part> getImageProjectParts(@PathVariable(name="imageID") Long imageID) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Getting parts of image with id {0}", imageID);
        Optional<Image> image = imageRepository.findById(imageID);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find an image with ID = " + imageID);
        }
        List<Part> result = partRepository.findByProjectId(image.get().getProject().getId());
        return result;
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
            case symbol:
                return partsModel.findPart(getSymbol(targetID));
            default:
                throw new IM3WSException("Invalid assignable to part type: " + partAssignedToType);
        }
    }

    Part getPart(Long partID) throws IM3WSException {
        Optional<Part> part = partRepository.findById(partID);
        if (!part.isPresent()) {
            throw new IM3WSException("Cannot find a part with id " + partID);
        }
        return part.get();
    }

    @PutMapping(path = {"set/{partAssignedToType}/{targetID}/{partID}"})
    @Transactional
    public Part setPart(@PathVariable(name="partAssignedToType") PartAssignedToType partAssignedToType, @PathVariable(name="targetID") Long targetID, @PathVariable(name="partID") Long partID) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Setting part name of type {0} with id {1} to part with ID {2}", new Object[] {partAssignedToType, targetID, partID});
        Part part = getPart(partID);

        switch (partAssignedToType) {
            case image:
                Image image = getImage(targetID);
                image.setPart(part);
                imageRepository.save(image);
                return part;
            case page:
                Page page = getPage(targetID);
                page.setPart(part);
                pageRepository.save(page);
                return part;
            case region:
                Region region = getRegion(targetID);
                region.setPart(part);
                regionRepository.save(region);
                return part;
            case symbol:
                Symbol symbol = getSymbol(targetID);
                symbol.setPart(part);
                symbolRepository.save(symbol);
                return part;
            default:
                throw new IM3WSException("Invalid assignable to part type: " + partAssignedToType);
        }
    }

    private Part createPart(Project project, String partName) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Creating part {0} for project {1}", new Object[] {project.getId(), partName});
        Part part = new Part();
        part.setName(partName);
        part.setProject(project);
        part = partRepository.save(part);

        return part;
    }

    @PutMapping(path = {"create/{projectID}/{partName}"})
    @Transactional
    public Part createPart(@PathVariable(name="projectID") Integer projectID, @PathVariable(name="partName") String partName) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Creating part {0} for project {1}", new Object[] {projectID, partName});

        Optional<Project> project = projectRepository.findById(projectID);
        if (!project.isPresent()) {
            throw new IM3WSException("Cannot find project with id " + projectID);
        }

        return createPart(project.get(), partName);
    }

    @PutMapping(path = {"create/{partAssignedToType}/{targetID}/{partName}"})
    @Transactional
    public Part createPart(@PathVariable(name="partAssignedToType") PartAssignedToType partAssignedToType, @PathVariable(name="targetID") Long targetID, @PathVariable(name="partName") String partName) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Setting part name of type {0} with id {1} to part with ID {2}", new Object[] {partAssignedToType, targetID, partName});

        Part part = null;

        switch (partAssignedToType) {
            case image:
                Image image = getImage(targetID);
                part = createPart(image.getProject(), partName);
                image.setPart(part);
                imageRepository.save(image);
                break;
            case page:
                Page page = getPage(targetID);
                part = createPart(page.getImage().getProject(), partName);
                page.setPart(part);
                pageRepository.save(page);
                break;
            case region:
                Region region = getRegion(targetID);
                part = createPart(region.getPage().getImage().getProject(), partName);
                part.setProject(region.getPage().getImage().getProject());
                region.setPart(part);
                regionRepository.save(region);
                break;
            case symbol:
                Symbol symbol = getSymbol(targetID);
                part = createPart(symbol.getRegion().getPage().getImage().getProject(), partName);
                symbol.setPart(part);
                symbolRepository.save(symbol);
                break;
            default:
                throw new IM3WSException("Invalid assignable to part type: " + partAssignedToType);
        }
        return part;
    }

    @PutMapping(path = {"clear/{partAssignedToType}/{targetID}"})
    @Transactional
    public IAssignableToPart clearPart(@PathVariable(name="partAssignedToType") PartAssignedToType partAssignedToType, @PathVariable(name="targetID") Long targetID) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Clearing part of type {0} with id {1} to part", new Object[] {partAssignedToType, targetID});
        switch (partAssignedToType) {
            case image:
                Image image = getImage(targetID);
                image.setPart(null);
                imageRepository.save(image);
                return image;
            case page:
                Page page = getPage(targetID);
                page.setPart(null);
                pageRepository.save(page);
                return page;
            case region:
                Region region = getRegion(targetID);
                region.setPart(null);
                regionRepository.save(region);
                return region;
            case symbol:
                Symbol symbol = getSymbol(targetID);
                symbol.setPart(null);
                symbolRepository.save(symbol);
                return symbol;
            default:
                throw new IM3WSException("Invalid assignable to part type: " + partAssignedToType);
        }
    }

    @PutMapping("rename/{partID}/{newName}")
    public Part rename(@PathVariable Long partID, @PathVariable String newName) throws IM3WSException {
        Optional<Part> part = partRepository.findById(partID);
        if (!part.isPresent()) {
            throw new IM3WSException("Cannot find a part with id " + partID);
        }

        part.get().setName(newName);
        return partRepository.save(part.get());
    }

    @DeleteMapping(path = {"delete/{partID}"})
    public long deleteSymbol(@PathVariable("partID") long partID) throws IM3WSException {
        Optional<Part> part = partRepository.findById(partID);
        if (!part.isPresent()) {
            throw new IM3WSException("Cannot find a part with id " + partID);
        }

        partRepository.delete(part.get());
        return partID;
    }

}
