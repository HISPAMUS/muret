package es.ua.dlsi.grfia.moosicae.io;



import static org.junit.Assert.*;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import es.ua.dlsi.grfia.moosicae.core.enums.EFigures;
import es.ua.dlsi.grfia.moosicae.io.kern.KernExporter;
import es.ua.dlsi.grfia.moosicae.io.kern.KernImporter;
import es.ua.dlsi.grfia.moosicae.io.mei.MEIExporter;
import es.ua.dlsi.grfia.moosicae.io.mei.MEIImporter;
import es.ua.dlsi.grfia.moosicae.io.mon.MONExporter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.MusicXMLImporter;
import es.ua.dlsi.grfia.moosicae.utils.TestFileUtils;
import org.junit.Test;

import java.io.File;
import java.util.function.Function;

/**
 * @author drizo
 */
public class KernImporterTest {
    boolean testExportImport = true;
    ICoreAbstractFactory coreAbstractFactory = new CoreFactory().create();

    private IScore importMusicXML(File file) throws IMException {
        MusicXMLImporter importer = new MusicXMLImporter(coreAbstractFactory);
        IScore song = importer.importScore(file);
        return song;
    }

    private IScore importMEI(File file) throws IMException {
        MEIImporter importer = new MEIImporter(coreAbstractFactory);
        IScore song = importer.importScore(file);
        return song;
    }

    private IScore importKern(File file) throws IMException {
        KernImporter importer = new KernImporter(coreAbstractFactory);
        IScore song = importer.importScore(file);
        return song;
    }

    private void doTest(Function<IScore, Void> validationFunction, IScore song) throws Exception {
        validationFunction.apply(song);
        /*TODO KernExporter exporter = new KernExporter();
        File file = TestFileUtils.createTempFile("aa.krn");
        //File file = File.createTempFile("export", "mei");
        //File file = new File("/tmp/aa.krn");
        exporter.exportScore(song, file);

        if (testExportImport) {
            IScore importedSong = importKern(file);
            validationFunction.apply(importedSong);
        }*/
    }

    // ------------------------------------------------------------------------------------------
    private static Void assertGuideExample2_1(IScore song) {
        /*try {
            Key ks = song.getUniqueKeyWithOnset(Time.TIME_ZERO);
            assertNotNull("Key signature" , ks);
            assertEquals(PitchClasses.F.getPitchClass(), ks.getPitchClass());
            //assertEquals(Mode.MAJOR, ks.getMode()); The krn does not specify it

            assertEquals("Parts", 1, song.getParts().size());

            assertEquals(1, song.getStaves().size());
            Staff staff = song.getStaves().get(0);
            assertEquals("Layers", 1, staff.getLayers().size());
            assertTrue(staff.getClefAtTime(Time.TIME_ZERO) instanceof ClefG2);

            TimeSignature ts = staff.getTimeSignatureWithOnset(Time.TIME_ZERO);
            assertTrue(ts instanceof FractionalTimeSignature);
            FractionalTimeSignature meter = (FractionalTimeSignature) ts;
            assertEquals(2, meter.getNumerator());
            assertEquals(2, meter.getDenominator());
            List<Atom> atoms = staff.getAtoms();
            assertEquals(9, atoms.size());
            assertEquals("Atoms in layer" , 9, staff.getLayers().get(0).getAtoms().size());


            assertEquals(4, song.getMeaureCount());

            assertTrue(atoms.get(8) instanceof SimpleRest);

            SimpleNote n0 = (SimpleNote) atoms.get(0);
            assertEquals(PitchClasses.D.getPitchClass(), n0.getPitch().getPitchClass());
            assertEquals(4, n0.getPitch().getOctave());
            assertEquals(Figures.HALF, n0.getAtomFigure().getFigure());
            assertEquals(0, n0.getAtomFigure().getDots());
            assertEquals(0.0, n0.getTime().getComputedTime(), 0.0001);

            assertEquals(2.0, atoms.get(1).getTime().getComputedTime(), 0.0001);

            SimpleNote n4 = (SimpleNote) atoms.get(4);
            assertEquals(PitchClasses.C_SHARP.getPitchClass(), n4.getPitch().getPitchClass());
            assertEquals(4, n4.getPitch().getOctave());

            SimpleNote n5 = (SimpleNote) atoms.get(5);
            assertEquals(PitchClasses.D.getPitchClass(), n5.getPitch().getPitchClass());
            assertEquals(4, n5.getPitch().getOctave());
            assertEquals(Figures.QUARTER, n5.getAtomFigure().getFigure());
            assertEquals(0, n5.getAtomFigure().getDots());


        } catch (Throwable t) {
            t.printStackTrace();
            fail(t.toString());
        }*/
        return null;
    }


