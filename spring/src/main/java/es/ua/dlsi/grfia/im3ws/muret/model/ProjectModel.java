package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import es.ua.dlsi.grfia.im3ws.muret.repository.ProjectRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.UserRepository;
import es.ua.dlsi.im3.core.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Used to be able to work also with command line
 */
@Component
public class ProjectModel {
    private final UserRepository userRepository;

    private final ProjectRepository projectRepository;

    private final MURETConfiguration muretConfiguration;

    @Autowired
    public ProjectModel(UserRepository userRepository, ProjectRepository projectRepository, MURETConfiguration muretConfiguration) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.muretConfiguration = muretConfiguration;
    }

    private File createProjectFileStructure(File parentFolder, String projectBaseName) throws IM3WSException {

        File path = new File(parentFolder, projectBaseName);
        if (path.exists()) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Path '{0}' alredy exists", path.getAbsolutePath());
            throw new IM3WSException("Path '" + projectBaseName + "' already exists in repository");
        }

        if (!path.mkdirs()) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot create path '{0}'", path.getAbsolutePath());
            throw new IM3WSException("Cannot create path '" + projectBaseName);
        }

        return path;
    }

    public Project newProject(Project project) throws IM3WSException {
        Date now = new Date();

        String projectBaseName = FileUtils.leaveValidCaracters(project.getName()).toLowerCase();

        Stack<File> createdFolders = new Stack<>();
        try {

            File muretFolder = new File(muretConfiguration.getFolder());
            if (!muretFolder.exists()) {
                muretFolder = createProjectFileStructure(null, muretConfiguration.getFolder());
            }
            File projectFolder = createProjectFileStructure(muretFolder, projectBaseName);
            createdFolders.push(projectFolder);
            createdFolders.push(createProjectFileStructure(projectFolder, MURETConfiguration.MASTER_IMAGES));
            createdFolders.push(createProjectFileStructure(projectFolder, MURETConfiguration.THUMBNAIL_IMAGES));
            createdFolders.push(createProjectFileStructure(projectFolder, MURETConfiguration.PREVIEW_IMAGES));

            Project newProject = new Project(project.getName(),
                    projectBaseName,
                    project.getComposer(),
                    now,
                    now,
                    project.getCreatedBy(),
                    null,
                    project.getThumbnailBase64Encoding(),
                    project.getComments(),
                    null,
                    project.getNotationType(),
                    project.getManuscriptType(),
                    null,
                    null
            );

            return projectRepository.save(newProject);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot create project", e);
            while (!createdFolders.empty()) {
                File folder = createdFolders.pop();
                folder.delete();
            }
            throw e;
        }
    }

    /**
     * It generates a zip file containing the whole project file, mrt plus the image set
     * @param project
     * @return
     */
    public File exportFullProject(Project project) {
        throw new UnsupportedOperationException("TO-DO");
    }
}
