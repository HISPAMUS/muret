package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.PitchClasses;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticVersion;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticNote;
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
        assertNull(transduction.getErrorMessage());
    }

    @Test
    public void transduceMeterChange() throws FileNotFoundException, IM3Exception {
        String input = "clef.G:L2\tnote.whole:L5\tnote.whole:L5\tdot:L5\tbarline:L1\tbarline:L1\tmetersign.Ct:L3\tnote.whole:S3\tcustos:L3";

        String [] sequence = input.split("\t");
        MensuralAgnostic2SemanticTransducer transducer = new MensuralAgnostic2SemanticTransducer();
        AgnosticEncoding agnosticEncoding = new AgnosticEncoding(AgnosticVersion.v2, sequence);
        SemanticTransduction transduction = transducer.transduce(agnosticEncoding);
        assertNotNull(transduction);
        assertNull(transduction.getErrorMessage());
    }

    @Test
    public void transduceKeySignature() throws FileNotFoundException, IM3Exception {
        String input = "clef.G:L2\taccidental.flat:L3\tnote.whole:L5\tnote.whole:L3";

        String [] sequence = input.split("\t");
        MensuralAgnostic2SemanticTransducer transducer = new MensuralAgnostic2SemanticTransducer();
        AgnosticEncoding agnosticEncoding = new AgnosticEncoding(AgnosticVersion.v2, sequence);
        SemanticTransduction transduction = transducer.transduce(agnosticEncoding);
        assertNotNull(transduction);
        assertNull(transduction.getErrorMessage());

        SemanticSymbol lastSymbol = transduction.getLastSymbol();
        assertTrue("Is a semantic note", lastSymbol.getSymbol() instanceof SemanticNote);
        SemanticNote semanticNote = (SemanticNote) lastSymbol.getSymbol();
        assertEquals("Altered note", PitchClasses.B_FLAT.getPitchClass(), semanticNote.getCoreSymbol().getAtomPitch().getScientificPitch().getPitchClass());
    }    
}
