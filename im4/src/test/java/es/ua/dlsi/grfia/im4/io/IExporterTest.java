package es.ua.dlsi.grfia.im4.io;

import es.ua.dlsi.grfia.im4.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.im4.core.IScore;
import es.ua.dlsi.grfia.im4.core.impl.CoreFactoryImpl;
import es.ua.dlsi.grfia.im4.core.impl.Score;
import es.ua.dlsi.grfia.im4.io.mei.MEIExporter;
import es.ua.dlsi.grfia.im4.io.mei.MEIImporter;
import es.ua.dlsi.grfia.im4.io.skm.SkmExporter;
import es.ua.dlsi.grfia.im4.io.skm.SkmImporter;
import org.junit.Test;

import static org.junit.Assert.*;

public class IExporterTest {
    private IScore creaateScore(ICoreAbstractFactory abstractFactory) {
        abstractFactory.createClef(2, null); //TODO ---- hacer lo mismo con el importer
        return null;
    }

    private void testExportImport(IScore score, IExporter exporter, IImporter importer, ICoreAbstractFactory abstractFactory) {
        String exported = exporter.exportScore(score);
        Score imported = importer.importScore(exported, abstractFactory);

        //TODO evaluate equals - now we export it again and check they are equal
        String reexported = exporter.exportScore(imported);
        assertEquals(exported, reexported);
    }

    @Test
    public void exportScore() {
        ICoreAbstractFactory abstractFactory = new CoreFactoryImpl();
        IScore score = creaateScore(abstractFactory);
        testExportImport(score, new MEIExporter(), new MEIImporter(), abstractFactory);
        testExportImport(score, new SkmExporter(), new SkmImporter(), abstractFactory);
    }
}
