package es.ua.dlsi.grfia.moosicae.io.allcore;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.impl.CoreAbstractFactoryImpl;
import es.ua.dlsi.grfia.moosicae.io.IExporter;
import es.ua.dlsi.grfia.moosicae.io.IImporter;
import es.ua.dlsi.grfia.moosicae.io.mon.MONExporter;
import es.ua.dlsi.grfia.moosicae.io.lilypond.LilypondExporter;
import es.ua.dlsi.grfia.moosicae.io.mei.MEIExporter;
import es.ua.dlsi.grfia.moosicae.io.mei.MEIImporter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.MusicXMLExporter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.MusicXMLImporter;
import es.ua.dlsi.grfia.moosicae.io.skm.SkmExporter;
import es.ua.dlsi.grfia.moosicae.io.skm.SkmImporter;
import es.ua.dlsi.grfia.moosicae.io.xml.XMLImporter;
import es.ua.dlsi.grfia.moosicae.utils.TestFileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * It tests the importing and exporting of all core symbols using all supported formats
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class AllCoreTestSuite {
    private static final String OUTPUT = "/tmp/allcoretests";
    private ICoreAbstractFactory abstractFactory = new CoreFactory().create();

    @Before
    public void init() {
        abstractFactory = new CoreAbstractFactoryImpl();
    }

    private void writeToFile(String contents, File file) throws IOException {
        Path path = file.toPath();
        byte[] strToBytes = contents.getBytes();
        Files.write(path, strToBytes);
    }

    private void testExportImport(String format, IScore score, IExporter exporter, IImporter importer, File outputTmp, String name, String extension, boolean writeToFile) throws IMException, IOException {
        try {
            String exported = exporter.exportScore(score);
            if (writeToFile) {
                File outputfile = new File(outputTmp, name + "." + extension);
                writeToFile(exported, outputfile);
                if (importer instanceof XMLImporter) {
                    try {
                        ((XMLImporter) importer).validate(outputfile);
                    } catch (IMException e) {
                        System.err.println("Invalid " + format + " xml file " + outputfile.getAbsolutePath());
                        throw e;
                    }
                }
            }

            IScore imported = importer.importScore(exported);

            //TODO evaluate equals - now we export it again and check they are equal
            String reexported = exporter.exportScore(imported);
            assertEquals(format, exported, reexported);
        } catch (UnsupportedOperationException e) {
            System.err.println(format + ": " + e.getMessage());
        }
    }

    private void testExportImport(String format, IScore score, IExporter exporter, IImporter importer) throws IMException, IOException {
        testExportImport(format, score, exporter, importer, null, null, null, false);
        String exported = exporter.exportScore(score);
        IScore imported = importer.importScore(exported);

        //TODO evaluate equals - now we export it again and check they are equal
        String reexported = exporter.exportScore(imported);
        assertEquals(format, exported, reexported);
    }

    public void doTest(AbstractCoreTest coreTest) throws Exception {
        File outputTmp = new File(OUTPUT, coreTest.getName()); //TODO también para windows - ver IMCore
        outputTmp.mkdirs();

        coreTest.generateTestScores().forEach((name, score) -> {
            try {
                testExportImport("MEI", score, new MEIExporter(), new MEIImporter(abstractFactory), outputTmp, name, "mei", true);
            } catch (Exception e) {
                e.printStackTrace();
                fail("MEI: " + name + ": " + e.getMessage());
            }
            try {
                testExportImport("MusicXML", score, new MusicXMLExporter(), new MusicXMLImporter(abstractFactory), outputTmp, name, "musicxml", true);
            } catch (Exception e) {
                e.printStackTrace();
                fail("MusicXML: " + name + ": " + e.getMessage());
            }
            try {
                testExportImport("SKM", score, new SkmExporter(), new SkmImporter(abstractFactory), outputTmp, name, "skm", true);
            } catch (Exception e) {
                e.printStackTrace();
                fail("SKM: " + name + ": " + e.getMessage());
            }
            try {
                LilypondExporter exporter = new LilypondExporter();
                writeToFile(exporter.exportScore(score), new File(outputTmp, name + ".ly"));
            } catch (UnsupportedOperationException e) {
                System.err.println("Lilypond: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                fail("Lilypond: " + name + ": " + e.getMessage());
            }
            try {
                MONExporter exporter = new MONExporter();
                writeToFile(exporter.exportScore(score), new File(outputTmp, name + ".json"));
            } catch (UnsupportedOperationException e) {
                System.err.println("JSON: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                fail("JSON: " + name + ": " + e.getMessage());
            }
        });
    }
    @Test
    public void allExportImportTests() throws Exception {
        System.out.println("############## GENERATING ALL CORE ITEMS TESTS TO " + OUTPUT + " #####################");
        File outputTmp = new File(OUTPUT);
        outputTmp.mkdirs();
        AbstractCoreTest [] testScoreBuilders = new AbstractCoreTest[] {
            new MinimalTest(abstractFactory),
               new ClefsTest(abstractFactory),
               new KeysTest(abstractFactory),
               new KeySignaturesTest(abstractFactory),
               new MetersTest(abstractFactory)
        };
        for (AbstractCoreTest coreTestScoreBuilder: testScoreBuilders) {
            doTest(coreTestScoreBuilder);
        }
    }

    //TODO generalizar
    @Test
    public void allImport() throws Exception {
        String [] filenames = {"meter_mixed.mei"};
        for (String filename: filenames) {
            File file = TestFileUtils.getFile("/testdata/io/mei/" + filename);
            MEIImporter meiImporter = new MEIImporter(abstractFactory);
            IScore score = meiImporter.importScore(file);
            testExportImport("MEI", score, new MEIExporter(), new MEIImporter(abstractFactory));
        }
    }
}
