package es.ua.dlsi.grfia.im3ws.muret.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 * Note this projection must be defined in the same package as the entity class
 * @author drizo
 */
@Projection(name = "excerpt", types = { RegionInteractionType.class })
public interface IRegionInteractionTypeProjection {
    @Value("#{target.id}")
    int getId();

    String getName();
}