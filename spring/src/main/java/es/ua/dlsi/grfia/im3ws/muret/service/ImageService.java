package es.ua.dlsi.grfia.im3ws.muret.service;


import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.service.ICRUDService;

/**
 * The resulting project will contain up to the images lazily loaded, in order to load each image with full contents use ImageService
 * @author drizo
 */
public interface ImageService extends ICRUDService<Image, Long> {
}
