package es.ua.dlsi.grfia.moosicae.io;



import static org.junit.Assert.*;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.impl.ConventionalKeySignature;
import es.ua.dlsi.grfia.moosicae.io.kern.KernImporter;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernSyntaxDirectedTranslation2EKern;
import es.ua.dlsi.grfia.moosicae.io.mei.MEIImporter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.MusicXMLImporter;
import es.ua.dlsi.grfia.moosicae.utils.TestFileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.function.Function;

/**
 * @author drizo
 */
public class KernImporterTest {
    boolean testExportImport = true;

    private IScore importMusicXML(File file) throws IMException {
        MusicXMLImporter importer = new MusicXMLImporter();
        IScore song = importer.importScore(file);
        return song;
    }

    private IScore importMEI(File file) throws IMException {
        MEIImporter importer = new MEIImporter();
        IScore song = importer.importScore(file);
        return song;
    }

    private IScore importKern(File file) throws IMException {
        KernImporter importer = new KernImporter();
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
        try {
            assertEquals("Parts", 1, song.getParts().length);
            assertEquals("System elements", 1, song.getSystemElements().length);
            IStaff staff = (IStaff) song.getSystemElements()[0];
            IVoicedSingle[] staffSymbols = staff.getStaffSymbols();
            assertEquals("Staff symbols", 16, staffSymbols.length);
            // the cast itself checks the expected class. The same is applied to optionals
            assertEquals("Clef line", 2, ((IClef)staffSymbols[0]).getLine().get().getValue().intValue());
            assertEquals("Clef note", EClefSigns.G, ((IClef)staffSymbols[0]).getSignType().getValue());
            assertTrue("Conventional key signature", staffSymbols[1] instanceof ConventionalKeySignature); // internal/impl test
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
            assertEquals("Note #1, explicit stem up", EStemDirection.up, ((INote)staffSymbols[4]).getStem().get().getStemDirection().getValue());
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
    public void testGuideExample2_1() throws Exception {
        testExportImport = false;
        //doTest(KernImporterTest::assertGuideExample2_1, importMusicXML(TestFileUtils.getFile("/testdata/io/kern/guide02-example2-1.xml")));
        doTest(KernImporterTest::assertGuideExample2_1, importKern(TestFileUtils.getFile("/testdata/io/kern/guide02-example2-1.krn")));
    }

    // ------------------------------------------------------------------------------------------

    private static Void assertGuideExample2_2(IScore song) {
       try {
           assertEquals("Parts", 1, song.getParts().length);
           assertEquals("System elements", 2, song.getSystemElements().length);
           IVoicedSingle[] topStaffSymbols = ((IStaff)song.getSystemElements()[0]).getStaffSymbols();
           IVoicedSingle[] bottomStaffSymbols = ((IStaff)song.getSystemElements()[1]).getStaffSymbols();
           assertEquals("Bottom staff #elements", 16, bottomStaffSymbols.length); // take into account beam groups contain several notes
           assertEquals("Top staff #elements", 16, topStaffSymbols.length); // beam groups inside
           assertEquals("Clef line", 2, ((IClef)topStaffSymbols[0]).getLine().get().getValue().intValue());
           assertEquals("Clef note", EClefSigns.G, ((IClef)topStaffSymbols[0]).getSignType().getValue());
           assertEquals("Clef line", 4, ((IClef)bottomStaffSymbols[0]).getLine().get().getValue().intValue());
           assertEquals("Clef note", EClefSigns.F, ((IClef)bottomStaffSymbols[0]).getSignType().getValue());

           for (int i=0; i<2; i++) {
               IVoicedSingle[] staffSymbols = ((IStaff)song.getSystemElements()[i]).getStaffSymbols();
               assertTrue("Conventional key signature", staffSymbols[1] instanceof ConventionalKeySignature); // internal/impl test
               assertEquals("Key signature accidentals", 1, ((IKeySignature)staffSymbols[1]).getPitchClasses().length);
               assertEquals("Key signature pitch", EDiatonicPitches.B, ((IKeySignature)staffSymbols[1]).getPitchClasses()[0].getDiatonicPitch().getValue());
               assertEquals("Key signature accidental", EAccidentalSymbols.FLAT, ((IKeySignature)staffSymbols[1]).getPitchClasses()[0].getAccidental().get().getValue());
               assertEquals("Meter numerator", 3, ((IStandardTimeSignature)staffSymbols[2]).getNumerator().getValue().intValue());
               assertEquals("Meter denominator", 4, ((IStandardTimeSignature)staffSymbols[2]).getDenominator().getValue().intValue());
               assertTrue("Bar line", staffSymbols[3] instanceof IBarline);
           }

           assertTrue("Whole measure rest", bottomStaffSymbols[4] instanceof IWholeMeasureRest);
           assertEquals("Whole measure rest figure", EFigures.HALF, ((IWholeMeasureRest)bottomStaffSymbols[4]).getRest().getFigure().getValue());
           assertEquals("Whole measure rest #dots", 1, ((IWholeMeasureRest)bottomStaffSymbols[4]).getRest().getDots().get().getDots().length);

           IVoiced[] bvL15BeamGroup = ((IBeamGroup)bottomStaffSymbols[7]).getConnected();
           assertEquals("Bottom voice, line #15, 8GG/L starts beam with 5 notes", 5, bvL15BeamGroup.length);

           assertEquals("Bottom voice, line #15, 8GG/L, pitch", EDiatonicPitches.G, ((INote)bvL15BeamGroup[0]).getNoteHead().getPitch().getDiatonicPitch().getValue());
           assertEquals("Bottom voice, line #15, 8GG/L, octave", 2, ((INote)bvL15BeamGroup[0]).getNoteHead().getPitch().getOctave().getValue().intValue());

           IVoiced[] tvL22BeamGroup = ((IBeamGroup)topStaffSymbols[12]).getConnected();
           assertEquals("Bottom voice, line #22, 8dd\\L starts beam with 5 notes", 5, tvL22BeamGroup.length);
           assertEquals("Top voice, line #23, 8b-\\, figure", EFigures.EIGHTH, ((INote)tvL22BeamGroup[1]).getFigure().getValue());
           assertEquals("Top voice, line #23, 8b-\\, pitch", EDiatonicPitches.B, ((INote)tvL22BeamGroup[1]).getNoteHead().getPitch().getDiatonicPitch().getValue());
           assertEquals("Top voice, line #23, 8b-\\, accidental", EAccidentalSymbols.FLAT, ((INote)tvL22BeamGroup[1]).getNoteHead().getPitch().getAlteration().get().getAccidentalSymbol().getValue());
           assertEquals("Top voice, line #23, 8b-\\, explicit stem down", EStemDirection.down, ((INote)tvL22BeamGroup[1]).getStem().get().getStemDirection().getValue());
        } catch (Throwable t) {
            t.printStackTrace();
            fail(t.toString());
        }
        return null;
    }


    @Test
    public void testGuideExample2_2() throws Exception {
        //doTest(KernImporterTest::assertGuideExample2_2, importMusicXML(TestFileUtils.getFile("/testdata/io/kern/guide02-example2-2.xml")));
        doTest(KernImporterTest::assertGuideExample2_2, importKern(TestFileUtils.getFile("/testdata/io/kern/guide02-example2-2.krn")));
    }

    // ------------------------------------------------------------------------------------------

    private static Void assertGuideExample2_3(IScore song) {
       try {
           assertEquals("Parts", 4, song.getParts().length);
           // see https://github.com/humdrum-tools/verovio-humdrum-viewer/issues/293
           // In **mOOsicae** the use of filters is avoided, so two spines with the same staff number use the same staff.

           IPart sopranoPart = song.getParts()[3];
           IPart altoPart = song.getParts()[2];
           IPart tenorPart = song.getParts()[1];
           IPart bassPart = song.getParts()[0];

           assertTrue("Soprano instrument present", sopranoPart.getName().isPresent());
           assertTrue("Alto instrument present", altoPart.getName().isPresent());
           assertTrue("Tenor instrument present", tenorPart.getName().isPresent());
           assertTrue("Bass instrument present", bassPart.getName().isPresent());

           assertEquals("Soprano", "Soprano", sopranoPart.getName().get().getValue());
           assertEquals("Alto", "Alto", altoPart.getName().get().getValue());
           assertEquals("Tenor", "Tenor", tenorPart.getName().get().getValue());
           assertEquals("Bass", "Bass", bassPart.getName().get().getValue());

           assertEquals("Soprano #1 voice", 1, sopranoPart.getVoices().length);
           assertEquals("Alto #1 voice", 1, altoPart.getVoices().length);
           assertEquals("Tenor #1 voice", 1, tenorPart.getVoices().length);
           assertEquals("Bass #1 voice", 1, bassPart.getVoices().length);

           IVoice soprano = sopranoPart.getVoices()[0];
           IVoice alto = altoPart.getVoices()[0];
           IVoice tenor = tenorPart.getVoices()[0];
           IVoice bass = bassPart.getVoices()[0];

           assertEquals("Soprano voice #elements", 24, soprano.getChildren().length);
           assertEquals("Alto voice #elements", 25, alto.getChildren().length);
           assertEquals("Tenor voice #elements", 26, tenor.getChildren().length);
           assertEquals("Bass voice #elements", 29, bass.getChildren().length);

           assertEquals("System elements", 2, song.getSystemElements().length);

           assertEquals("Soprano clef line", 2, ((IClef)soprano.getChildren()[0]).getLine().get().getValue().intValue());
           assertEquals("Soprano clef note", EClefSigns.G, ((IClef)soprano.getChildren()[0]).getSignType().getValue());

           assertEquals("Tenor clef line", 4, ((IClef)tenor.getChildren()[0]).getLine().get().getValue().intValue());
           assertEquals("Tenor clef note", EClefSigns.F, ((IClef)tenor.getChildren()[0]).getSignType().getValue());

           assertEquals("Key signature accidentals", 3, ((IKeySignature)soprano.getChildren()[1]).getPitchClasses().length);
           assertEquals("Key signature first pitch", EDiatonicPitches.F, ((IKeySignature)soprano.getChildren()[1]).getPitchClasses()[0].getDiatonicPitch().getValue());
           assertEquals("Key signature first accidental", EAccidentalSymbols.SHARP, ((IKeySignature)soprano.getChildren()[1]).getPitchClasses()[0].getAccidental().get().getValue());
           assertEquals("Meter numerator", 4, ((IStandardTimeSignature)soprano.getChildren()[2]).getNumerator().getValue().intValue());
           assertEquals("Meter denominator", 4, ((IStandardTimeSignature)soprano.getChildren()[2]).getDenominator().getValue().intValue());

           assertEquals("Soprano voice, first note, 4ee\\, figure", EFigures.QUARTER, ((INote)soprano.getChildren()[3]).getFigure().getValue());
           assertEquals("Soprano voice, first note, 4ee\\, pitch", EDiatonicPitches.E, ((INote)soprano.getChildren()[3]).getNoteHead().getPitch().getDiatonicPitch().getValue());

           assertTrue("Bar line", soprano.getChildren()[4] instanceof IBarline);

          // assertEquals("Soprano voice, first note with fermata, 2ee;", ((INote)soprano.getChildren()[10]).getNoteHead());

        } catch (Throwable t) {
            t.printStackTrace();
            fail(t.toString());
        }
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
//TODO Lazy beaming        doTest(KernImporterTest::assertGuideExample2_4, importKern(TestFileUtils.getFile("/testdata/io/kern/guide02-example2-4.krn")));
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

    /**
     * It exports the given **kern file to **ekern and checks the output against the manually created **ekern file
     * @param filename
     */
    private void testEKernExport(String filename) throws IMException, IOException {
        File kern = TestFileUtils.getFile("/testdata/io/kern/" + filename + ".krn");
        File expectedEKern = TestFileUtils.getFile("/testdata/io/kern/" + filename + ".ekrn");
        File generatedEKern = TestFileUtils.createTempFile(filename + ".ekrn");
        KernSyntaxDirectedTranslation2EKern kernSyntaxDirectedTranslation2EKern = new KernSyntaxDirectedTranslation2EKern();
        kernSyntaxDirectedTranslation2EKern.translateKern(kern, generatedEKern, false);
        List<String> ekernExpectedLines = Files.readAllLines(expectedEKern.toPath());
        List<String> ekernGeneratedLines = Files.readAllLines(generatedEKern.toPath());
        assertEquals("ekern translation for " + filename + ".krn", ekernExpectedLines, ekernGeneratedLines);
    }

    @Test
    public void testEKernExport() throws IOException, IMException {
        testEKernExport("kern2ekern");
        testEKernExport("spines_lexer");
        testEKernExport("guide02-example2-1");
        testEKernExport("guide02-example2-2");
        testEKernExport("guide02-example2-3");
        testEKernExport("guide02-example2-4");
        testEKernExport("guide06-example6-1");
        testEKernExport("guide06-example6-2");
        testEKernExport("spline_split_piston070");
    }
}
