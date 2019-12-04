package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.BinaryOutputWrapper;
import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.controller.StringResponse;
import es.ua.dlsi.grfia.im3ws.muret.auditing.AuditorAwareImpl;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.ProjectStatistics;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.StringBody;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.UploadFileResponse;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.entity.Part;
import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import es.ua.dlsi.grfia.im3ws.muret.entity.State;
import es.ua.dlsi.grfia.im3ws.muret.model.NotationModel;
import es.ua.dlsi.grfia.im3ws.muret.model.ProjectModel;
import es.ua.dlsi.grfia.im3ws.muret.repository.ImageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.PartRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.ProjectRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.StateRepository;
import es.ua.dlsi.grfia.im3ws.service.FileStorageService;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.utils.FileCompressors;
import es.ua.dlsi.im3.core.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

// See complete file in https://www.callicoder.com/spring-boot-file-upload-download-rest-api-example/
/**
 * Used to upload project images to the server
 */

//@CrossOrigin("${angular.url}")
@RequestMapping("project")
@RestController
public class ProjectController {
    private final FileStorageService fileStorageService;
    private final MURETConfiguration muretConfiguration;
    private final ProjectRepository projectRepository;
    private final ImageRepository imageRepository;
    private final StateRepository stateRepository;
    private final PartRepository partRepository;
    private final ProjectModel projectModel;
    private final NotationModel notationModel;

    @Autowired
    public ProjectController(ProjectModel projectModel, FileStorageService fileStorageService,
                             MURETConfiguration muretConfiguration, ProjectRepository projectRepository, ImageRepository imageRepository,
                             StateRepository stateRepository, PartRepository partRepository) {
        this.projectModel = projectModel;
        this.fileStorageService = fileStorageService;
        this.muretConfiguration = muretConfiguration;
        this.projectRepository = projectRepository;
        this.imageRepository = imageRepository;
        this.stateRepository = stateRepository;
        this.partRepository = partRepository;
        this.notationModel = new NotationModel();
    }

    @PostMapping(path = {"/new"})
    public Project newProject(@RequestBody Project project) throws IM3WSException {
        return projectModel.newProject(project);
    }


    // --- TODO usado hasta aquí ----

    // angular ng2-file-upload uploads files one by one
    @PostMapping("uploadProjectImage")
    public UploadFileResponse uploadFile(@RequestParam("projectid") Integer projectid, @RequestParam("file") MultipartFile file) throws IM3Exception {

        //Logger.getLogger(this.getClass().getName()).log(Level.INFO, "User ID: " + AuditorAwareImpl.getCurrentUser().getId().toString());

        Optional<Project> project = projectRepository.findById(projectid);
        if (!project.isPresent()) {
            throw new RuntimeException("Project with id " + projectid + " does not exist");
        }

        Path mastersPath = Paths.get(muretConfiguration.getFolder(), project.get().getPath(),  MURETConfiguration.MASTER_IMAGES);

        String fileName = fileStorageService.storeFile(mastersPath, file);

        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Uploading file {0} to project with id {1}", new Object[]{fileName, projectid});

        /*String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(project.get().getPath())
                .path(fileName)
                .toUriString();*/

        Path imagePath = mastersPath.resolve(fileName);
        BufferedImage fullImage = null;
        try {
            fullImage = ImageIO.read(imagePath.toFile());
        } catch (IOException e) {
            throw new IM3Exception(e);
        }

        Path thumbnailsPath = Paths.get(muretConfiguration.getFolder(), project.get().getPath(), MURETConfiguration.THUMBNAIL_IMAGES, fileName);
        createSecondaryImage(imagePath, thumbnailsPath, muretConfiguration.getThumbnailHeight());

        Path previewPath = Paths.get(muretConfiguration.getFolder(), project.get().getPath(), MURETConfiguration.PREVIEW_IMAGES, fileName);
        createSecondaryImage(imagePath, previewPath, muretConfiguration.getPreviewHeight());

        //TODO Atómico
        //TODO Ordenación
        Image image = new Image(fileName, null, fullImage.getWidth(), fullImage.getHeight(), project.get(), null, null);
        image.setCreatedBy(AuditorAwareImpl.getCurrentUser());
        imageRepository.save(image);

        return new UploadFileResponse(fileName, file.getContentType(), file.getSize());
    }

