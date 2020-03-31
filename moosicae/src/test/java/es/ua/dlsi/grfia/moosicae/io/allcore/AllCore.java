package es.ua.dlsi.grfia.moosicae.io.allcore;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.impl.CoreAbstractFactoryImpl;
import es.ua.dlsi.grfia.moosicae.io.IExporter;
import es.ua.dlsi.grfia.moosicae.io.IImporter;
import es.ua.dlsi.grfia.moosicae.io.lilypond.LilypondExporter;
import es.ua.dlsi.grfia.moosicae.io.mei.MEIExporter;
import es.ua.dlsi.grfia.moosicae.io.mei.MEIImporter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.MusicXMLExporter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.MusicXMLImporter;
import es.ua.dlsi.grfia.moosicae.io.skm.SkmExporter;
import es.ua.dlsi.grfia.moosicae.io.skm.SkmImporter;
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
public class AllCore {
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

    private void testExportImport(IScore score, IExporter exporter, IImporter importer, File outputTmp, String name, String extension) throws IMException, IOException {
        String exported = exporter.exportScore(score);
        File outputfile = new File(outputTmp, name + "." + extension);
        writeToFile(exported, outputfile);

        IScore imported = importer.importScore(exported);

        //TODO evaluate equals - now we export it again and check they are equal
        String reexported = exporter.exportScore(imported);
        assertEquals(exported, reexported);
    }

    public void doTest(AbstractCoreTest coreTest) throws Exception {
        File outputTmp = new File(OUTPUT, coreTest.getName()); //TODO también para windows - ver IMCore
        outputTmp.mkdirs();

        coreTest.generateTestScores().forEach((name, score) -> {
            try {
                testExportImport(score, new MEIExporter(), new MEIImporter(abstractFactory), outputTmp, name, "mei");
                testExportImport(score, new MusicXMLExporter(), new MusicXMLImporter(abstractFactory), outputTmp, name, "musicxml");
                testExportImport(score, new SkmExporter(), new SkmImporter(abstractFactory), outputTmp, name, "skm");
                LilypondExporter exporter = new LilypondExporter();
                writeToFile(exporter.exportScore(score), new File(outputTmp, name + ".ly"));
            } catch (Exception e) {
                e.printStackTrace();
                fail(name + ": " + e.getMessage());
            }
        });
    }
    @Test
    public void allTests() throws Exception {
        System.out.println("############## GENERATING ALL CORE ITEMS TESTS TO " + OUTPUT + " #####################");
        File outputTmp = new File(OUTPUT);
        outputTmp.mkdirs();
        AbstractCoreTest [] testScoreBuilders = new AbstractCoreTest[] {
            new MinimalTest(abstractFactory),
                new ClefsTest(abstractFactory),
                new KeysTest(abstractFactory)
        };
        for (AbstractCoreTest coreTestScoreBuilder: testScoreBuilders) {
            doTest(coreTestScoreBuilder);
        }
    }
}
