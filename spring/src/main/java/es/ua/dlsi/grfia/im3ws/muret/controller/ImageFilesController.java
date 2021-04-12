package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.model.ClassifierClient;
import es.ua.dlsi.grfia.im3ws.muret.repository.ImageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.PageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.SymbolRepository;
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
import java.nio.file.Path;
import java.nio.file.Paths;
// !!! Important: no controller should throw any exception

@RequestMapping("imagefiles")
@RestController
public class ImageFilesController extends MuRETBaseController {

    private final ClassifierClient classifierClient;

    @Autowired
    public ImageFilesController(MURETConfiguration muretConfiguration, ImageRepository imageRepository, PageRepository pageRepository, RegionRepository regionRepository, SymbolRepository symbolRepository) {
        super(muretConfiguration, imageRepository, pageRepository, regionRepository, symbolRepository);
        classifierClient = new ClassifierClient(muretConfiguration.getPythonclassifiers());
    }

    /**
     *
     * @param documentPath If null, it is searched in the document
     * @param imageID
     * @param imagesRelativePath
     * @return
     * @throws IM3WSException
     * @throws FileNotFoundException
     */
    private ResponseEntity<InputStreamResource> getImage(String documentPath, Long imageID, String imagesRelativePath) throws IM3WSException, FileNotFoundException {
        File imageFile = getImageFile(documentPath, imageID, imagesRelativePath);

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG) //TODO Siempre devolver JPEG, si no los tenemos cambiarlos
                .body(new InputStreamResource(new FileInputStream(imageFile)));

    }

    private File getImageFile(String documentPath, Image image, String imagesRelativePath) throws IM3WSException {
        if (documentPath == null) {
            documentPath = image.computeDocument().getPath();
        }

        //avoid another query File documentFolder = new File(muretConfiguration.getFolder(), image.get().getDocument().getPath());
        File documentFolder = new File(muretConfiguration.getFolder(), documentPath);
        File masterImagesFolder = new File(documentFolder, imagesRelativePath);
        File imageFile = new File(masterImagesFolder, image.getFilename());
        if (!imageFile.exists()) {
            throw new IM3WSException("Image '" + imageFile.getAbsolutePath() + "' for image with ID=" + image.getId() + " does not exist");
        }
        return imageFile;
    }
    private File getImageFile(String documentPath, Long imageID, String imagesRelativePath) throws IM3WSException {
        Image image = getImage(imageID);
        return getImageFile(documentPath, image, imagesRelativePath);
    }

    @GetMapping(value = "{documentPath}/master/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    // Does not need to be transactional @Transactional(readOnly = true)
    public ResponseEntity<InputStreamResource> getMasterImage(@PathVariable("documentPath") String documentPath, @PathVariable("imageID") Long imageID)  {
        try {
            return getImage(documentPath, imageID,  MURETConfiguration.MASTER_IMAGES);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot get master image", e);
        }
    }

    @GetMapping(value = "preview/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    @Transactional(readOnly = true)
    public ResponseEntity<InputStreamResource> getPreviewImage(@PathVariable("imageID") Long imageID)  {
        try {
            return getImage(null, imageID, MURETConfiguration.PREVIEW_IMAGES);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot get preview image", e);
        }
    }

    @GetMapping(value = "master/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    @Transactional(readOnly = true) // because we'll get the document path
    public ResponseEntity<InputStreamResource> getMasterImage(@PathVariable("imageID") Long imageID)  {
        try {
            return getImage(null, imageID,  MURETConfiguration.MASTER_IMAGES);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot get master image", e);
        }

    }

    @GetMapping(value = "{documentPath}/thumbnail/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    // Does not need to be transactional @Transactional(readOnly = true)
    public ResponseEntity<InputStreamResource> getThumbnailImage(@PathVariable("documentPath") String documentPath, @PathVariable("imageID") Long imageID) {
        try {
            return getImage(documentPath, imageID,  MURETConfiguration.THUMBNAIL_IMAGES);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot get thumnail image", e);
        }

    }
    @GetMapping(value = "{documentPath}/preview/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    // Does not need to be transactional @Transactional(readOnly = true)
    public ResponseEntity<InputStreamResource> getPreviewImage(@PathVariable("documentPath") String documentPath, @PathVariable("imageID") Long imageID) {
        try {
            return getImage(documentPath, imageID,  MURETConfiguration.PREVIEW_IMAGES);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot get preview image", e);
        }
    }

    @GetMapping(value = "croppedImage/{imageID}/{fromX}/{fromY}/{toX}/{toY}", produces = MediaType.IMAGE_JPEG_VALUE)
    @Transactional(readOnly = true)
    public ResponseEntity<InputStreamResource> getCroppedMasterImageBlob(@PathVariable("imageID") Long imageID,
            @PathVariable("fromX") int fromX, @PathVariable("fromY") int fromY,
            @PathVariable("toX") int toX, @PathVariable("toY") int toY) {

        try {
            File imageFile = getImageFile(null, imageID, MURETConfiguration.MASTER_IMAGES);

            BufferedImage bufferedImage = ImageIO.read(imageFile);
            BufferedImage croppedImage = ImageUtils.getInstance().crop(bufferedImage, fromX, fromY, toX, toY);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(croppedImage, "jpg", bos);
            byte[] bytes = bos.toByteArray();

            InputStreamResource inputStreamResource = new InputStreamResource(new ByteArrayInputStream(bytes));

            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG) //TODO Siempre devolver JPEG, si no los tenemos cambiarlos
                    .body(inputStreamResource);
        } catch (Throwable t) {
            throw ControllerUtils.createServerError(this, "Cannot get cropped master image", t);
        }
    }

    @PutMapping(value = "rotateImage/{imageID}/{degrees}")
    @Transactional
    public void rotateImage(@PathVariable("imageID") Long imageID, @PathVariable("degrees") double degrees) {
        try {
            Image image = getImage(imageID);
            File imageFile = getImageFile(null, image, MURETConfiguration.MASTER_IMAGES);

            BufferedImage bufferedImage = ImageIO.read(imageFile);
            File backup = new File(imageFile.getAbsolutePath() + "_backup");
            if (!backup.exists()) {
                // just save the first rotation
                ImageIO.write(bufferedImage, "JPG", backup);
            }
            BufferedImage rotatedImage = ImageUtils.getInstance().rotate(bufferedImage, degrees);
            ImageIO.write(rotatedImage, "JPG", imageFile);

            // now notify the image has changed to the server
            notifyServerImageChanged(image);
        } catch (Throwable t) {
            throw ControllerUtils.createServerError(this, "Cannot rotate image", t);
        }
    }

    private void notifyServerImageChanged(Image image) {
        Path imagePath = Paths.get(muretConfiguration.getFolder(), image.computeDocument().getPath(),
                MURETConfiguration.MASTER_IMAGES, image.getFilename());

        classifierClient.uploadImage(image.getId(), imagePath);
    }

    @PutMapping(value = "revertRotation/{imageID}")
    @Transactional
    public void revertRotation(@PathVariable("imageID") Long imageID) {
        try {
            Image image = getImage(imageID);
            File imageFile = getImageFile(null, image, MURETConfiguration.MASTER_IMAGES);

            File backup = new File(imageFile.getAbsolutePath() + "_backup");
            if (backup.exists()) {
                // just save the first rotation
                BufferedImage bufferedImage = ImageIO.read(backup);
                ImageIO.write(bufferedImage, "JPG", imageFile);
            }
            // now notify the image has changed to the server
            notifyServerImageChanged(image);

        } catch (Throwable t) {
            throw ControllerUtils.createServerError(this, "Cannot rotate image", t);
        }
    }
}
