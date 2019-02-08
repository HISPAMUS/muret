package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.muret.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.UploadFileResponse;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import es.ua.dlsi.grfia.im3ws.muret.service.ImageService;
import es.ua.dlsi.grfia.im3ws.muret.service.ProjectService;
import es.ua.dlsi.grfia.im3ws.service.FileStorageService;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

// See complete file in https://www.callicoder.com/spring-boot-file-upload-download-rest-api-example/
/**
 * Used to upload project images to the server
 */

@CrossOrigin("${angular.url}")
@RequestMapping("/muretapi/upload")
@RestController
public class ProjectImageController {
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private MURETConfiguration muretConfiguration;
    @Autowired
    ProjectService projectService;
    @Autowired
    ImageService imageService;

    // angular ng2-file-upload uploads files one by one
    @PostMapping("projectImage")
    public UploadFileResponse uploadFile(@RequestParam("projectid") Integer projectid, @RequestParam("file") MultipartFile file) throws IM3Exception {
        Optional<Project> project = projectService.findById(projectid);
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
        Image image = new Image(fileName, null, fullImage.getWidth(), fullImage.getHeight(), project.get(), null);
        imageService.create(image);

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
}