    @Test
    public void testGuideExample2_1() throws Exception {
        testExportImport = false;
        //doTest(KernImporterTest::assertGuideExample2_1, importMusicXML(TestFileUtils.getFile("/testdata/io/kern/guide02-example2-1.xml")));
        doTest(KernImporterTest::assertGuideExample2_1, importKern(TestFileUtils.getFile("/testdata/io/kern/guide02-example2-1.krn")));
    }

    // ------------------------------------------------------------------------------------------

    private static Void assertGuideExample2_2(IScore song) {
       /* try {
            assertEquals("Staves", 2, song.getStaves().size());
            Staff staff1 = song.getStaves().get(0);
            assertTrue("G2", staff1.getClefAtTime(Time.TIME_ZERO) instanceof ClefG2);
            TimeSignature ts = staff1.getTimeSignatureWithOnset(Time.TIME_ZERO);
            assertTrue("Fractional meter", ts instanceof FractionalTimeSignature);
            FractionalTimeSignature meter = (FractionalTimeSignature) ts;
            assertEquals( "Numerator", 3, meter.getNumerator());
            assertEquals("Denominator", 4, meter.getDenominator());


            Staff staff2 = song.getStaves().get(1);
            assertTrue("F4", staff2.getClefAtTime(Time.TIME_ZERO) instanceof ClefF4);
            TimeSignature ts2 = staff1.getTimeSignatureWithOnset(Time.TIME_ZERO);
            assertTrue("Fractional meter", ts2 instanceof FractionalTimeSignature);
            FractionalTimeSignature meter2 = (FractionalTimeSignature) ts2;
            assertEquals("Numerator", 3, meter2.getNumerator());
            assertEquals("Denominator", 4, meter2.getDenominator());

            Key ks = song.getUniqueKeyWithOnset(Time.TIME_ZERO);
            assertEquals(PitchClasses.F.getPitchClass(), ks.getPitchClass());

            List<Atom> atoms1 = staff1.getAtoms();
            assertEquals(21, atoms1.size());

            List<Atom> atoms2 = staff2.getAtoms();
            assertEquals(15, atoms2.size());

            assertTrue("Rest 1, staff 1", atoms1.get(0) instanceof SimpleRest);
            assertEquals("Duration first rest staff 1", 0.5, atoms1.get(0).getQuarterRatioDuration(), 0.001);

            assertTrue("Rest 1, staff 2", atoms1.get(0) instanceof SimpleRest);
            assertEquals("Duration first rest staff 2", 3, atoms2.get(0).getQuarterRatioDuration(), 0.001);

            //assertEquals(4, song.getMeaureCount()); actually the last measure is empty

            assertTrue("Note 2, staff 1", atoms1.get(1) instanceof SimpleNote);
            assertEquals("Duration note 2 staff 1", 0.5, atoms1.get(1).getQuarterRatioDuration(), 0.001);
            assertEquals("Pitch note 2 staff 1", PitchClasses.D.getPitchClass(), ((SimpleNote)atoms1.get(1)).getPitch().getPitchClass());

            assertTrue("Last note, staff 1", atoms1.get(20) instanceof SimpleNote);
            assertEquals("Duration last note staff 1", 0.5, atoms1.get(20).getQuarterRatioDuration(), 0.001);
            assertEquals("Pitch last note staff 1", PitchClasses.A_FLAT.getPitchClass(), ((SimpleNote)atoms1.get(20)).getPitch().getPitchClass());

            assertTrue("Last note, staff 2", atoms2.get(14) instanceof SimpleNote);
            assertEquals("Duration last note staff 2", 1, atoms2.get(14).getQuarterRatioDuration(), 0.001);
            assertEquals("Pitch last note staff 2", PitchClasses.D.getPitchClass(), ((SimpleNote)atoms2.get(14)).getPitch().getPitchClass());
            assertEquals("Octave last note staff 2", 3, ((SimpleNote)atoms2.get(14)).getPitch().getOctave());

            //TODO Comprobar mordente en staff 2

        } catch (Throwable t) {
            t.printStackTrace();
            fail(t.toString());
        }*/
        return null;
    }


    @Test
    public void testGuideExample2_2() throws Exception {
        //doTest(KernImporterTest::assertGuideExample2_2, importMusicXML(TestFileUtils.getFile("/testdata/io/kern/guide02-example2-2.xml")));
        doTest(KernImporterTest::assertGuideExample2_2, importKern(TestFileUtils.getFile("/testdata/io/kern/guide02-example2-2.krn")));
    }

