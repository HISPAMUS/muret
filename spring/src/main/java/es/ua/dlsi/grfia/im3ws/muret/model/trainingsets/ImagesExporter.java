package es.ua.dlsi.grfia.im3ws.muret.model.trainingsets;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import es.ua.dlsi.im3.core.io.ExportException;
import es.ua.dlsi.im3.core.utils.FileCompressors;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author drizo
 */
public class ImagesExporter extends AbstractTrainingSetExporter {
    public ImagesExporter(int id) {
        super(id, "Images exporter", "It exports the original images in the selected projects in a compressed file");
    }

    @Override
    public Path generate(Path muretFolder, Collection<Project> projectCollection) throws ExportException {
        try {
            Path tgz = Files.createTempFile("images_export", ".tar.gz");
            FileCompressors fileCompressors = new FileCompressors();

            ArrayList<Path> projectPaths = new ArrayList<>();
            ArrayList<String> projectPrefixes = new ArrayList<>();
            projectCollection.forEach(project -> {
                File muretProjectFolder = new File(muretFolder.toFile(), project.getPath());
                File imagesProjectFolder = new File(muretProjectFolder, MURETConfiguration.MASTER_IMAGES);
                projectPaths.add(imagesProjectFolder.toPath());
                projectPrefixes.add(project.getPath());
            });

            fileCompressors.tgzFolders(tgz, projectPaths, projectPrefixes);
            return tgz;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot generate tgz with all image files in selected projects", e);
            throw new ExportException(e);
        }
    }


}
