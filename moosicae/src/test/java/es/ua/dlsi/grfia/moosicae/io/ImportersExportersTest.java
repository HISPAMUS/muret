package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.impl.CoreAbstractFactoryImpl;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.io.mei.MEIExporter;
import es.ua.dlsi.grfia.moosicae.io.mei.MEIImporter;
import es.ua.dlsi.grfia.moosicae.io.skm.SkmExporter;
import es.ua.dlsi.grfia.moosicae.io.skm.SkmImporter;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImportersExportersTest {
    private IScore creaateScore(ICoreAbstractFactory abstractFactory) {
        IScore score = abstractFactory.createScore();
        IPart part = abstractFactory.createPart(score, "default");
        score.add(part);
        IVoice voice = abstractFactory.createVoice(part);
        IClef clef = abstractFactory.createClef(2, abstractFactory.createClefSign(EClefSigns.G));
        IStaff staff = abstractFactory.createStaff(score);
        staff.put(clef);
        voice.addItem(clef);
        return score;
    }

    private void testExportImport(IScore score, IExporter exporter, IImporter importer) throws IMException {
        String exported = exporter.exportScore(score);


        IScore imported = importer.importScore(exported);

        //TODO evaluate equals - now we export it again and check they are equal
        String reexported = exporter.exportScore(imported);
        assertEquals(exported, reexported);
    }

    @Test
    public void exportScore() throws IMException {
        ICoreAbstractFactory abstractFactory = new CoreAbstractFactoryImpl();
        IScore score = creaateScore(abstractFactory);
        testExportImport(score, new SkmExporter(), new SkmImporter(abstractFactory));
        testExportImport(score, new MEIExporter(), new MEIImporter(abstractFactory));
    }
}