    // ------------------------------------------------------------------------------------------

    private static Void assertGuideExample2_3(IScore song) {
       /* try {
            assertEquals("Staves", 2, song.getStaves().size());
            Staff staff1 = song.getStaves().get(0);
            assertTrue("G2", staff1.getClefAtTime(Time.TIME_ZERO) instanceof ClefG2);
            TimeSignature ts = staff1.getTimeSignatureWithOnset(Time.TIME_ZERO);

            Staff staff2 = song.getStaves().get(1);
            assertTrue("F4", staff2.getClefAtTime(Time.TIME_ZERO) instanceof ClefF4);
            TimeSignature ts2 = staff1.getTimeSignatureWithOnset(Time.TIME_ZERO);

            Key ks = song.getUniqueKeyWithOnset(Time.TIME_ZERO);
            assertEquals(PitchClasses.A.getPitchClass(), ks.getPitchClass());

            assertEquals("First staff layers", 2, staff1.getLayers().size());
            assertEquals("Second staff layers", 2, staff1.getLayers().size());

            for (Staff staff: song.getStaves()) {
                for (ScoreLayer layer: staff.getLayers()) {
                    assertTrue("First element in " + layer + " is a note", layer.getAtom(0) instanceof SimpleNote);
                }
            }

            List<Atom> atoms1_top = staff1.getLayers().get(0).getAtoms();
            List<Atom> atoms1_bottom = staff1.getLayers().get(1).getAtoms();
            SimpleNote n1_1 = (SimpleNote) atoms1_top.get(0);
            SimpleNote n1_2 = (SimpleNote) atoms1_bottom.get(0);
            if (n1_1.getPitch().getPitchClass().equals(PitchClasses.E.getPitchClass())) {
                assertEquals("First note of first staff, bottom layer", PitchClasses.A.getPitchClass(), n1_2.getPitch().getPitchClass());
            } else if (n1_1.getPitch().getPitchClass().equals(PitchClasses.A.getPitchClass())) {
                assertEquals("First note of first staff, bottom layer", PitchClasses.E.getPitchClass(), n1_2.getPitch().getPitchClass());
                // switch layers
                List<Atom> aux = atoms1_top;
                atoms1_top = atoms1_bottom;
                atoms1_bottom = aux;
            } else {
                fail("Staff 1, first note is not A or E");
            }


            List<Atom> atoms2_top = staff2.getLayers().get(0).getAtoms();
            List<Atom> atoms2_bottom = staff2.getLayers().get(1).getAtoms();

            SimpleNote n2_1 = (SimpleNote) atoms2_top.get(0);
            SimpleNote n2_2 = (SimpleNote) atoms2_bottom.get(0);
            if (n2_1.getPitch().getPitchClass().equals(PitchClasses.C_SHARP.getPitchClass())) {
                assertEquals("First note of second staff, bottom layer", PitchClasses.A.getPitchClass(), n2_2.getPitch().getPitchClass());
            } else if (n2_1.getPitch().getPitchClass().equals(PitchClasses.A.getPitchClass())) {
                assertEquals("First note of second staff, bottom layer", PitchClasses.C_SHARP.getPitchClass(), n2_2.getPitch().getPitchClass());
                // switch layers
                List<Atom> aux = atoms2_top;
                atoms2_top = atoms2_bottom;
                atoms2_bottom = aux;
            } else {
                fail("Staff 2, first note is not A or C#");
            }


            assertEquals("Staff 1, top layer", 16, atoms1_top.size());
            assertEquals("Staff 1, bottom layer", 17, atoms1_bottom.size());
            assertTrue("Staff 1, bottom layer, 7th element is rest", atoms1_bottom.get(6) instanceof SimpleRest);
            assertEquals("Staff 2, top layer", 18, atoms2_top.size());
            assertEquals("Staff 2, bottom layer", 21, atoms2_bottom.size());

            SimpleNote n12 = (SimpleNote) atoms1_bottom.get(11);
            assertEquals("Staff 1, bottom layer, 12th note pitch class", PitchClasses.A.getPitchClass(), n12.getPitch().getPitchClass());
            assertEquals("Staff 1, bottom layer, 12th note octave", 4, n12.getPitch().getOctave());
            assertTrue("Staff 1, bottom layer, 12th note is tied to next", n12.getAtomPitch().isTiedToNext());

            SimpleNote n13 = (SimpleNote) atoms1_bottom.get(12);
            assertEquals("Staff 1, bottom layer, 13th note pitch class", PitchClasses.A.getPitchClass(), n13.getPitch().getPitchClass());
            assertEquals("Staff 1, bottom layer, 13th note octave", 4, n13.getPitch().getOctave());
            assertTrue("Staff 1, bottom layer, 13th note is tied from previous", n13.getAtomPitch().isTiedFromPrevious());

            SimpleNote tn12 = (SimpleNote) atoms1_top.get(11);
            assertEquals("Staff 1, top layer, 12th note pitch class", PitchClasses.C_SHARP.getPitchClass(), tn12.getPitch().getPitchClass());
            assertEquals("Staff 1, top layer, 12th note octave", 5, tn12.getPitch().getOctave());
            assertEquals("Staff 1, top layer, 12th note dots", 1, tn12.getAtomFigure().getDots());
            assertEquals("Staff 1, top layer, 12th note duration", Figures.EIGHTH, tn12.getAtomFigure().getFigure());

            SimpleNote tn13 = (SimpleNote) atoms1_top.get(12);
            assertEquals("Staff 1, top layer, 13th note pitch class", PitchClasses.D.getPitchClass(), tn13.getPitch().getPitchClass());
            assertEquals("Staff 1, top layer, 13th note octave", 5, tn13.getPitch().getOctave());
            assertEquals("Staff 1, top layer, 13th note dots", 0, tn13.getAtomFigure().getDots());
            assertEquals("Staff 1, top layer, 13th note duration", Figures.SIXTEENTH, tn13.getAtomFigure().getFigure());


            assertTrue("Anacrusis" , song.isAnacrusis());
            assertEquals("Anacrusis offset", new Time(3, 1), song.getAnacrusisOffset());

            assertNotNull("Staff 1, top layer, first fermata", atoms1_top.get(5).getAtomFigures().get(0).getFermata());
            assertNotNull("Staff 1, top layer, second fermata", atoms1_top.get(14).getAtomFigures().get(0).getFermata());
            //Not in MusicXML example assertNotNull("Staff 1, bottom layer, first fermata", atoms1_bottom.get(5).getAtomFigures().get(0).getFermata());
            //Not in MusicXML example assertNotNull("Staff 1, bottom layer, second fermata", atoms1_bottom.get(15).getAtomFigures().get(0).getFermata());
            //Not in MusicXML example assertNotNull("Staff 2, top layer, first fermata", atoms2_top.get(5).getAtomFigures().get(0).getFermata());
            //Not in MusicXML example assertNotNull("Staff 2, top layer, second fermata", atoms2_top.get(16).getAtomFigures().get(0).getFermata());
            assertNotNull("Staff 2, bottom layer, first fermata", atoms2_bottom.get(9).getAtomFigures().get(0).getFermata());
            assertNotNull("Staff 2, bottom layer, second fermata", atoms2_bottom.get(19).getAtomFigures().get(0).getFermata());

        } catch (Throwable t) {
            t.printStackTrace();
            fail(t.toString());
        }*/
        return null;
    }


