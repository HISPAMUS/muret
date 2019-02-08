package es.ua.dlsi.grfia.im3ws.muret.service.impl;

import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.grfia.im3ws.muret.service.RegionService;
import es.ua.dlsi.grfia.im3ws.service.impl.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author drizo
 */
@Service
public class RegionServiceImpl extends CRUDServiceImpl<Region, Long, RegionRepository> implements RegionService {
    @Autowired
    RegionRepository regionRepository;

    @Override
    protected RegionRepository initRepository() {
        return regionRepository;
    }
}

