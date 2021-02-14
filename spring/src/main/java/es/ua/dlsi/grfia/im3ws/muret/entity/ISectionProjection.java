package es.ua.dlsi.grfia.im3ws.muret.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;
import java.util.Set;

/**
 * Note this projection must be defined in the same package as the entity class
 * @author drizo
 */
@Projection(name = "excerpt", types = { Section.class })
public interface ISectionProjection {
    @Value("#{target.id}")
    long getId();

    String getName();

    List<IImageProjection> getImages();
    Integer getOrdering();
}