    @Test
    public void testGuideExample2_3() throws Exception {
        //doTest(KernImporterTest::assertGuideExample2_3, importMusicXML(TestFileUtils.getFile("/testdata/io/kern/guide02-example2-3.xml")));
        doTest(KernImporterTest::assertGuideExample2_3, importKern(TestFileUtils.getFile("/testdata/io/kern/guide02-example2-3.krn")));
    }

    // ------------------------------------------------------------------------------------------
  private static Void assertGuideExample2_4(IScore song) {
        /*try {
            assertEquals("Staves", 2, song.getStaves().size());
            Staff staff1 = song.getStaves().get(0);
            assertTrue("G2", staff1.getClefAtTime(Time.TIME_ZERO) instanceof ClefG2);
            TimeSignature ts = staff1.getTimeSignatureWithOnset(Time.TIME_ZERO);

            Staff staff2 = song.getStaves().get(1);
            assertTrue("G2", staff2.getClefAtTime(Time.TIME_ZERO) instanceof ClefG2);
            TimeSignature ts2 = staff1.getTimeSignatureWithOnset(Time.TIME_ZERO);

            Key ks = song.getUniqueKeyWithOnset(Time.TIME_ZERO);
            assertEquals(PitchClasses.C.getPitchClass(), ks.getPitchClass());

            // different layout of chords and layers in kern and MusicXML - musicXML uses chords!!!
            //TODO URGENTE - ponerlo con spines - al exportarlo debería sacar un spine
        } catch (Throwable t) {
            t.printStackTrace();
            fail(t.toString());
        }*/
        return null;
    }


