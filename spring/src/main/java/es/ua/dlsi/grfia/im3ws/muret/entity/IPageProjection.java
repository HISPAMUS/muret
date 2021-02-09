package es.ua.dlsi.grfia.im3ws.muret.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

/**
 * Note this projection must be defined in the same package as the entity class
 * @author drizo
 */
@Projection(name = "excerpt", types = { Page.class })
public interface IPageProjection {
    @Value("#{target.id}")
    long getId();

    String getComments();
    BoundingBox getBoundingBox();

    Set<IRegionProjection> getRegions();

}
