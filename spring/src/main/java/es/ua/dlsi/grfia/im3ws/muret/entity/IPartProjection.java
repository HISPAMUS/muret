package es.ua.dlsi.grfia.im3ws.muret.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 * Note this projection must be defined in the same package as the entity class
 * @author drizo
 */
@Projection(name = "excerpt", types = { Part.class })
public interface IPartProjection {
    @Value("#{target.id}")
    long getId();

    String getName();
    String getComments();
    Integer getOrdering();


}