    @Test
    public void testGuideExample2_4() throws Exception {
        doTest(KernImporterTest::assertGuideExample2_4, importKern(TestFileUtils.getFile("/testdata/io/kern/guide02-example2-4.krn")));
//        doTest(KernImporterTest::assertGuideExample2_4, importMusicXML(TestFileUtils.getFile("/testdata/io/kern/guide02-example2-4.xml")));
    }

    // ------------------------------------------------------------------------------------------
    private static Void assertGuideExample6_2(IScore song) {
       /* try {
            assertEquals("Staves", 2, song.getStaves().size());
            Staff staff1 = song.getStaves().get(0);
            assertTrue("G2", staff1.getClefAtTime(Time.TIME_ZERO) instanceof ClefG2);
            TimeSignature ts = staff1.getTimeSignatureWithOnset(Time.TIME_ZERO);

            Staff staff2 = song.getStaves().get(1);
            assertTrue("F4", staff2.getClefAtTime(Time.TIME_ZERO) instanceof ClefF4);
            TimeSignature ts2 = staff1.getTimeSignatureWithOnset(Time.TIME_ZERO);

            Key ks = song.getUniqueKeyWithOnset(Time.TIME_ZERO);
            assertEquals(PitchClasses.A.getPitchClass(), ks.getPitchClass());

            assertEquals("First staff layers", 1, staff1.getLayers().size());
            assertEquals("Second staff layers", 1, staff1.getLayers().size());

            assertTrue("First tuplet in staff 1", staff1.getAtoms().get(0) instanceof SimpleTuplet);

            SimpleTuplet s1ft = (SimpleTuplet) staff1.getAtoms().get(0);
            List<Atom> s1ftAtoms = s1ft.getAtoms();
            assertEquals("First tuplet s1 first atom time", Fraction.ZERO, s1ft.getAtoms().get(0).getTime().getExactTime());
            assertEquals("First tuplet s1 atom duration", Fraction.getFraction(1, 3), s1ft.getAtoms().get(0).getDuration().getExactTime());

            assertEquals("First tuplet s1 second atom time", Fraction.getFraction(1, 3), s1ft.getAtoms().get(1).getTime().getExactTime());
            assertEquals("First tuplet s1 second atom duration", Fraction.getFraction(1, 3), s1ft.getAtoms().get(1).getDuration().getExactTime());


            assertEquals("First tuplet in staff 1, #notes", 3, s1ft.getAtoms().size());
            assertEquals("Time s1, note 0", 0, staff1.getAtoms().get(0).getTime().getComputedTime(), 0.001);
            assertTrue("Second tuplet in staff 1", staff1.getAtoms().get(1) instanceof SimpleTuplet);
            //assertEquals("Time s1, note 1", 1, staff1.getAtoms().get(1).getTime().getComputedTime(), 0.001);
            assertTrue("Third note in staff 1 is note", staff1.getAtoms().get(2) instanceof SimpleNote);
            assertEquals("Time s1, note 2", 2, staff1.getAtoms().get(2).getTime().getComputedTime(), 0.001);

            SimpleTuplet s1LastStaff = (SimpleTuplet) staff1.getAtoms().get(11);
            assertEquals("s1 staff last tuplet in space of atoms", 2, s1LastStaff.getInSpaceOfAtoms());
            assertEquals("s1 staff last tuplet cardinality", 3, s1LastStaff.getCardinality());
            assertEquals("s1 staff last tuplet num. actual elements", 3, s1LastStaff.getAtoms().size());

            for (int i=0; i<3; i++) {
                assertEquals("s1 staff last tuplet, figure 8th", Figures.EIGHTH, ((SimpleNote)s1LastStaff.getAtoms().get(i)).getAtomFigure().getFigure());
            }

            // second staff
            assertTrue("Second staff, first rest", staff2.getAtoms().get(0) instanceof SimpleRest);
            assertTrue("Second staff, first harm", staff2.getAtoms().get(1) instanceof SimpleChord);
            assertEquals("Second staff, first harm, #notes", 2, staff2.getAtoms().get(1).getAtomPitches().size());
            assertTrue("Quarter, eighth tuplet in staff 2", staff2.getAtoms().get(7) instanceof SimpleTuplet);
            SimpleTuplet q8 = (SimpleTuplet) staff2.getAtoms().get(7);
            assertEquals("q8 staff last tuplet in space of atoms", 2, q8.getInSpaceOfAtoms());
            assertEquals("q8 staff last tuplet cardinality", 3, q8.getCardinality());
            assertEquals("q8 staff last tuplet num. actual elements", 2, q8.getAtoms().size());
            assertEquals("q8 figure quarter", Figures.QUARTER, ((SimpleNote)q8.getAtoms().get(0)).getAtomFigure().getFigure());
            assertEquals("q8 figure quarter", Figures.EIGHTH, ((SimpleNote)q8.getAtoms().get(1)).getAtomFigure().getFigure());

            List<Atom> q8Atoms = q8.getAtoms();
            assertEquals("First q8 first atom time", Fraction.getFraction(8, 1), q8.getAtoms().get(0).getTime().getExactTime());
            assertEquals("First q8 first atom duration", Fraction.getFraction(2, 3), q8.getAtoms().get(0).getDuration().getExactTime());

            assertEquals("First q8 second atom time", Fraction.getFraction(8, 1).add(Fraction.getFraction(2,3)), q8.getAtoms().get(1).getTime().getExactTime());
            assertEquals("First q8 second atom duration", Fraction.getFraction(1, 3), q8.getAtoms().get(1).getDuration().getExactTime());

        } catch (Throwable t) {
            t.printStackTrace();
            fail(t.toString());
        }*/
        return null;
    }


