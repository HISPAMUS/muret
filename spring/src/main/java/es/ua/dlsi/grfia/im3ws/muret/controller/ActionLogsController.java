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
public class ActionLogsController extends MuRETBaseController {
    private final ActionRepository actionRepository;
    private final DocumentRepository documentRepository;
    private final UserRepository userRepository;
    private final ActionTypeRepository actionTypeRepository;

    @Autowired
    public ActionLogsController(MURETConfiguration muretConfiguration, ImageRepository imageRepository, PageRepository pageRepository, RegionRepository regionRepository, SymbolRepository symbolRepository, DocumentRepository documentRepository, ActionRepository actionRepository,
                                UserRepository userRepository, ActionTypeRepository actionTypeRepository) {
        super(muretConfiguration, imageRepository, pageRepository, regionRepository, symbolRepository);
        this.actionRepository = actionRepository;
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
        this.actionTypeRepository = actionTypeRepository;
    }

    @GetMapping(path = {"/document/{documentID}"})
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

    @GetMapping(path = {"/documentcsv/{documentID}"}, produces="application/x-gzip")
    @Transactional(readOnly = true)
    @ResponseBody
    public ResponseEntity<?> getActionSummaryInCSV(@PathVariable("documentID") Integer documentID)  {
        try {
            ActionLogSummary actionLogSummary = getActionSummary(documentID);

            HashMap<Integer, User> userHashMap = new HashMap<>();
            HashMap<Integer, ActionType> actionTypeHashMap = new HashMap<>();
            String filename = "action_logs_" + documentID;
            Path csvOutputFile = Files.createTempFile(filename, ".csv");
            try (PrintWriter pw = new PrintWriter(csvOutputFile.toFile())) {
                // header
                pw.println("ActionID,User,Phase,Action type,Duration in seconds,DocumentID,SectionID,ImageID,PageID,RegionID,SymbolID,ClassifierID");
                for (ActionLogSession session: actionLogSummary.getSessions()) {
                    for (ActionWithDuration action : session.getActions()) {
                        User user = userHashMap.get(action.getUserID());
                        if (user == null) {
                            Optional<User> usr = userRepository.findById(action.getUserID());
                            if (!usr.isPresent()) {
                                throw new IM3WSException("Cannot find user with ID = " + action.getUserID());
                            }
                            user = usr.get();
                        }
                        ActionType actionType = actionTypeHashMap.get(action.getActionTypeID());
                        if (actionType == null) {
                            Optional<ActionType> usr = actionTypeRepository.findById(action.getActionTypeID());
                            if (!usr.isPresent()) {
                                throw new IM3WSException("Cannot find action type with ID = " + action.getActionTypeID());
                            }
                            actionType = usr.get();
                        }
                        StringBuilder record = new StringBuilder();
                        record.append(action.getActionID());
                        record.append(',');
                        record.append(user.getUsername());
                        record.append(',');
                        record.append(actionType.getPhase().name());
                        record.append(',');
                        record.append(actionType.getName());
                        record.append(',');
                        if (action.getDurationInSeconds() != null) {
                            record.append(action.getDurationInSeconds());
                        }
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
            throw ControllerUtils.createServerError(this, "Cannot generate action logs gz", e);
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
