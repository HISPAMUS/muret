package es.ua.dlsi.grfia.im3ws.muret.service.impl;

import es.ua.dlsi.grfia.im3ws.muret.entity.ClassifierType;
import es.ua.dlsi.grfia.im3ws.muret.repository.ClassifierTypeRepository;
import es.ua.dlsi.grfia.im3ws.muret.service.ClassifierTypeService;
import es.ua.dlsi.grfia.im3ws.service.impl.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author drizo
 */
@Service
public class ClassifierTypeServiceImpl extends CRUDServiceImpl<ClassifierType, Integer, ClassifierTypeRepository> implements ClassifierTypeService {
    @Autowired
    ClassifierTypeRepository classifierTypeRepository;

    @Override
    protected ClassifierTypeRepository initRepository() {
        return classifierTypeRepository;
    }
}