   /* TODO Tuplets @Test
    public void testGuideExample6_2() throws Exception {
        doTest(KernImporterTest::assertGuideExample6_2, importKern(TestFileUtils.getFile("/testdata/io/kern/guide06-example6-2.krn")));
        //doTest(KernImporterTest::assertGuideExample6_2, importMusicXML(TestFileUtils.getFile("/testdata/io/kern/guide06-example6-2.xml")));
    }*/

    // ------------------------------------------------------------------------------------------
   /*TODO private static Void assertChor1(IScore song) {
        /*try {
            assertTrue("Anacrusis", song.isAnacrusis());
            Key ks = song.getUniqueKeyWithOnset(Time.TIME_ZERO);
            assertEquals(PitchClasses.G.getPitchClass(), ks.getPitchClass());
            //TODO Mode

            for (Staff staff: song.getStaves()) {
                TimeSignature ts = staff.getTimeSignatureWithOnset(Time.TIME_ZERO);
                assertTrue("Fractional ts", ts instanceof FractionalTimeSignature);
                FractionalTimeSignature fts = (FractionalTimeSignature) ts;
                assertEquals("TS Numerator", 3, fts.getNumerator());
                assertEquals("TS Denominator", 4, fts.getDenominator());
                assertEquals(PitchClasses.G.getPitchClass(), ks.getPitchClass());
            }

            assertEquals("Measures", 23, song.getMeaureCount());
            ArrayList<Harm> harms = song.getOrderedHarms();
            assertNotNull("Has harmonies", harms);
            assertEquals("Number of harmonies", 56, harms.size());
            assertEquals("First harmony time", Time.TIME_ZERO, harms.get(0).getTime());

            assertEquals("First harm key", song.getUniqueKeyWithOnset(Time.TIME_ZERO), harms.get(0).getKey());
            //TODO Resto


        } catch (Throwable t) {
            t.printStackTrace();
            fail(t.toString());
        }
        return null;
    }


    @Test
    public void testChor1() throws Exception {
        testExportImport = false; //TODO export **root **harm
        doTest(KernImporterTest::assertChor1, importKern(TestFileUtils.getFile("/testdata/io/kern/chor001.krn")));
        doTest(KernImporterTest::assertChor1, importKern(TestFileUtils.getFile("/testdata/io/kern/chor001-harm-first-spine.krn")));
        doTest(KernImporterTest::assertChor1, importMEI(TestFileUtils.getFile("/testdata/io/kern/chor001.mei")));

        // test also the export / import in MEI of the harm elements
        File meiFile = TestFileUtils.getFile("/testdata/io/kern/chor001.mei");
        IScore song = new MEIImporter(coreAbstractFactory).importScore(meiFile);
        File file = TestFileUtils.createTempFile("_kern_harm.mei");
        MEIExporter exporter = new MEIExporter();
        exporter.exportScore(song, file);
        IScore importedSong = new MEIImporter(coreAbstractFactory).importScore(file);
        assertChor1(importedSong);
    }

    // ------------------------------------------------------------------------------------------
    private static Void assertChor9(IScore song, boolean assertPartsAndStaves) {
        try {
            assertTrue("Anacrusis", song.isAnacrusis());
            Key ks = song.getUniqueKeyWithOnset(Time.TIME_ZERO);
            assertEquals(PitchClasses.G.getPitchClass(), ks.getPitchClass());
            //TODO Mode

            for (Staff staff: song.getStaves()) {
                TimeSignature ts = staff.getTimeSignatureWithOnset(Time.TIME_ZERO);
                assertTrue("Common time", ts instanceof TimeSignatureCommonTime);
                assertEquals(PitchClasses.G.getPitchClass(), ks.getPitchClass());
            }

            assertEquals("Measures", 14, song.getMeaureCount());
            ArrayList<Harm> harms = song.getOrderedHarms();
            assertNotNull("Has harmonies", harms);
            assertEquals("Number of harmonies", 53, harms.size());
            assertEquals("First harmony time", Time.TIME_ZERO, harms.get(0).getTime());

            assertEquals("First harm key", song.getUniqueKeyWithOnset(Time.TIME_ZERO), harms.get(0).getKey());
            assertEquals("#1 Chord specification size", 1, harms.get(1).getChordSpecifications().size());
            assertTrue("#1 Degree class", harms.get(1).getChordSpecifications().get(0) instanceof RomanNumberChordSpecification);
            RomanNumberChordSpecification chord1 = (RomanNumberChordSpecification) harms.get(1).getChordSpecifications().get(0);
            assertEquals("#1 Degree", Degree.VI, chord1.getRoot().getDegree());
            assertEquals("#1 Degree type", DegreeType.minor, chord1.getRoot().getDegreeType());

            if (assertPartsAndStaves) {
                assertEquals("Parts", 2, song.getParts().size());
                assertTrue("One analysis part", song.getAnalysisPart() != null);
                assertEquals("Staves", 5, song.getStaves().size()); // 4 plus analysis

                assertNotNull(song.getAnalysisStaff());
                assertEquals("Analysis staff", 1, song.getAnalysisPart().getStaves().size());
                ScorePart nonAnalysisPart = null;
                if (song.getParts().get(0) == song.getAnalysisPart()) {
                    nonAnalysisPart = song.getParts().get(1);
                } else if (song.getParts().get(1) == song.getAnalysisPart()) {
                    nonAnalysisPart = song.getParts().get(0);
                } else {
                    fail("All parts are analysis parts");
                }
                assertEquals("Non analysis staves", 4, nonAnalysisPart.getStaves().size());
                assertEquals("Staff name", "sprno", nonAnalysisPart.getStaves().get(0).getName());
                assertEquals("Staff name", "alto", nonAnalysisPart.getStaves().get(1).getName());
                assertEquals("Staff name", "tenor", nonAnalysisPart.getStaves().get(2).getName());
                assertEquals("Staff name", "bass", nonAnalysisPart.getStaves().get(3).getName());
            }
            //MEISongExporter exporter = new MEISongExporter();
            //exporter.exportSong(new File("/tmp/zzz.mei"), song);

        } catch (Throwable t) {
            t.printStackTrace();
            fail(t.toString());
        }
        return null;
    }


    @Test
    public void testChor9() throws Exception {
        IScore kernSong = importKern(TestFileUtils.getFile("/testdata/io/kern/chor009.krn"));
        //doTest(KernImporterTest::assertChor9, kernSong, true);
        assertChor9(kernSong, false); // TODO: 8/4/18 Exportar root y harm -

        // test also the export / import in MEI of the harm elements
        File file = TestFileUtils.createTempFile("_kern_harm.mei");
        MEIExporter exporter = new MEIExporter();
        exporter.exportScore(kernSong, file);
        IScore importedSong = new MEIImporter(coreAbstractFactory).importScore(file);
        assertChor9(importedSong, false);
    }*/

