package es.ua.dlsi.grfia.im3ws.muret.service.impl;

import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.repository.ImageRepository;
import es.ua.dlsi.grfia.im3ws.muret.service.ImageService;
import es.ua.dlsi.grfia.im3ws.service.impl.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author drizo
 */
@Service
public class ImageServiceImpl extends CRUDServiceImpl<Image, Long, ImageRepository> implements ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Override
    protected ImageRepository initRepository() {
        return imageRepository;
    }
}

