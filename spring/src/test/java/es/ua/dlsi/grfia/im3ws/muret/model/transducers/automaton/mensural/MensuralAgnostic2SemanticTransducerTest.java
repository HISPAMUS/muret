package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.SemanticTransduction;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class MensuralAgnostic2SemanticTransducerTest {

    @Test
    public void transduce() throws FileNotFoundException, IM3Exception {
        String input = "clef.G:L2\tmetersign.Ct:L3\tligature:L4\tnote.whole:L5\taccidental.sharp:S3\tnote.whole:S5\tnote.whole:S4\tnote.whole:L4\tdot:S3\tnote.half_down:S3\tnote.whole:L3\tnote.whole:S3\tligature:L4\tligature:S2\trest.whole:L4\tnote.whole:S4\tnote.whole:L4\tnote.whole:S3\tcustos:L3";

        String [] sequence = input.split("\t");
        MensuralAgnostic2SemanticTransducer transducer = new MensuralAgnostic2SemanticTransducer();
        AgnosticEncoding agnosticEncoding = new AgnosticEncoding(AgnosticVersion.v2, sequence);
        SemanticTransduction transduction = transducer.transduce(agnosticEncoding);
        assertNotNull(transduction);
    }
}
