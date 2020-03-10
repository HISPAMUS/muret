package es.ua.dlsi.grfia.im4.io;

import es.ua.dlsi.grfia.im4.core.*;
import es.ua.dlsi.grfia.im4.core.impl.CoreFactoryImpl;
import es.ua.dlsi.grfia.im4.io.skm.SkmExporter;
import es.ua.dlsi.grfia.im4.io.skm.SkmImporter;
import org.junit.Test;

import static org.junit.Assert.*;

public class IExporterTest {
    private IScore creaateScore(ICoreAbstractFactory abstractFactory) {
        IScore score = abstractFactory.createScore();
        IPart part = abstractFactory.createPart(score);
        score.addPart(part);
        IVoice voice = abstractFactory.createVoice(part);
        IClef clef = abstractFactory.createClef(2, ClefSignTypes.G);
        voice.addItem(clef);
        return score;
    }

    private void testExportImport(IScore score, IExporter exporter, IImporter importer, ICoreAbstractFactory abstractFactory) throws IM4Exception {
        String exported = exporter.exportScore(score);
        IScore imported = importer.importScore(exported, abstractFactory);

        //TODO evaluate equals - now we export it again and check they are equal
        String reexported = exporter.exportScore(imported);
        assertEquals(exported, reexported);
    }

    @Test
    public void exportScore() throws IM4Exception {
        ICoreAbstractFactory abstractFactory = new CoreFactoryImpl();
        IScore score = creaateScore(abstractFactory);
        testExportImport(score, new SkmExporter(), new SkmImporter(), abstractFactory);
        //testExportImport(score, new MEIExporter(), new MEIImporter(), abstractFactory);
    }
}
