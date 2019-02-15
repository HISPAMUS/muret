package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;

@RequestMapping("imagecrud")
@RestController
public class ImageFilesController {
    MURETConfiguration muretConfiguration;

    ImageRepository imageRepository;

    @Autowired
    public ImageFilesController(MURETConfiguration muretConfiguration, ImageRepository imageRepository) {
        this.muretConfiguration = muretConfiguration;
        this.imageRepository = imageRepository;
    }

    private ResponseEntity<InputStreamResource> getImage(Long imageID, String imagesRelativePath) throws IM3WSException, FileNotFoundException {
        Optional<Image> image = imageRepository.findById(imageID);
        if (!image.isPresent()) {
            throw new IM3WSException("Cannot find an image with id " + imageID);
        }

        File projectFolder = new File(muretConfiguration.getFolder(), image.get().getProject().getPath());
        File masterImagesFolder = new File(projectFolder, imagesRelativePath);
        File imageFile = new File(masterImagesFolder, image.get().getFilename());
        if (!imageFile.exists()) {
            throw new IM3WSException("Image '" + imageFile.getAbsolutePath() + "' for image with ID=" + imageID + " does not exist");
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG) //TODO Siempre devolver JPEG, si no los tenemos cambiarlos
                .body(new InputStreamResource(new FileInputStream(imageFile)));

    }

    @GetMapping(value = "master/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getMasterImage(@PathVariable("imageID") Long imageID) throws IM3WSException, FileNotFoundException {
        return getImage(imageID,  MURETConfiguration.MASTER_IMAGES);
    }

    @GetMapping(value = "thumbnail/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getThumbnailImage(@PathVariable("imageID") Long imageID) throws IM3WSException, FileNotFoundException {
        return getImage(imageID,  MURETConfiguration.THUMBNAIL_IMAGES);
    }
    @GetMapping(value = "preview/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getPreviewImage(@PathVariable("imageID") Long imageID) throws IM3WSException, FileNotFoundException {
        return getImage(imageID,  MURETConfiguration.PREVIEW_IMAGES);
    }

}
