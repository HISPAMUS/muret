package es.ua.dlsi.grfia.im3ws.muret.model.trainingsets;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.model.DocumentModel;
import es.ua.dlsi.im3.core.io.ExportException;
import es.ua.dlsi.im3.core.utils.FileCompressors;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author drizo
 */
public class ImagesExporter extends AbstractTrainingSetExporter {
    boolean overlayBoundingBoxes;
    DocumentModel documentModel;

    public ImagesExporter(DocumentModel documentModel, int id, boolean overlayBoundingBoxes) {
        super(id, "Images exporter" + (overlayBoundingBoxes ?" with bounding boxes":""), "It exports the original images " + (overlayBoundingBoxes ?" with bounding boxes":"") + " in the selected documents in a compressed file", false);
        this.overlayBoundingBoxes = overlayBoundingBoxes;
        this.documentModel = documentModel;
    }

    @Override
    public Path generate(Path muretFolder, Collection<Document> documentCollection) throws ExportException {
        try {
            Path tgz = Files.createTempFile("images_export", ".tar.gz");
            FileCompressors fileCompressors = new FileCompressors();

            ArrayList<Path> documentPaths = new ArrayList<>();
            ArrayList<String> documentPrefixes = new ArrayList<>();
            ArrayList<File> tmpDirectoriesToDelete = new ArrayList<>();
            for (Document document : documentCollection) {
                File muretDocumentFolder = new File(muretFolder.toFile(), document.getPath());
                File imagesDocumentFolder = new File(muretDocumentFolder, MURETConfiguration.MASTER_IMAGES);

                if (overlayBoundingBoxes) {
                    File tmpDirectory = generateOverlay(imagesDocumentFolder, document);
                    tmpDirectoriesToDelete.add(tmpDirectory);
                    documentPaths.add(tmpDirectory.toPath());
                } else {
                    documentPaths.add(imagesDocumentFolder.toPath());
                }

                documentPrefixes.add(document.getPath());
            }

            fileCompressors.tgzFolders(tgz, documentPaths, documentPrefixes);
            for (File tmpDirectory: tmpDirectoriesToDelete) {
                //// tmpDirectory.delete();
                System.err.println("TODO Borrarrrrr " + tmpDirectory.toString());
            }
            return tgz;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot generate tgz with all image files in selected documents", e);
            throw new ExportException(e);
        }
    }

    /**
     * It creates a new image with the bounding boxes drawn over it
     * @param imagesDocumentFolder
     * @param document
     */
    private File generateOverlay(File imagesDocumentFolder, Document document) throws IOException {
        Path tmpDirectory = Files.createTempDirectory(imagesDocumentFolder.getName());

        Path documentFolder = documentModel.getDocumentFolder(document);
        for (Image image: document.getImages()) {
            Path imagePath = Paths.get(documentFolder.toFile().getPath(), MURETConfiguration.MASTER_IMAGES, image.getFilename());
            File imageFile = imagePath.toFile();
            if (!imageFile.exists()) {
                throw new IOException("Image " + imageFile.toString() + " does not exist");
            }
            BufferedImage bufferedImage = ImageIO.read(imageFile);

            Graphics2D graphics2D = bufferedImage.createGraphics();

            if (graphics2D == null) {
                throw new IOException("Cannot get graphics context from image");
            }

            for (Page page:  image.getPages()) {
                for (Region region: page.getRegions()) {
                    drawBoundingBox(graphics2D, region.getBoundingBox(), Color.BLUE);
                    drawString(graphics2D, region.getBoundingBox().getFromX(), region.getBoundingBox().getFromY(), region.getId().toString(), Color.BLUE);
                    for (Symbol symbol: region.getSymbols()) {
                        Integer x = null;
                        Integer y = null;
                        if (symbol.getApproximateX() != null) {
                            x = symbol.getApproximateX();
                            y = region.getBoundingBox().getFromY();
                            drawLine(graphics2D, symbol.getApproximateX(), region.getBoundingBox().getFromY(), region.getBoundingBox().getToY(), Color.ORANGE);
                        } else if (symbol.getBoundingBox() != null) {
                            x = symbol.getBoundingBox().getFromX();
                            y = symbol.getBoundingBox().getFromY();
                            drawBoundingBox(graphics2D, symbol.getBoundingBox(), Color.RED);
                        }

                        if (x != null && y != null) {
                            drawString(graphics2D, x, y, symbol.getId().toString(), Color.RED);
                        }
                    }
                }
            }

            ImageIO.write(bufferedImage, "JPEG", new File(tmpDirectory.toFile(), image.getFilename()));
        }


        return tmpDirectory.toFile();
    }

    private void drawLine(Graphics2D graphics2D, int x, int fromY, int toY, Color color) {
        graphics2D.setColor(color);
        graphics2D.drawLine(x, fromY, x, toY);
    }

    private void drawString(Graphics2D graphics2D, int x, int y, String str, Color color) {
        graphics2D.setColor(color);
        graphics2D.drawString(str, x, y);

    }

    private void drawBoundingBox(Graphics2D graphics2D, BoundingBox boundingBox, Color color) {
        graphics2D.setColor(color);
        graphics2D.drawRect(boundingBox.getFromX(), boundingBox.getFromY(), boundingBox.getWidth(), boundingBox.getHeight());
    }


}
