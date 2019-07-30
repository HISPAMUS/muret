package es.ua.dlsi.grfia.im3ws.muret.entity;

import es.ua.dlsi.im3.core.score.PositionInStaff;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

/**
 * Note this projection must be defined in the same package as the entity class
 * @author drizo
 */
@Projection(name = "excerpt", types = { Symbol.class, AgnosticSymbol.class })
public interface ISymbolProjection {
    @Value("#{target.id}")
    long getId();

    String getComments();
    BoundingBox getBoundingBox();
    Integer getApproximateX();

    // see https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#expressions
    @Value("#{target.getPositionInStaff()}")
    String getPositionInStaff();

    @Value("#{target.getAgnosticSymbolType()}")
    String getAgnosticSymbolType();

    @Value("#{target.getStrokes()}")
    Strokes getStrokes();

    Part getPart();
}
