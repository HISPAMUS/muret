package es.ua.dlsi.grfia.im4.io;

import es.ua.dlsi.grfia.im4.core.IScore;
import es.ua.dlsi.grfia.im4.core.impl.Score;
import es.ua.dlsi.grfia.im4.io.mei.MEIExporter;
import es.ua.dlsi.grfia.im4.io.mei.MEIImporter;
import org.junit.Test;

import static org.junit.Assert.*;

public class IExporterTest {
    private IScore creaateScore() {
        return null;
    }

    @Test
    public void exportScore() {
        IScore score = creaateScore();
        IExporter exporter = new MEIExporter();
        String exported = exporter.exportScore(score);

        IImporter importer = new MEIImporter();
        Score imported = importer.importScore(exported);

        //TODO evaluate equals - now we export it again and check they are equal
        String reexported = exporter.exportScore(imported);
        assertEquals(exported, reexported);
    }
}
