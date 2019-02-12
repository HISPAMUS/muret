package es.ua.dlsi.grfia.im3ws.muret.controller;


import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.controller.CRUDController;
import es.ua.dlsi.grfia.im3ws.muret.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.ProjectStatistics;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.StringBody;
import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import es.ua.dlsi.grfia.im3ws.muret.entity.ProjectURLs;
import es.ua.dlsi.grfia.im3ws.muret.entity.State;
import es.ua.dlsi.grfia.im3ws.muret.model.ProjectModel;
import es.ua.dlsi.grfia.im3ws.muret.service.ProjectService;
import es.ua.dlsi.grfia.im3ws.muret.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author drizo
 */
@RequestMapping("/muretapi/project")
@RestController
public class ProjectController extends CRUDController<Project, Integer, ProjectService> {
    @Autowired
    ProjectService projectService;

    @Autowired
    StateService stateService;

    @Autowired
    MURETConfiguration muretConfiguration;

    @Autowired
    ProjectModel projectModel;

    public ProjectController() {
    }

    @Override
    protected ProjectService initService() {
        return projectService;
    }


    /**
     * It obtains the public path where thumbnails are to be found. We use this method rather than a service returning the images themselves
     * to avoid the server computing things that can be done by the web server
     * @param id
     * @return
     * @throws IM3WSException
     * @deprecated Replace it eturning directly the images from ImageController
     */
    @GetMapping(path = {"/projectURLS/{id}"})
    public ProjectURLs constructThumbnailsURL(@PathVariable("id") Integer id) throws IM3WSException {
        Optional<Project> project = projectService.findById(id);
        if (!project.isPresent()) {
            throw new IM3WSException("Cannot find a project with id " + id);
        }

        return new ProjectURLs(
                muretConfiguration.getUrl() + "/" + project.get().getPath() + "/" + MURETConfiguration.MASTER_IMAGES,
                muretConfiguration.getUrl() + "/" + project.get().getPath() + "/" + MURETConfiguration.THUMBNAIL_IMAGES,
                muretConfiguration.getUrl() + "/" + project.get().getPath() + "/" + MURETConfiguration.PREVIEW_IMAGES);
    }

    @PostMapping(path = {"/new"})
    public Project newProject(@RequestBody Project project) throws IM3WSException {
        return projectModel.newProject(project);
    }

    /* Getters and setters used in command line */
    public MURETConfiguration getMuretConfiguration() {
        return muretConfiguration;
    }

    public void setMuretConfiguration(MURETConfiguration muretConfiguration) {
        this.muretConfiguration = muretConfiguration;
    }

    @GetMapping(path = {"/statistics/{id}"})
    public ProjectStatistics getProjectStatistics(@PathVariable("id") Integer id) throws IM3WSException {
        return projectService.getProjectStatistics(id);
    }

    @PutMapping("/composer/{projectID}")
    public void putComposer(@PathVariable int projectID, @RequestBody StringBody composer) throws IM3WSException {
        Optional<Project> project = projectService.findById(projectID);
        if (!project.isPresent()) {
            throw new IM3WSException("Cannot find a project with id " + projectID);
        }

        project.get().setComposer(composer.getValue());
        projectService.update(project.get());
    }

    @PutMapping("/comments/{projectID}")
    public void putComments(@PathVariable int projectID, @RequestBody StringBody comments) throws IM3WSException {
        Optional<Project> project = projectService.findById(projectID);
        if (!project.isPresent()) {
            throw new IM3WSException("Cannot find a project with id " + projectID);
        }

        project.get().setComments(comments.getValue());
        projectService.update(project.get());
    }

    @PutMapping("/state/{projectID}")
    public void putState(@PathVariable int projectID, @RequestBody(required=false) State state) throws IM3WSException {
        Optional<Project> project = projectService.findById(projectID);
        if (!project.isPresent()) {
            throw new IM3WSException("Cannot find a project with id " + projectID);
        }

        State persistedState;
        if (project.get().getState() == null) {
            persistedState = stateService.create(state);
            project.get().setState(persistedState);
            projectService.update(project.get());
            
        } else {
            if (state == null) {
                Long prevStateID = project.get().getState().getId();
                project.get().setState(null);
                projectService.update(project.get());
                // delete state
                stateService.delete(prevStateID);
            } else {
                // update state
                persistedState = project.get().getState();
                persistedState.setState(state.getState());
                persistedState.setChangedBy(state.getChangedBy());
                persistedState.setComments(state.getComments());
                stateService.update(persistedState);
            }
        }
    }
}
