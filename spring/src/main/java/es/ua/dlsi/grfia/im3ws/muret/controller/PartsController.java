package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.*;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.ImageRecognitionModel;
import es.ua.dlsi.grfia.im3ws.muret.model.PartsModel;
import es.ua.dlsi.grfia.im3ws.muret.model.actionlogs.ActionLogsParts;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
// !!! Important: no controller should throw any exception

/**
 * @author drizo
 */
@RequestMapping("parts")
@RestController
public class PartsController extends MuRETBaseController {
    private final DocumentRepository documentRepository;
    private final PartRepository partRepository;
    PartsModel partsModel;
    ActionLogsParts actionLogsParts;

    @Autowired
    public PartsController(MURETConfiguration muretConfiguration, DocumentRepository documentRepository, ImageRepository imageRepository, PageRepository pageRepository, RegionRepository regionRepository, SymbolRepository symbolRepository, PartRepository partRepository, ActionLogsParts actionLogsParts) {
        super(muretConfiguration, imageRepository, pageRepository, regionRepository, symbolRepository);
        partsModel = new PartsModel();
        this.documentRepository = documentRepository;
        this.partRepository = partRepository;
        this.actionLogsParts = actionLogsParts;
    }

    @PutMapping(path = {"linkToPart"})
    @Transactional
    public Set<Page> linkToPart(@RequestBody PartLinking partLinking) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Linking to part: {0}", partLinking);

        Image image = getImage(partLinking.getImageID());

        Part part = getPart(partLinking.getPartID());