    private void createSecondaryImage(Path inputImagePath, Path outputImagePath, int height) throws IM3Exception {
        ImageUtils.getInstance().scaleToFitHeight(inputImagePath.toFile(), outputImagePath.toFile(), height);
    }

    // angular ng2-file-upload uses file as parameter name
    /*@PostMapping("projectImages")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("projectid") Integer projectid, @RequestParam("files") MultipartFile[] files) {


        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Uploading {0} files to project with id {1}", new Object[]{files==null?0:files.length, projectid});
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }*/


    @GetMapping(path = {"/statistics/{id}"})
    public ProjectStatistics getProjectStatistics(@PathVariable("id") Integer id) throws IM3WSException {
        Optional<Project> project = projectRepository.findById(id);
        if (!project.isPresent()) {
            throw new IM3WSException("Cannot find a project with id " + id);
        }

        //TODO All this could be done in just one query with a union
        int projectID = project.get().getId();
        ProjectStatistics projectStatistics = new ProjectStatistics();
        projectStatistics.setAgnosticSymbols(projectRepository.getNumberOfAgnosticSymbols(projectID));
        projectStatistics.setImages(project.get().getImages().size());
        projectStatistics.setPages(projectRepository.getNumberOfPages(projectID));
        projectStatistics.setRegions(projectRepository.getNumberOfRegions(projectID));

        return projectStatistics;
    }

    @PutMapping("/composer/{projectID}")
    public void putComposer(@PathVariable int projectID, @RequestBody StringBody composer) throws IM3WSException {
        Optional<Project> project = projectRepository.findById(projectID);
        if (!project.isPresent()) {
            throw new IM3WSException("Cannot find a project with id " + projectID);
        }

        project.get().setComposer(composer.getValue());
        projectRepository.save(project.get());
    }

    @PutMapping("/comments/{projectID}")
    public void putComments(@PathVariable int projectID, @RequestBody StringBody comments) throws IM3WSException {
        Optional<Project> project = projectRepository.findById(projectID);
        if (!project.isPresent()) {
            throw new IM3WSException("Cannot find a project with id " + projectID);
        }

        project.get().setComments(comments.getValue());
        projectRepository.save(project.get());
    }

    @PutMapping("/state/{projectID}")
    public void putState(@PathVariable int projectID, @RequestBody(required=false) State state) throws IM3WSException {
        Optional<Project> project = projectRepository.findById(projectID);
        if (!project.isPresent()) {
            throw new IM3WSException("Cannot find a project with id " + projectID);
        }

        State persistedState;
        if (project.get().getState() == null) {
            persistedState = stateRepository.save(state);
            project.get().setState(persistedState);
            projectRepository.save(project.get());

        } else {
            if (state == null) {
                State prevState = project.get().getState();
                project.get().setState(null);
                projectRepository.save(project.get());
                // delete state
                stateRepository.delete(prevState);
            } else {
                // update state
                persistedState = project.get().getState();
                persistedState.setState(state.getState());
                persistedState.setChangedBy(state.getChangedBy());
                persistedState.setComments(state.getComments());
                stateRepository.save(persistedState);
            }
        }
    }

    @GetMapping(path = {"/exportFullScoreMEI/{projectID}"})
    @Transactional
    public StringResponse exportFullScoreMEI(@PathVariable("projectID") Integer projectID) throws IM3WSException {
        return exportMEI(projectID, null);
    }