    // ------------------------------------------------------------------------------------------
    private static Void assertSimpleSpineSplit(IScore song) {
       /* try {
            assertEquals("Staves", 1, song.getStaves().size());
            Staff staff = song.getStaves().get(0);
            assertEquals("Layers", 2, staff.getLayers().size());

            assertEquals("Atoms in top layer", 4, staff.getLayers().get(0).size());
            assertEquals("Atoms in bottom layer", 4, staff.getLayers().get(1).size());
        } catch (Throwable t) {
            t.printStackTrace();
            fail(t.toString());
        }*/
        return null;
    }


    @Test
    public void testSimpleSpineSplit() throws Exception {
        testExportImport = false;
        IScore kernSong = importKern(TestFileUtils.getFile("/testdata/io/kern/spline_split.krn"));
        doTest(KernImporterTest::assertSimpleSpineSplit, kernSong);
    }


    // ------------------------------------------------------------------------------------------
    private static Void assertSpineSplitPiston70(IScore song) {
        /*try {
            MEISongExporter exporter = new MEISongExporter();
            exporter.exportSong(new File("/tmp/piston.mei"), song);

            assertEquals("Staves", 3, song.getStaves().size()); // 2 + analysis
            ArrayList<Staff> staves = song.getNonAnalysisStaves();
            assertEquals("Non analysis staves", 2, staves.size());


            Staff topStaff = staves.get(0);
            assertEquals("Layers in top staff", 2, topStaff.getLayers().size());

            Staff bottomStaff = staves.get(1);
            assertEquals("Layers in bottom staff", 2, bottomStaff.getLayers().size());

            assertEquals("Atoms in top layer of top staff", 3, topStaff.getLayers().get(0).size());
            assertEquals("Atoms in bottom layer of top staff", 5, topStaff.getLayers().get(1).size());

            assertEquals("Atoms in top layer of bottom staff", 3, bottomStaff.getLayers().get(0).size());
            assertEquals("Atoms in bottom layer of bottom staff", 18, bottomStaff.getLayers().get(1).size());

        } catch (Throwable t) {
            t.printStackTrace();
            fail(t.toString());
        }*/
        return null;
    }


