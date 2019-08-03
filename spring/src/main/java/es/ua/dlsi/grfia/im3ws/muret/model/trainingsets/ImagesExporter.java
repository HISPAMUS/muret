package es.ua.dlsi.grfia.im3ws.muret.model.trainingsets;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.model.ProjectModel;
import es.ua.dlsi.im3.core.IM3Exception;
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
    ProjectModel projectModel;

    public ImagesExporter(ProjectModel projectModel, int id, boolean overlayBoundingBoxes) {
        super(id, "Images exporter" + (overlayBoundingBoxes ?" with bounding boxes":""), "It exports the original images " + (overlayBoundingBoxes ?" with bounding boxes":"") + " in the selected projects in a compressed file", false);
        this.overlayBoundingBoxes = overlayBoundingBoxes;
        this.projectModel = projectModel;
    }

    @Override
    public Path generate(Path muretFolder, Collection<Project> projectCollection) throws ExportException {
        try {
            Path tgz = Files.createTempFile("images_export", ".tar.gz");
            FileCompressors fileCompressors = new FileCompressors();

            ArrayList<Path> projectPaths = new ArrayList<>();
            ArrayList<String> projectPrefixes = new ArrayList<>();
            ArrayList<File> tmpDirectoriesToDelete = new ArrayList<>();
            for (Project project: projectCollection) {
                File muretProjectFolder = new File(muretFolder.toFile(), project.getPath());
                File imagesProjectFolder = new File(muretProjectFolder, MURETConfiguration.MASTER_IMAGES);

                if (overlayBoundingBoxes) {
                    File tmpDirectory = generateOverlay(imagesProjectFolder, project);
                    tmpDirectoriesToDelete.add(tmpDirectory);
                    projectPaths.add(tmpDirectory.toPath());
                } else {
                    projectPaths.add(imagesProjectFolder.toPath());
                }

                projectPrefixes.add(project.getPath());
            }

            fileCompressors.tgzFolders(tgz, projectPaths, projectPrefixes);
            for (File tmpDirectory: tmpDirectoriesToDelete) {
                //// tmpDirectory.delete();
                System.err.println("TODO Borrarrrrr " + tmpDirectory.toString());
            }
            return tgz;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot generate tgz with all image files in selected projects", e);
            throw new ExportException(e);
        }
    }

    /**
     * It creates a new image with the bounding boxes drawn over it
     * @param imagesProjectFolder
     * @param project
     */
    private File generateOverlay(File imagesProjectFolder, Project project) throws IOException {
        Path tmpDirectory = Files.createTempDirectory(imagesProjectFolder.getName());

        Path projectFolder = projectModel.getProjectFolder(project);
        for (Image image: project.getImages()) {
            Path imagePath = Paths.get(projectFolder.toFile().getPath(), MURETConfiguration.MASTER_IMAGES, image.getFilename());
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
