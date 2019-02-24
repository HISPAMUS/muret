package es.ua.dlsi.grfia.im3ws.muret.entity;

import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

/**
 * Note this projection must be defined in the same package as the entity class
 * @author drizo
 */
@Projection(name = "excerpt", types = { Symbol.class })
public interface ISymbolProjection {
    @Value("#{target.id}")
    long getId();

    String getComments();
    BoundingBox getBoundingBox();

    AgnosticSymbol getAgnosticSymbol();

}