    /*TODO @Test
    public void testSpineSplitPiston70() throws Exception {
        testExportImport = false;
        IScore kernSong = importKern(TestFileUtils.getFile("/testdata/io/kern/spline_split_piston070.krn"));
        doTest(KernImporterTest::assertSpineSplitPiston70, kernSong);
    }*/

    // ------------------------------------------------------------------------------------------
    private static Void assertBase(IScore song) {
        try {
            assertEquals("Parts", 1, song.getParts().length);
            assertEquals("System elements", 1, song.getSystemElements().length);
            assertEquals("Staves", 1, song.getSystemElements()[0].listStaves().length);
            IStaff staff = song.getSystemElements()[0].listStaves()[0];
            IVoicedItem[] staffSymbols = staff.getStaffSymbols();
            assertEquals("Staff symbols", 16, staffSymbols.length);
            // the cast itself checks the expected class. The same is applied to optionals
            assertEquals("Clef line", 2, ((IClef)staffSymbols[0]).getLine().get().getValue().intValue());
            assertEquals("Clef note", EClefSigns.G, ((IClef)staffSymbols[0]).getSignType().getValue());
            assertEquals("Key signature accidentals", 1, ((IKeySignature)staffSymbols[1]).getPitchClasses().length);
            assertEquals("Key signature pitch", EDiatonicPitches.B, ((IKeySignature)staffSymbols[1]).getPitchClasses()[0].getDiatonicPitch().getValue());
            assertEquals("Key signature accidental", EAccidentalSymbols.FLAT, ((IKeySignature)staffSymbols[1]).getPitchClasses()[0].getAccidental().get().getValue());
            assertEquals("Meter numerator", 2, ((IStandardTimeSignature)staffSymbols[2]).getNumerator().getValue().intValue());
            assertEquals("Meter denominator", 2, ((IStandardTimeSignature)staffSymbols[2]).getDenominator().getValue().intValue());
            assertTrue("Barline", staffSymbols[3] instanceof IBarline);
            assertFalse("Note #1, no dots", ((INote)staffSymbols[4]).getDots().isPresent());
            assertEquals("Note #1, half note", EFigures.HALF, ((INote)staffSymbols[4]).getFigure().getValue());
            assertEquals("Note #1, d", EDiatonicPitches.D, ((INote)staffSymbols[4]).getNoteHead().getPitch().getDiatonicPitch().getValue());
            assertEquals("Note #1, d, octave 4", 4, ((INote)staffSymbols[4]).getNoteHead().getPitch().getOctave().getValue().intValue());
            assertFalse("Note #1, no accidental", ((INote)staffSymbols[4]).getNoteHead().getPitch().getAlteration().isPresent());
            //TODO Plica
            assertEquals("Note #5, c", EDiatonicPitches.C, ((INote)staffSymbols[10]).getNoteHead().getPitch().getDiatonicPitch().getValue());
            assertEquals("Note #5, accidental sharp", EAccidentalSymbols.SHARP, ((INote)staffSymbols[10]).getNoteHead().getPitch().getAlteration().get().getAccidentalSymbol().getValue());
            assertEquals("Rest, half note", EFigures.HALF, ((IRest)staffSymbols[15]).getFigure().getValue());
        } catch (Throwable t) {
            t.printStackTrace();
            fail(t.toString());
        }
        return null;
    }

    @Test
    public void testBase() throws Exception {
        testExportImport = false;
        IScore kernSong = importKern(TestFileUtils.getFile("/testdata/io/kern/base.krn"));
        doTest(KernImporterTest::assertBase, kernSong);
    }

}
