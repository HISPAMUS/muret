package es.ua.dlsi.grfia.im3ws.muret.service.impl;

import es.ua.dlsi.grfia.im3ws.muret.entity.RegionType;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionTypeRepository;
import es.ua.dlsi.grfia.im3ws.muret.service.RegionTypeService;
import es.ua.dlsi.grfia.im3ws.service.impl.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author drizo
 */
@Service
public class RegionTypeServiceImpl extends CRUDServiceImpl<RegionType, Integer, RegionTypeRepository> implements RegionTypeService {
    @Autowired
    RegionTypeRepository classifierTypeRepository;

    @Override
    protected RegionTypeRepository initRepository() {
        return classifierTypeRepository;
    }
}

