package es.ua.dlsi.grfia.im3ws.muret.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 * Note this projection must be defined in the same package as the entity class
 * @author drizo
 */
@Projection(name = "excerpt", types = { Document.class })
public interface IDocumentProjection {
    @Value("#{target.id}")
    int getId();

    String getName();
    String getComposer();
    String getComments();
    State getState();
    String getPath();
    String getThumbnailBase64Encoding();
    IPartProjection [] getParts();
}
