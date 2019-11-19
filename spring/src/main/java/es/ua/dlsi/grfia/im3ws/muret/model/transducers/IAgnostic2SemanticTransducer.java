package es.ua.dlsi.grfia.im3ws.muret.model.transducers;

import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;

public interface IAgnostic2SemanticTransducer {
    SemanticTransduction transduce(AgnosticEncoding agnosticEncoding) throws IM3Exception;
}
