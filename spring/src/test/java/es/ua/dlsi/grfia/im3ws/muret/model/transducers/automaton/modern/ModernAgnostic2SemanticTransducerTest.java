package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.modern;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class ModernAgnostic2SemanticTransducerTest {

    @Test
    public void transduce() throws FileNotFoundException, IM3Exception {
        String input = "clef.G:L2\taccidental.sharp:L5\taccidental.sharp:S3\tnote.whole:L5\taccidental.sharp:S3\tnote.whole:S5\tverticalLine:L1\tnote.whole:S4\tverticalLine:L1\tnote.half_down:S3\tnote.quarter:S3\trest.quarter:L4\tverticalLine:L1\tnote.whole:S4\tverticalLine:L1";

        String [] sequence = input.split("\t");
        ModernAgnostic2SemanticTransducer transducer = new ModernAgnostic2SemanticTransducer();
        AgnosticEncoding agnosticEncoding = new AgnosticEncoding(AgnosticVersion.v2, sequence);
        SemanticTransduction transduction = transducer.transduce(agnosticEncoding);
        assertNotNull(transduction);

    }
}
