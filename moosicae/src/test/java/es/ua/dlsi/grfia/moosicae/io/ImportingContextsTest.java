package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.CoreFactory;
import es.ua.dlsi.grfia.moosicae.core.IChord;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.IChordBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IDiatonicPitchBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IFigureBuilder;
import es.ua.dlsi.grfia.moosicae.core.builders.IPitchBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 22/03/2020
 */
public class ImportingContextsTest {

    // this example simulates a parsing session
    @Test
    public void test() throws IMException {
        ImportingContexts importingContexts = new ImportingContexts();

        ICoreAbstractFactory coreFactory = new CoreFactory().create();

        importingContexts.begin("chord", new IChordBuilder(coreFactory));

        importingContexts.begin("figure", new IFigureBuilder(coreFactory));
        importingContexts.addObjectToPool(EFigures.WHOLE);
        importingContexts.end("figure");

        importingContexts.begin("pitch", new IPitchBuilder(coreFactory));
        importingContexts.addObjectToPool(coreFactory.createOctave(coreFactory.createId(), 4));
        importingContexts.begin("diatonicPitch", new IDiatonicPitchBuilder(coreFactory));
        importingContexts.addObjectToPool(EDiatonicPitches.B);
        importingContexts.end("diatonicPitch");
        importingContexts.end("pitch");

        importingContexts.begin("pitch", new IPitchBuilder(coreFactory));
        importingContexts.addObjectToPool(coreFactory.createOctave(coreFactory.createId(), 5));
        importingContexts.begin("diatonicPitch", new IDiatonicPitchBuilder(coreFactory));
        importingContexts.addObjectToPool(EDiatonicPitches.D);
        importingContexts.end("diatonicPitch");
        importingContexts.end("pitch");

        IChord chord = (IChord) importingContexts.end("chord");
        System.out.println(chord.toString());
        assertEquals(2, chord.getPitches().length);
    }}
