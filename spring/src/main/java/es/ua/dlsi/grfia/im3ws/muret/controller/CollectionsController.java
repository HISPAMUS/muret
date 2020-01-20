package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
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
@RequestMapping("collections")
@RestController
public class CollectionsController {
    private final CollectionRepository collectionRepository;

    @Autowired
    public CollectionsController(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }


    @PutMapping(path = {"create/{parentCollectionID}/{subcollectionName}"})
    @Transactional
    public Collection createSubcollection(@PathVariable(name="parentCollectionID") Integer parentCollectionID, @PathVariable(name="subcollectionName") String subcollectionName) throws IM3WSException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Creating subcollection {0} for collection {1}", new Object[] {subcollectionName, parentCollectionID});

        Optional<Collection> parentCollection = collectionRepository.findById(parentCollectionID);
        if (!parentCollection.isPresent()) {
            throw new IM3WSException("Cannot find parent collection with id " + parentCollectionID);
        }

        Collection collection = new Collection();
        collection.setName(subcollectionName);
        collection.setParent(parentCollection.get());
        return collectionRepository.save(collection);
    }


    @DeleteMapping(path = {"delete/{collectionID}"})
    @Transactional
    public long deletePart(@PathVariable("collectionID") int collectionID) throws IM3WSException {
        Optional<Collection> collection = collectionRepository.findById(collectionID);
        if (!collection.isPresent()) {
            throw new IM3WSException("Cannot find collection with id " + collectionID);
        }

        if (collection.get().getDocuments() != null && !collection.get().getDocuments().isEmpty()) {
            throw new IM3WSException("Cannot delete collection containing subcollections");
        }

        if (collection.get().getSubcollections() != null && !collection.get().getSubcollections().isEmpty()) {
            throw new IM3WSException("Cannot delete collection containing " + collection.get().getSubcollections().size() + " subcollections");
        }

        if (collection.get().getDocuments() != null && !collection.get().getDocuments().isEmpty()) {
            throw new IM3WSException("Cannot delete collection containing " + collection.get().getDocuments().size() + " documents");
        }

        collectionRepository.delete(collection.get());
        return collectionID;
    }
}
