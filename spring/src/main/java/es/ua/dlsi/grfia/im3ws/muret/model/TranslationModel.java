package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.Agnostic2SemanticTransducer;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.MensuralAgnostic2SemanticTransducer;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.modern.ModernAgnostic2SemanticTransducer;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;

import java.io.FileNotFoundException;

public class TranslationModel {
    public SemanticTransduction computeSemanticFromAgnostic(AgnosticEncoding agnosticEncoding, NotationType notationType) throws FileNotFoundException, IM3Exception, IM3WSException {
        // TODO - otros traductores
        Agnostic2SemanticTransducer agnostic2SemanticTransducer;
        if (notationType == NotationType.eMensural) {
            agnostic2SemanticTransducer = new MensuralAgnostic2SemanticTransducer();
        } else if (notationType == NotationType.eModern) {
            agnostic2SemanticTransducer = new ModernAgnostic2SemanticTransducer();
        } else {
            throw new IM3Exception("No transducer found for notation " + notationType);
        }

        SemanticTransduction semantic = agnostic2SemanticTransducer.transduce(agnosticEncoding);

        if (semantic.getSemanticEncoding().getSymbols().isEmpty()) {
            throw new IM3WSException("Cannot translate from agnostic");
        }

        return semantic;
    }
}
