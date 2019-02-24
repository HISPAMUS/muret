package es.ua.dlsi.grfia.im3ws.muret.controller;


import es.ua.dlsi.grfia.im3ws.BinaryOutputWrapper;
import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import es.ua.dlsi.grfia.im3ws.muret.model.ITrainingSetExporter;
import es.ua.dlsi.grfia.im3ws.muret.model.trainingsets.TrainingSetsFactory;
import es.ua.dlsi.grfia.im3ws.muret.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author drizo
 */
//@CrossOrigin("${angular.url}")
@RequestMapping("trainingsets")
@RestController
@Transactional // this solves the error: "springboot "failed to lazily initialize a collection of role": could not initialize proxy - no Session
public class TrainingSetsController {
    private final MURETConfiguration muretConfiguration;

    private final ProjectRepository projectRepository;

    @Autowired
    public TrainingSetsController(MURETConfiguration muretConfiguration, ProjectRepository projectRepository) {
        this.muretConfiguration = muretConfiguration;
        this.projectRepository = projectRepository;
    }

    @GetMapping(path = {"/exporters"})
    public Collection<ITrainingSetExporter> getTrainingSetExporters()  {
        return TrainingSetsFactory.getInstance().getTrainingSetExporters();
    }

    /**
     * GET http://<host>/muretapi/{exporterIndex}/1,2,3,4
     * where 1,2,3,4 stand for project ids
     * @param exporterIndex
     * @param projectIds
     * @return
     */
    @RequestMapping(value="/download/{exporterIndex}/{projectIds}", method= RequestMethod.GET, produces="application/x-gzip")
    @ResponseBody
    public ResponseEntity<?> download(@PathVariable Integer exporterIndex, @PathVariable List<Integer> projectIds) throws IM3WSException {
        try {
            ITrainingSetExporter exporter = TrainingSetsFactory.getInstance().getTrainingSetExporter(exporterIndex);

            ArrayList<Project> projectArrayList = new ArrayList<>();
            for (Integer projectID: projectIds) {
                Optional<Project> project = projectRepository.findById(projectID);
                if (!project.isPresent()) {
                    throw new IM3WSException("Cannot find project with id=" + projectID);
                }
                projectArrayList.add(project.get());
            }

            Path muretFolder = Paths.get(muretConfiguration.getFolder());
            Path tgz = exporter.generate(muretFolder, projectArrayList);

            String filename = tgz.getFileName().toString();
            BinaryOutputWrapper output = new BinaryOutputWrapper("application/x-gzip");
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Adding to output file name {0}", filename);
            output.setFilename(filename);
            byte[] data = Files.readAllBytes(tgz);
            output.setData(data);

            return new ResponseEntity<>(output.getData(), output.getHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot export", e);
            throw new IM3WSException(e);
        }

    }
}
