package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.MoveDocuments;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
// !!! Important: no controller should throw any exception

/**
 * @author drizo
 */
@RequestMapping("collections")
@RestController
public class CollectionsController {
    private final CollectionRepository collectionRepository;
    private final DocumentRepository documentRepository;

    @Autowired
    public CollectionsController(CollectionRepository collectionRepository,  DocumentRepository documentRepository) {
        this.collectionRepository = collectionRepository;
        this.documentRepository = documentRepository;
    }


    @PutMapping(path = {"create/{parentCollectionID}/{subcollectionName}"})
    @Transactional
    public Collection createSubcollection(@PathVariable(name="parentCollectionID") Integer parentCollectionID, @PathVariable(name="subcollectionName") String subcollectionName) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Creating subcollection {0} for collection {1}", new Object[] {subcollectionName, parentCollectionID});

        try {
            Optional<Collection> parentCollection = collectionRepository.findById(parentCollectionID);
            if (!parentCollection.isPresent()) {
                throw new IM3WSException("Cannot find parent collection with id " + parentCollectionID);
            }

            Collection collection = new Collection();
            collection.setName(subcollectionName);
            collection.setParent(parentCollection.get());
            return collectionRepository.save(collection);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot create subcollection", e);

        }
    }


    @DeleteMapping(path = {"delete/{collectionID}"})
    @Transactional
    public long deletePart(@PathVariable("collectionID") int collectionID) {
        try {
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
        } catch (Throwable t) {
            throw ControllerUtils.createServerError(this, "Cannot delete part", t);

        }
    }

    @PutMapping(path = {"moveDocumentToNewSubcollection"})
    @Transactional
    public Integer moveDocumentToNewSubcollection(@RequestBody MoveDocuments moveDocuments) {
        try {
            Collection collection = createSubcollection(moveDocuments.getCurrentCollectionID(), moveDocuments.getNewCollectionName());
            moveDocuments.setSubcollectionID(collection.getId());
            moveDocumentToSubcollection(moveDocuments);
            return moveDocuments.getCurrentCollectionID();
        } catch (Throwable t) {
            throw ControllerUtils.createServerError(this, "Cannot move document", t);

        }
    }

    @PutMapping(path = {"moveDocumentToSubcollection"})
    @Transactional
    public Integer moveDocumentToSubcollection(@RequestBody MoveDocuments moveDocuments)  {
        try {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Moving documents to subcollection");

            Optional<Collection> currentCollection = collectionRepository.findById(moveDocuments.getCurrentCollectionID());
            if (!currentCollection.isPresent()) {
                throw new IM3WSException("Cannot find collection with id " + moveDocuments.getCurrentCollectionID());
            }

            Optional<Collection> subcollection = collectionRepository.findById(moveDocuments.getSubcollectionID());
            if (!subcollection.isPresent()) {
                throw new IM3WSException("Cannot find subcollection with id " + moveDocuments.getSubcollectionID());
            }

            ArrayList<Document> changedDocuments = new ArrayList<>();

            for (int documentID : moveDocuments.getDocumentIDs()) {
                Optional<Document> document = documentRepository.findById(documentID);
                if (!document.isPresent()) {
                    throw new IM3WSException("Cannot find a document with id " + documentID);
                }

                document.get().setCollection(subcollection.get());
                currentCollection.get().getDocuments().remove(document.get());
            }

            documentRepository.saveAll(changedDocuments);
            collectionRepository.save(currentCollection.get());
            return moveDocuments.getCurrentCollectionID();
        } catch (Throwable t) {
            throw ControllerUtils.createServerError(this, "Cannot move document", t);

        }
    }

}
