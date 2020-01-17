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
        Image image = getImage(imageID);

        if (documentPath == null) {
            documentPath = image.getDocument().getPath();
        }

        //avoid another query File documentFolder = new File(muretConfiguration.getFolder(), image.get().getDocument().getPath());
        File documentFolder = new File(muretConfiguration.getFolder(), documentPath);
        File masterImagesFolder = new File(documentFolder, imagesRelativePath);
        File imageFile = new File(masterImagesFolder, image.getFilename());
        if (!imageFile.exists()) {
            throw new IM3WSException("Image '" + imageFile.getAbsolutePath() + "' for image with ID=" + imageID + " does not exist");
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG) //TODO Siempre devolver JPEG, si no los tenemos cambiarlos
                .body(new InputStreamResource(new FileInputStream(imageFile)));

    }

    @GetMapping(value = "{documentPath}/master/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getMasterImage(@PathVariable("documentPath") String documentPath, @PathVariable("imageID") Long imageID) throws IM3WSException, FileNotFoundException {
        return getImage(documentPath, imageID,  MURETConfiguration.MASTER_IMAGES);
    }
    @GetMapping(value = "master/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    @Transactional // because we'll get the document path
    public ResponseEntity<InputStreamResource> getMasterImage(@PathVariable("imageID") Long imageID) throws IM3WSException, FileNotFoundException {
        return getImage(null, imageID,  MURETConfiguration.MASTER_IMAGES);
    }

    @GetMapping(value = "{documentPath}/thumbnail/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getThumbnailImage(@PathVariable("documentPath") String documentPath, @PathVariable("imageID") Long imageID) throws IM3WSException, FileNotFoundException {
        return getImage(documentPath, imageID,  MURETConfiguration.THUMBNAIL_IMAGES);
    }
    @GetMapping(value = "{documentPath}/preview/{imageID}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getPreviewImage(@PathVariable("documentPath") String documentPath, @PathVariable("imageID") Long imageID) throws IM3WSException, FileNotFoundException {
        return getImage(documentPath, imageID,  MURETConfiguration.PREVIEW_IMAGES);
    }

}
