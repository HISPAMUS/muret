package es.ua.dlsi.grfia.im3ws.muret.service.impl;

import es.ua.dlsi.grfia.im3ws.muret.entity.Page;
import es.ua.dlsi.grfia.im3ws.muret.repository.PageRepository;
import es.ua.dlsi.grfia.im3ws.muret.service.PageService;
import es.ua.dlsi.grfia.im3ws.service.impl.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author drizo
 */
@Service
public class PageServiceImpl extends CRUDServiceImpl<Page, Long, PageRepository> implements PageService {
    @Autowired
    PageRepository pageRepository;

    @Override
    protected PageRepository initRepository() {
        return pageRepository;
    }
}

