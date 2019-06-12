package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.repository.ImageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.PageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.SymbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;

@RequestMapping("imagefiles")
@RestController
public class ImageFilesController extends MuRETBaseController {

    @Autowired
    public ImageFilesController(MURETConfiguration muretConfiguration, ImageRepository imageRepository, PageRepository pageRepository, RegionRepository regionRepository, SymbolRepository symbolRepository) {
        super(muretConfiguration, imageRepository, pageRepository, regionRepository, symbolRepository);
    }

    /**
     *
     * @param projectPath If null, it is searched in the project
     * @param imageID
     * @param imagesRelativePath
     * @return
     * @throws IM3WSException
     * @throws FileNotFoundException
     */
    private ResponseEntity<InputStreamResource> getImage(String projectPath, Long imageID, String imagesRelativePath) throws IM3WSException, FileNotFoundException {
        Image image = getImage(imageID);

        if (projectPath == null) {
            projectPath = image.getProject().getPath();
        }

        //avoid another query File projectFolder = new File(muretConfiguration.getFolder(), image.get().getProject().getPath());
        File projectFolder = new File(muretConfiguration.getFolder(), projectPath);
        File masterImagesFolder = new File(projectFolder, imagesRelativePath);
        File imageFile = new File(masterImagesFolder, image.getFilename());
        if (!imageFile.exists()) {
            throw new IM3WSException("Image '" + imageFile.getAbsolutePath() + "' for image with ID=" + imageID + " does not exist");
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG) //TODO Siempre devolver JPEG, si no los tenemos cambiarlos
                .body(new InputStreamResource(new FileInputStream(imageFile)));

    }

    @GetMapping(value = "{projectPath}/master/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getMasterImage(@PathVariable("projectPath") String projectPath, @PathVariable("imageID") Long imageID) throws IM3WSException, FileNotFoundException {
        return getImage(projectPath, imageID,  MURETConfiguration.MASTER_IMAGES);
    }
    @GetMapping(value = "master/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    @Transactional // because we'll get the project path
    public ResponseEntity<InputStreamResource> getMasterImage(@PathVariable("imageID") Long imageID) throws IM3WSException, FileNotFoundException {
        return getImage(null, imageID,  MURETConfiguration.MASTER_IMAGES);
    }

    @GetMapping(value = "{projectPath}/thumbnail/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getThumbnailImage(@PathVariable("projectPath") String projectPath, @PathVariable("imageID") Long imageID) throws IM3WSException, FileNotFoundException {
        return getImage(projectPath, imageID,  MURETConfiguration.THUMBNAIL_IMAGES);
    }
    @GetMapping(value = "{projectPath}/preview/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getPreviewImage(@PathVariable("projectPath") String projectPath, @PathVariable("imageID") Long imageID) throws IM3WSException, FileNotFoundException {
        return getImage(projectPath, imageID,  MURETConfiguration.PREVIEW_IMAGES);
    }

}
