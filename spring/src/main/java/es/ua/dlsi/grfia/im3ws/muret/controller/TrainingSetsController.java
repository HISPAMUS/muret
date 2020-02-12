package es.ua.dlsi.grfia.im3ws.muret.controller;


import es.ua.dlsi.grfia.im3ws.BinaryOutputWrapper;
import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.Document;
import es.ua.dlsi.grfia.im3ws.muret.model.ITrainingSetExporter;
import es.ua.dlsi.grfia.im3ws.muret.model.trainingsets.TrainingSetsFactory;
import es.ua.dlsi.grfia.im3ws.muret.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
// !!! Important: no controller should throw any exception

/**
 * @author drizo
 */
//@CrossOrigin("${angular.url}")
@RequestMapping("trainingsets")
@RestController
@Transactional // this solves the error: "springboot "failed to lazily initialize a collection of role": could not initialize proxy - no Session
public class TrainingSetsController {
    private final MURETConfiguration muretConfiguration;
    private final DocumentRepository documentRepository;
    private final EntityManagerFactory entityManagerFactory;
    private final TrainingSetsFactory trainingSetsFactory;


    @Autowired
    public TrainingSetsController(MURETConfiguration muretConfiguration, DocumentRepository documentRepository, EntityManagerFactory entityManagerFactory, TrainingSetsFactory trainingSetsFactory) {
        this.muretConfiguration = muretConfiguration;
        this.documentRepository = documentRepository;
        this.entityManagerFactory = entityManagerFactory;
        this.trainingSetsFactory = trainingSetsFactory;
    }

    @GetMapping(path = {"/exporters"})
    public Collection<ITrainingSetExporter> getTrainingSetExporters()  {
       // return TrainingSetsFactory.getInstance(entityManagerFactory).getTrainingSetExporters();
        return trainingSetsFactory.getTrainingSetExporters();
    }

    /**
     * GET http://<host>/muretapi/{exporterIndex}/1,2,3,4
     * where 1,2,3,4 stand for document ids
     * @param exporterIndex
     * @param documentIds
     * @return
     */
    @RequestMapping(value="/download/{exporterIndex}/{documentIds}", method= RequestMethod.GET, produces="application/x-gzip")
    @ResponseBody
    public ResponseEntity<?> download(@PathVariable Integer exporterIndex, @PathVariable List<Integer> documentIds)  {
        try {
            //ITrainingSetExporter exporter = TrainingSetsFactory.getInstance(entityManagerFactory).getTrainingSetExporter(exporterIndex);
            ITrainingSetExporter exporter = trainingSetsFactory.getTrainingSetExporter(exporterIndex);
            ArrayList<Document> documentArrayList = new ArrayList<>();
            for (Integer documentID: documentIds) {
                Optional<Document> document = documentRepository.findById(documentID);
                if (!document.isPresent()) {
                    throw new IM3WSException("Cannot find document with id=" + documentID);
                }
                documentArrayList.add(document.get());
            }

            Path muretFolder = Paths.get(muretConfiguration.getFolder());
            Path tgz = exporter.generate(muretFolder, documentArrayList);

            String filename = tgz.getFileName().toString();
            BinaryOutputWrapper output = new BinaryOutputWrapper("application/x-gzip");
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Adding to output file name {0}", filename);
            output.setFilename(filename);
            byte[] data = Files.readAllBytes(tgz);
            output.setData(data);

            return new ResponseEntity<>(output.getData(), output.getHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            throw ControllerUtils.createServerError(this, "Cannot export and download training set", e);
        }

    }
}
