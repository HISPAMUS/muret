package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.controller.CRUDController;
import es.ua.dlsi.grfia.im3ws.muret.entity.RegionType;
import es.ua.dlsi.grfia.im3ws.muret.service.RegionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/muretapi/regiontypes")
@CrossOrigin("${angular.url}")
@RestController
public class RegionTypeController extends CRUDController<RegionType, Integer, RegionTypeService> {
    @Autowired
    RegionTypeService projectService;

    @Override
    protected RegionTypeService initService() {
        return projectService;
    }
}

