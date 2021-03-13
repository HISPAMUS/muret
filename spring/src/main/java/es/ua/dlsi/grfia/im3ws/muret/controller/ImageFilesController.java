package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.ImageToCrop;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.RegionCreation;
import es.ua.dlsi.grfia.im3ws.muret.entity.BoundingBox;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.entity.Page;
import es.ua.dlsi.grfia.im3ws.muret.repository.ImageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.PageRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.SymbolRepository;
import es.ua.dlsi.im3.core.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.transaction.Transactional;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
// !!! Important: no controller should throw any exception

@RequestMapping("imagefiles")
@RestController
public class ImageFilesController extends MuRETBaseController {

    @Autowired
    public ImageFilesController(MURETConfiguration muretConfiguration, ImageRepository imageRepository, PageRepository pageRepository, RegionRepository regionRepository, SymbolRepository symbolRepository) {
        super(muretConfiguration, imageRepository, pageRepository, regionRepository, symbolRepository);
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

    private File getImageFile(String documentPath, Long imageID, String imagesRelativePath) throws IM3WSException {
        Image image = getImage(imageID);

        if (documentPath == null) {
            documentPath = image.computeDocument().getPath();
        }

        //avoid another query File documentFolder = new File(muretConfiguration.getFolder(), image.get().getDocument().getPath());
        File documentFolder = new File(muretConfiguration.getFolder(), documentPath);
        File masterImagesFolder = new File(documentFolder, imagesRelativePath);
        File imageFile = new File(masterImagesFolder, image.getFilename());
        if (!imageFile.exists()) {
            throw new IM3WSException("Image '" + imageFile.getAbsolutePath() + "' for image with ID=" + imageID + " does not exist");
        }
        return imageFile;
    }

    @GetMapping(value = "{documentPath}/master/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getMasterImage(@PathVariable("documentPath") String documentPath, @PathVariable("imageID") Long imageID)  {
        try {
            return getImage(documentPath, imageID,  MURETConfiguration.MASTER_IMAGES);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot get master image", e);
        }
    }

    @GetMapping(value = "preview/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    @Transactional
    public ResponseEntity<InputStreamResource> getPreviewImage(@PathVariable("imageID") Long imageID)  {
        try {
            return getImage(null, imageID, MURETConfiguration.PREVIEW_IMAGES);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot get preview image", e);
        }
    }

    @GetMapping(value = "master/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    @Transactional // because we'll get the document path
    public ResponseEntity<InputStreamResource> getMasterImage(@PathVariable("imageID") Long imageID)  {
        try {
            return getImage(null, imageID,  MURETConfiguration.MASTER_IMAGES);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot get master image", e);
        }

    }

    @GetMapping(value = "{documentPath}/thumbnail/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getThumbnailImage(@PathVariable("documentPath") String documentPath, @PathVariable("imageID") Long imageID) {
        try {
            return getImage(documentPath, imageID,  MURETConfiguration.THUMBNAIL_IMAGES);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot get thumnail image", e);
        }

    }
    @GetMapping(value = "{documentPath}/preview/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getPreviewImage(@PathVariable("documentPath") String documentPath, @PathVariable("imageID") Long imageID) {
        try {
            return getImage(documentPath, imageID,  MURETConfiguration.PREVIEW_IMAGES);
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot get preview image", e);
        }
    }

    @GetMapping(value = "croppedImage/{imageID}/{fromX}/{fromY}/{toX}/{toY}", produces = MediaType.IMAGE_JPEG_VALUE)
    @Transactional
    public ResponseEntity<InputStreamResource> getCroppedMasterImageBlob$(@PathVariable("imageID") Long imageID,
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
}