    @GetMapping(path = {"/exportPartMEI/{projectID}/{partID}"})
    @Transactional
    public StringResponse exportPartMEI(@PathVariable("projectID") Integer projectID, @PathVariable("partID") Long partID) throws IM3WSException {
        return exportMEI(projectID, partID);
    }

    private StringResponse exportMEI(Integer projectID, Long partID) throws IM3WSException {
        Optional<Project> project = projectRepository.findById(projectID);
        if (!project.isPresent()) {
            throw new IM3WSException("Cannot find a project with id " + projectID);
        }

        Part part = null;

        if (partID != null) {
            Optional<Part> opart = partRepository.findById(partID);
            if (!opart.isPresent()) {
                throw new IM3WSException("Cannot find a part with id " + partID);
            }
            part = opart.get();
        }

        try {
            return new StringResponse(notationModel.exportMEI(project.get(), part, false));
        } catch (IM3Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Error exporting MEI", e);
            throw new IM3WSException(e);
        }
    }

    @GetMapping(path = {"/exportMEIPartsFacsimile/{projectID}"})
    @Transactional
    public StringResponse exportMEIPartsFacsimile(@PathVariable("projectID") Integer projectID) throws IM3WSException {
        Optional<Project> project = projectRepository.findById(projectID);
        if (!project.isPresent()) {
            throw new IM3WSException("Cannot find a project with id " + projectID);
        }

        try {
            return new StringResponse(notationModel.exportMEI(project.get(), null, true));
        } catch (IM3Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Error exporting MEI parts facsimile", e);
            throw new IM3WSException(e);
        }
    }


    @RequestMapping(value="/exportMensurstrich/{projectID}", method= RequestMethod.GET, produces="application/x-gzip")
    @ResponseBody
    @Transactional
    public ResponseEntity<?> exportMensurstrich(@PathVariable Integer projectID) throws IM3WSException {
        Optional<Project> project = projectRepository.findById(projectID);
        if (!project.isPresent()) {
            throw new IM3WSException("Cannot find a project with id " + projectID);
        }

        try {
            FileCompressors fileCompressors = new FileCompressors();
            ArrayList<String> prefixes = new ArrayList<>();
            ArrayList<Path> files = new ArrayList<>();

            Path tgz = Files.createTempFile("mensurstrich_" + projectID, ".tar.gz");
            String filename = tgz.getFileName().toString();
            BinaryOutputWrapper output = new BinaryOutputWrapper("application/x-gzip");

            Path tmpDirectory = Files.createTempDirectory("mensurstrich_files_" + projectID);
            prefixes.add("content");
            files.add(tmpDirectory);
            notationModel.generateMensurstrich(tmpDirectory, project.get());

            fileCompressors.tgzFolders(tgz, files, prefixes);

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

    @RequestMapping(value="/exportMusicXML/{projectID}", method= RequestMethod.GET, produces="application/x-gzip")
    @ResponseBody
    @Transactional
    public ResponseEntity<?> exportMusicXML(@PathVariable Integer projectID) throws IM3WSException {
        Optional<Project> project = projectRepository.findById(projectID);
        if (!project.isPresent()) {
            throw new IM3WSException("Cannot find a project with id " + projectID);
        }

        try {
            FileCompressors fileCompressors = new FileCompressors();
            ArrayList<String> prefixes = new ArrayList<>();
            ArrayList<Path> files = new ArrayList<>();

            Path tgz = Files.createTempFile("musicxml_" + projectID, ".tar.gz");
            String filename = tgz.getFileName().toString();
            BinaryOutputWrapper output = new BinaryOutputWrapper("application/x-gzip");

            Path tmpDirectory = Files.createTempDirectory("musicxml_files_" + projectID); //TODO eliminar código duplicado (exportMensurstrich)
            prefixes.add("content");
            files.add(tmpDirectory);
            notationModel.generateMusicXML(tmpDirectory, project.get());

            fileCompressors.tgzFolders(tgz, files, prefixes);

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
