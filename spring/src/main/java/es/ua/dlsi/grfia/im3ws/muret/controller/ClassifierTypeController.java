package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.controller.CRUDController;
import es.ua.dlsi.grfia.im3ws.muret.entity.ManuscriptType;
import es.ua.dlsi.grfia.im3ws.muret.entity.ClassifierType;
import es.ua.dlsi.grfia.im3ws.muret.entity.SVGSet;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticSymbolFont;
import es.ua.dlsi.grfia.im3ws.muret.model.AgnosticSymbolFontSingleton;
import es.ua.dlsi.grfia.im3ws.muret.service.ClassifierTypeService;
import es.ua.dlsi.grfia.im3ws.muret.service.ProjectService;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.layout.LayoutConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestMapping("/muretapi/classifiers")
@CrossOrigin("${angular.url}")
@RestController
public class ClassifierTypeController extends CRUDController<ClassifierType, Integer, ClassifierTypeService> {
    @Autowired
    ClassifierTypeService projectService;

    @Override
    protected ClassifierTypeService initService() {
        return projectService;
    }
}

