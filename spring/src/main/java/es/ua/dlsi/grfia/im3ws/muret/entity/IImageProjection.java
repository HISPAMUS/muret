package es.ua.dlsi.grfia.im3ws.muret.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;
import java.util.Set;

/**
 * Note this projection must be defined in the same package as the entity class
 * @author drizo
 */
@Projection(name = "excerpt", types = { Image.class })
public interface IImageProjection {
    @Value("#{target.id}")
    long getId();

    State getState();
    String getFilename();
    Integer getOrdering();
    boolean isHidden();

    //TODO Ver si esto lo usamos
    /*Part getPart();

    @Value("#{target.document.parts}")
    Set<Part> getDocumentParts();*/
}
