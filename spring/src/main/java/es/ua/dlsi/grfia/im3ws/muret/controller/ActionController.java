package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.BinaryOutputWrapper;
import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.actionlogs.ActionLogSession;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.actionlogs.ActionLogSummary;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.actionlogs.ActionWithDuration;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;
//!Important: no controller should throw any exception

/**
 * @author drizo
 */
@RequestMapping("actionlogs")
@RestController
public class ActionController extends MuRETBaseController {
    private final ActionRepository actionRepository;
    private final DocumentRepository documentRepository;

    @Autowired
    public ActionController(MURETConfiguration muretConfiguration, ImageRepository imageRepository, PageRepository pageRepository, RegionRepository regionRepository, SymbolRepository symbolRepository, DocumentRepository documentRepository, ActionRepository actionRepository) {
        super(muretConfiguration, imageRepository, pageRepository, regionRepository, symbolRepository);
        this.actionRepository = actionRepository;
        this.documentRepository = documentRepository;
    }

    @GetMapping(path = {"/document/{id}"})
    @Transactional(readOnly = true)
    public ActionLogSummary getActionSummary(@PathVariable("documentID") Integer id)  {
        try {
            Optional<Document> document = documentRepository.findById(id);
            if (!document.isPresent()) {
                throw new IM3WSException("Cannot find document with ID " + id);
            }
            List<Action> actions = actionRepository.findByDocumentID(id);
            ActionLogSummary result = new ActionLogSummary(document.get(), actions);
            return result;
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot get parts in images", e);
        }
    }

    @GetMapping(path = {"/documentcsv/{id}"}, produces="application/x-gzip")
    @Transactional(readOnly = true)
    @ResponseBody
    public ResponseEntity<?> getActionSummaryInCSV(@PathVariable("documentID") Integer id)  {
        try {
            ActionLogSummary actionLogSummary = getActionSummary(id);

            String filename = "action_logs_" + id;
            Path csvOutputFile = Files.createTempFile(filename, ".csv");
            try (PrintWriter pw = new PrintWriter(csvOutputFile.toFile())) {
                // header
                pw.println("ActionID,UserID,Duration in seconds,DocumentID,SectionID,ImageID,PageID,RegionID,SymbolID,ClassifierID");

                for (ActionLogSession session: actionLogSummary.getSessions()) {
                    for (ActionWithDuration action : session.getActions()) {
                        StringBuilder record = new StringBuilder();
                        record.append(action.getActionID());
                        record.append(',');
                        record.append(action.getUserID());
                        record.append(',');
                        record.append(action.getDurationInSeconds());
                        record.append(',');
                        record.append(action.getDocumentID());
                        record.append(',');
                        if (action.getSectionID() != null) {
                            record.append(action.getSectionID());
                        }
                        record.append(',');
                        if (action.getImageID() != null) {
                            record.append(action.getImageID());
                        }
                        record.append(',');
                        if (action.getPageID() != null) {
                            record.append(action.getPageID());
                        }
                        record.append(',');
                        if (action.getRegionID() != null) {
                            record.append(action.getRegionID());
                        }
                        record.append(',');
                        if (action.getSymbolID() != null) {
                            record.append(action.getSymbolID());
                        }
                        record.append(',');
                        if (action.getClassifierID() != null) {
                            record.append(action.getClassifierID());
                        }

                        pw.println(record.toString());
                    }
                }
            }

            Path csvOutputFileGZ = Files.createTempFile(filename, ".csv.gz");
            compressGzip(csvOutputFile, csvOutputFileGZ);

            //TODO Copiado de TrainingSets
            BinaryOutputWrapper output = new BinaryOutputWrapper("application/x-gzip");
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Adding to output file name {0}", filename);
            output.setFilename(filename + ".csv.gz");
            byte[] data = Files.readAllBytes(csvOutputFile);
            output.setData(data);
            return new ResponseEntity<>(output.getData(), output.getHeaders(), HttpStatus.OK);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot get parts in images", e);
        }
    }

    //TODO llevar esto a una clase de utilidades
    public static void compressGzip(Path source, Path target) throws IOException {

        try (GZIPOutputStream gos = new GZIPOutputStream(
                new FileOutputStream(target.toFile()));
             FileInputStream fis = new FileInputStream(source.toFile())) {

            // copy file
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                gos.write(buffer, 0, len);
            }

        }

    }
}
