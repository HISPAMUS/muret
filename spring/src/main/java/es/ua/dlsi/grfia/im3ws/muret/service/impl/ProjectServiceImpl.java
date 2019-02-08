package es.ua.dlsi.grfia.im3ws.muret.service.impl;

import es.ua.dlsi.grfia.im3ws.muret.controller.payload.ProjectStatistics;
import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import es.ua.dlsi.grfia.im3ws.muret.repository.ProjectRepository;
import es.ua.dlsi.grfia.im3ws.muret.service.ProjectService;
import es.ua.dlsi.grfia.im3ws.service.impl.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author drizo
 */
@Service
public class ProjectServiceImpl extends CRUDServiceImpl<Project, Integer, ProjectRepository> implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Override
    protected ProjectRepository initRepository() {
        return projectRepository;
    }

    @Override
    public ProjectStatistics getProjectStatistics(int id) {
        ProjectStatistics projectStatistics = new ProjectStatistics();
        projectStatistics.setImages(projectRepository.getNumberOfImages(id));
        projectStatistics.setPages(projectRepository.getNumberOfPages(id));
        projectStatistics.setRegions(projectRepository.getNumberOfRegions(id));
        projectStatistics.setAgnosticSymbols(projectRepository.getNumberOfAgnosticSymbols(id));
        return projectStatistics;
    }
}

