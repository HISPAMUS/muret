package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.LastDocumentExtract;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.SymbolCreationFromBoundingBox;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.SymbolCreationResult;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.UsesOfParts;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
import es.ua.dlsi.im3.core.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
// !!! Important: no controller should throw any exception

@RequestMapping("lastdocument")
@RestController
public class LastDocumentController {

    private final LastDocumentRepository lastDocumentRepository;
    private final DocumentRepository documentRepository;
    private final UserRepository userRepository;

    @Autowired
    public LastDocumentController(LastDocumentRepository lastDocumentRepository, DocumentRepository documentRepository, UserRepository userRepository) {
        this.lastDocumentRepository = lastDocumentRepository;
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
    }

    // It gets just the last count documents
    @GetMapping(path = {"user/{userID}/{count}"})
    @Transactional(readOnly = true)
    public List<LastDocumentExtract> getLastOpenedDocuments(@PathVariable(name="userID") Integer userID, @PathVariable(name="count") Integer count){
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Retrieving last open documents by user {0}", userID);
        try {
            User user = findByUserId(userID);
            List<LastDocument> lastDocs = user.getLastDocuments();
            lastDocs.sort((o1, o2) ->
                    -o1.getTimestamp().compareTo(o2.getTimestamp()) // sort descending
            );

            ArrayList<LastDocumentExtract> result = new ArrayList<>();
            for (int i=0; i<lastDocs.size() && i<count; i++) {
                LastDocument lastDocument = lastDocs.get(i);
                result.add(new LastDocumentExtract(lastDocument));
            }

            return result;
        } catch (Exception e) {
            throw ControllerUtils.createServerError(this, "Cannot get last opened documents", e);
        }
    }

    private User findByUserId(Integer userID) throws Exception {
        Optional<User> user = userRepository.findById(userID);
        if (!user.isPresent()) {
            throw new Exception("Cannot find the user with id " + userID);
        }
        return user.get();
    }

    @javax.transaction.Transactional
    @GetMapping(path = {"update/{userID}/{documentID}"})
    public LastDocumentExtract update(@PathVariable(name="userID") Integer userID, @PathVariable(name="documentID") Integer documentID){
        try {
            // first search it, if found update last open date
            User user = findByUserId(userID);
            List<LastDocument> lastDocs = user.getLastDocuments();
            // there is a unique key user-document
            LastDocument lastDocument = null;
            for (LastDocument l: lastDocs) {
                if (l.getDocument().getId().equals(documentID)) {
                    lastDocument = l;
                    break;
                }
            }
            if (lastDocument != null) {
                lastDocument.setTimestamp(new Date());
            } else {
                lastDocument = new LastDocument();
                Optional<Document> document = documentRepository.findById(documentID);
                if (!document.isPresent()) {
                    throw new Exception("Cannot find the document with id " + documentID);
                }
                lastDocument.setDocument(document.get());

                lastDocument.setUser(user);
                lastDocument.setTimestamp(new Date());
            }
            lastDocumentRepository.save(lastDocument);
            return new LastDocumentExtract(lastDocument);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot update or insert the last opened document", e);
        }
    }
}
