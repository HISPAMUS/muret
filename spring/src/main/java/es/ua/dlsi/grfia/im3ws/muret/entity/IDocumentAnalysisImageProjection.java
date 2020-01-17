package es.ua.dlsi.grfia.im3ws.muret.entity;

import es.ua.dlsi.im3.core.score.NotationType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

/**
 * Note this projection must be defined in the same package as the entity class
 * @author drizo
 */
@Projection(name = "documentAnalysisImage", types = { Image.class })
public interface IDocumentAnalysisImageProjection {
    @Value("#{target.id}")
    long getId();

    State getState();
    String getFilename();
    String getWidth();
    String getHeight();
    String getComments();

    @Value("#{target.document.path}")
    String getDocumentPath();


    @Value("#{target.document.manuscriptType}")
    ManuscriptType getManuscriptType();

    @Value("#{target.document.notationType}")
    NotationType getNotationType();

    List<IPageProjection> getPages();

    IPartProjection getPart();

    @Value("#{target.document.id}")
    int getDocumentId();

    @Value("#{target.document.parts}")
    List<IPartProjection> getDocumentParts();

}