        linkToPart(partLinking, part);
        actionLogsParts.logLinkPart(image);
        return new ImageRecognitionModel().getPagesRegionsSymbols(image);
    }


    // This could be better done with a saveAll
    private void linkToPart(PartLinking partLinking, Part part) throws IM3WSException {
        for (Long id: partLinking.getToIDs().getValues()) {
            switch (partLinking.getPartAssignedTo()) {
                case image:
                    Image image = getImage(id);
                    image.setPart(part);
                    imageRepository.save(image);
                    break;
                case page:
                    Page page = getPage(id);
                    page.setPart(part);
                    pageRepository.save(page);
                    break;
                case region:
                    Region region = getRegion(id);
                    region.setPart(part);
                    regionRepository.save(region);
                    break;
                case symbol:
                    Symbol symbol = getSymbol(id);
                    symbol.setPart(part);
                    symbolRepository.save(symbol);
                    break;
                default:
                    throw new IM3WSException("Invalid assignable to part type: " + partLinking.getPartAssignedTo());
            }
        }
    }

    @PostMapping(path = {"linkToNewPart"})
    @Transactional
    public PagesRegionsSymbolsAndNewPart linkToNewPart(@RequestBody PartLinking partLinking) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Linking to new part: {0}", partLinking);

        Optional<Document> document = documentRepository.findById(partLinking.getDocumentID());
        if (!document.isPresent()) {
            throw new IM3WSException("Cannot find a document with id " + document);
        }

        Image image = getImage(partLinking.getImageID());

        Part part = new Part();
        part.setDocument(document.get());
        part.setOrdering(document.get().computeNextPartOrdering());
        part.setName(partLinking.getPartName());
        Part savedPart = partRepository.save(part);
        partLinking.setPartID(savedPart.getId());
        linkToPart(partLinking, part);
        PagesRegionsSymbolsAndNewPart pagesRegionsSymbolsAndNewPart = new PagesRegionsSymbolsAndNewPart();
        pagesRegionsSymbolsAndNewPart.setPart(savedPart);
        pagesRegionsSymbolsAndNewPart.setPagesRegionsSymbols(new ImageRecognitionModel().getPagesRegionsSymbols(image));
        actionLogsParts.logLinkPart(image);
        return pagesRegionsSymbolsAndNewPart;
    }

    @PutMapping(path = {"unlinkPart"})
    @Transactional
    // This could be better done with a saveAll
    public Set<Page> unlinkPart(@RequestBody PartLinking partLinking) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Unlinking part: {0}", partLinking);

        Image image = getImage(partLinking.getImageID());

        for (Long id: partLinking.getToIDs().getValues()) {
            switch (partLinking.getPartAssignedTo()) {
                case image:
                    // we already have it Image image = getImage(id);
                    image.setPart(null);
                    imageRepository.save(image);
                    break;
                case page:
                    Page page = getPage(id);
                    page.setPart(null);
                    pageRepository.save(page);
                    break;
                case region:
                    Region region = getRegion(id);
                    region.setPart(null);
                    regionRepository.save(region);
                    break;
                case symbol:
                    Symbol symbol = getSymbol(id);
                    symbol.setPart(null);
                    symbolRepository.save(symbol);
                    break;
                default:
                    throw new IM3WSException("Invalid assignable to part type: " + partLinking.getPartAssignedTo());
            }
        }
        actionLogsParts.logLinkPart(image);
        return new ImageRecognitionModel().getPagesRegionsSymbols(image);
    }

    @PutMapping(path = {"linkImageToPart/{imageID}/{partID}"})
    @Transactional
    public Part linkImageToPart(@PathVariable Long imageID, @PathVariable Long partID) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Linking image {0} to part {1}", new Object[]{imageID, partID});

        Image image = getImage(imageID);
        Part part = getPart(partID);
        image.setPart(part);
        imageRepository.save(image);
        actionLogsParts.logLinkPart(image);
        return part;
    }

    @PostMapping(path = {"linkImageToNewPart/{imageID}"})
    @Transactional
    public Part linkImageToNewPart(@PathVariable Long imageID, @RequestBody String partName) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Linking image {0} to new part with name {1}", new Object[]{imageID, partName});

        Image image = getImage(imageID);
        Document document = image.computeDocument();
        Part part = new Part();
        part.setDocument(document);
        part.setName(partName);
        part.setOrdering(document.computeNextPartOrdering());
        Part savedPart = partRepository.save(part);
        image.setPart(savedPart);
        imageRepository.save(image);
        actionLogsParts.logLinkPart(image);
        return savedPart;
    }
    @PutMapping(path = {"unlinkImageFromPart/{imageID}"})
    @Transactional
    public void linkImageToPart(@PathVariable Long imageID) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Unlinking image {0} from part", imageID);

        Image image = getImage(imageID);
        image.setPart(null);
        imageRepository.save(image);
        actionLogsParts.logLinkPart(image);
    }

    @PutMapping("rename/{partID}/{newName}")
    public Part rename(@PathVariable Long partID, @PathVariable String newName) {
        try {
            Optional<Part> part = partRepository.findById(partID);
            if (!part.isPresent()) {
                throw new IM3WSException("Cannot find a part with id " + partID);
            }

            part.get().setName(newName);
            return partRepository.save(part.get());
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot rename part", e);
        }
    }

    // revisado hasta aquí
    @GetMapping(path = {"uses/{documentID}"})
    @Transactional(readOnly = true)
    public UsesOfParts getUsesOfParts(@PathVariable(name="documentID") Integer documentID){
        try {
            UsesOfParts usesOfParts = new UsesOfParts();

            Optional<Document> document = documentRepository.findById(documentID);
            if (!document.isPresent()) {
                throw new IM3WSException("Cannot find a document with id " + document);
            }

            for (Part part: document.get().getParts()) {
                Long partID = part.getId();
                usesOfParts.add(part,
                        partRepository.getImages(partID),
                        partRepository.getPages(partID),
                        partRepository.getRegions(partID),
                        partRepository.getSymbols(partID));
            }
            return usesOfParts;
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot get uses of parts", e);
        }
    }

    /*@GetMapping(path = {"document/{documentID}"})
    @Transactional
    public List<Part> getDocumentParts(@PathVariable(name="documentID") Integer documentID) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Getting parts of document with id {0}", documentID);
        List<Part> result = partRepository.findByDocumentId(documentID);
        return result;
    }

    @GetMapping(path = {"imageDocumentParts/{imageID}"})
    @Transactional
    public List<Part> getImageDocumentParts(@PathVariable(name="imageID") Long imageID) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Getting parts of image with id {0}", imageID);
        Optional<Image> image = imageRepository.findById(imageID);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find an image with ID = " + imageID);
        }
        List<Part> result = partRepository.findByDocumentId(image.get().getDocument().getId());
        return result;
    }*/

    @GetMapping(path = {"get/{partAssignedToType}/{targetID}"})
    @Transactional
    public Part getPart(@PathVariable(name="partAssignedToType") PartAssignedToType partAssignedToType, @PathVariable(name="targetID") Long targetID)  {
        try {
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
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot get assigned parts", e);
        }
    }

    Part getPart(Long partID) throws IM3WSException {
        Optional<Part> part = partRepository.findById(partID);
        if (!part.isPresent()) {
            throw new IM3WSException("Cannot find a part with id " + partID);
        }
        return part.get();
    }

    /*@PutMapping(path = {"set/{partAssignedToType}/{targetID}/{partID}"})
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
    }*/

    private Part createPart(Document document, String partName) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Creating part {0} for document {1}", new Object[] {document.getId(), partName});
        Part part = new Part();
        part.setName(partName);
        part.setDocument(document);
        part = partRepository.save(part);

        return part;
    }

    @PutMapping(path = {"create/{documentID}/{partName}"})
    @Transactional
    public Part createPart(@PathVariable(name="documentID") Integer documentID, @PathVariable(name="partName") String partName)  {
        try {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Creating part {0} for document {1}", new Object[] {documentID, partName});

            Optional<Document> document = documentRepository.findById(documentID);
            if (!document.isPresent()) {
                throw new IM3WSException("Cannot find document with id " + documentID);
            }

            return createPart(document.get(), partName);
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot create part", e);
        }
    }

    @PutMapping(path = {"create/{partAssignedToType}/{targetID}/{partName}"})
    @Transactional
    public PartUse createPart(@PathVariable(name="partAssignedToType") PartAssignedToType partAssignedToType, @PathVariable(name="targetID") Long targetID, @PathVariable(name="partName") String partName)  {
        try {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Setting part name of type {0} with id {1} to part with ID {2}", new Object[] {partAssignedToType, targetID, partName});

            Part part = null;
            Long imageID = null;
            Long ID = null;

            switch (partAssignedToType) {
                case image:
                    Image image = getImage(targetID);
                    part = createPart(image.computeDocument(), partName);
                    image.setPart(part);
                    imageRepository.save(image);
                    imageID = ID = image.getId();
                    break;
                case page:
                    Page page = getPage(targetID);
                    part = createPart(page.getImage().computeDocument(), partName);
                    page.setPart(part);
                    pageRepository.save(page);
                    imageID = page.getImage().getId();
                    ID = page.getId();
                    break;
                case region:
                    Region region = getRegion(targetID);
                    part = createPart(region.getPage().getImage().computeDocument(), partName);
                    part.setDocument(region.getPage().getImage().computeDocument());
                    region.setPart(part);
                    regionRepository.save(region);
                    imageID = region.getPage().getImage().getId();
                    ID = region.getId();
                    break;
                case symbol:
                    Symbol symbol = getSymbol(targetID);
                    part = createPart(symbol.getRegion().getPage().getImage().computeDocument(), partName);
                    symbol.setPart(part);
                    symbolRepository.save(symbol);
                    imageID = symbol.getRegion().getPage().getImage().getId();
                    ID = symbol.getId();
                    break;
                default:
                    throw new IM3WSException("Invalid assignable to part type: " + partAssignedToType);
            }
            PartUse partUse = new PartUse();
            partUse.setPartId(BigInteger.valueOf(part.getId()));
            partUse.setImageId(BigInteger.valueOf(imageID));
            partUse.setId(BigInteger.valueOf(ID));
            partUse.setPartName(partName);
            return partUse;
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot create part", e);
        }
    }

    /*@PutMapping(path = {"clear/{partAssignedToType}/{targetID}"})
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
    }*/



    @DeleteMapping(path = {"delete/{partID}"})
    public long deletePart(@PathVariable("partID") long partID)  {
        try {
            Optional<Part> part = partRepository.findById(partID);
            if (!part.isPresent()) {
                throw new IM3WSException("Cannot find a part with id " + partID);
            }

            partRepository.delete(part.get());
            return partID;
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot delete part", e);
        }
    }

    private Part findPart(Long partID) throws IM3WSException {
        Optional<Part> part = partRepository.findById(partID);
        if (!part.isPresent()) {
            throw new IM3WSException("Cannot find a part with id " + partID);
        }

        return part.get();
    }
    @PutMapping("link/{partID}/image/{imageID}")
    @Transactional
    public PartUse linkPartToImage(@PathVariable Long partID, @PathVariable Long imageID) {
        try {
            Part part = findPart(partID);

            Optional<Image> image = imageRepository.findById(imageID);
            if (!image.isPresent()) {
                throw new IM3WSException("Cannot find an image with id " + imageID);
            }

            image.get().setPart(part);
            imageRepository.save(image.get());

            return new PartUse(partID, imageID, null);
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot link part to image", e);
        }
    }

    @PutMapping("unlink/image/{imageID}")
    @Transactional
    public PartUse unlinkPartToImage(@PathVariable Long imageID) throws IM3WSException {
        try {
            Optional<Image> image = imageRepository.findById(imageID);
            if (!image.isPresent()) {
                throw new IM3WSException("Cannot find an image with id " + imageID);
            }

            Long partID = image.get().getPart().getId();
            image.get().setPart(null);
            imageRepository.save(image.get());

            return new PartUse(partID, imageID, null);
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot unlink image", e);
        }
    }

    @PutMapping("link/{partID}/page/{pageID}")
    @Transactional
    public PartUse linkPartToPage(@PathVariable Long partID, @PathVariable Long pageID) throws IM3WSException {
        try {
            Part part = findPart(partID);

            Optional<Page> page = pageRepository.findById(pageID);
            if (!page.isPresent()) {
                throw new IM3WSException("Cannot find a page with id " + pageID);
            }

            page.get().setPart(part);
            pageRepository.save(page.get());

            return new PartUse(partID, page.get().getImage().getId(), pageID);
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot link part to page", e);
        }
    }

    @PutMapping("unlink/page/{pageID}")
    @Transactional
    public PartUse unlinkPartToPage(@PathVariable Long pageID)  {
        try {
            Optional<Page> page = pageRepository.findById(pageID);
            if (!page.isPresent()) {
                throw new IM3WSException("Cannot find a page with id " + pageID);
            }

            Long partID = page.get().getPart().getId();
            page.get().setPart(null);
            pageRepository.save(page.get());

            return new PartUse(partID, page.get().getImage().getId(), pageID);
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot unlink part", e);
        }
    }

    @PutMapping("link/{partID}/region/{regionID}")
    @Transactional
    public PartUse linkPartToRegion(@PathVariable Long partID, @PathVariable Long regionID) {
        try {
            Part part = findPart(partID);

            Optional<Region> region = regionRepository.findById(regionID);
            if (!region.isPresent()) {
                throw new IM3WSException("Cannot find a region with id " + regionID);
            }

            region.get().setPart(part);
            regionRepository.save(region.get());

            return new PartUse(partID, region.get().getPage().getImage().getId(), regionID);
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot link part to region", e);
        }
    }

    @PutMapping("unlink/region/{regionID}")
    @Transactional
    public PartUse unlinkPartToRegion(@PathVariable Long regionID) {
        try {
            Optional<Region> region = regionRepository.findById(regionID);
            if (!region.isPresent()) {
                throw new IM3WSException("Cannot find a region with id " + regionID);
            }

            Long partID = region.get().getPart().getId();
            region.get().setPart(null);
            regionRepository.save(region.get());

            return new PartUse(partID, region.get().getPage().getImage().getId(), regionID);
        } catch (IM3WSException e) {
            throw ControllerUtils.createServerError(this, "Cannot unlink region", e);
        }
    }

    /*@GetMapping(path = {"partNamesUsedByImage/{imageID}"})
    @Transactional
    public List<String> getImageDocumentParts(@PathVariable(name="imageID") Long imageID) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Getting part names used by image with id {0}", imageID);
        List<String> result = partRepository.getPartNamesUsedByImage(imageID);
        return result;
    }*/

}
