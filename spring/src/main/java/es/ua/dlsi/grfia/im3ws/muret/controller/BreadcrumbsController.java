package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.*;
import es.ua.dlsi.grfia.im3ws.muret.entity.Collection;
import es.ua.dlsi.grfia.im3ws.muret.entity.Document;
import es.ua.dlsi.grfia.im3ws.muret.repository.CollectionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
// !!! Important: no controller should throw any exception

/**
 * @author drizo
 */
@RequestMapping("breadcrumbs")
@RestController
public class BreadcrumbsController {
    private final CollectionRepository collectionRepository;
    private final DocumentRepository documentRepository;

    @Autowired
    public BreadcrumbsController(CollectionRepository collectionRepository, DocumentRepository documentRepository) {
        this.collectionRepository = collectionRepository;
        this.documentRepository = documentRepository;
    }

    @GetMapping(path = {"collection/{collectionID}"})
    @Transactional
    public List<Breadcrumb> getCollectionBreadcrumbs(@PathVariable("collectionID") Integer collectionID) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Getting collection breadcrumbs of collection id={0}", collectionID);

        try {
            Optional<Collection> collection = collectionRepository.findById(collectionID);
            if (!collection.isPresent()) {
                throw new IM3WSException("Cannot find collection with id " + collectionID);
            }

            return getBreadcrumbs(collection.get());
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot get collection breadbrumbs", e);
        }
    }

    private ArrayList<Breadcrumb> getBreadcrumbs(Collection collection) {
        ArrayList<Breadcrumb> result = new ArrayList<>();
        Collection currentCollection = collection;
        while (currentCollection != null) {
            result.add(0, new Breadcrumb(currentCollection.getId(), BreadcrumbType.collection, currentCollection.getName()));
            currentCollection = currentCollection.getParent();
        }
        return result;
    }

    @GetMapping(path = {"document/{documentID}"})
    @Transactional
    public List<Breadcrumb> getDocumentBreadcrumbs(@PathVariable("documentID") Integer documentID) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Getting collection breadcrumbs of document id={0}", documentID);

        try {
            Optional<Document> document = documentRepository.findById(documentID);
            if (!document.isPresent()) {
                throw new IM3WSException("Cannot find document with id " + documentID);
            }

            List<Breadcrumb> result = getBreadcrumbs(document.get().getCollection());
            result.add(new Breadcrumb(documentID, BreadcrumbType.document, document.get().getName()));
            return result;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot get document breadbrumbs", e);
        }
    }
}
