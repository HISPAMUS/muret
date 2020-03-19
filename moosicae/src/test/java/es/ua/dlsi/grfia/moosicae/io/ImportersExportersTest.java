package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.INoteBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.impl.CoreAbstractFactoryImpl;
import es.ua.dlsi.grfia.moosicae.io.lilypond.LilypondExporter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.MusicXMLExporter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.MusicXMLImporter;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

//TODO hacer un test de añadir una key signature sin key (sin modo)
public class ImportersExportersTest {
    private ICoreAbstractFactory abstractFactory;

    @Before
    public void init() {
        abstractFactory = new CoreAbstractFactoryImpl();
    }

    private IScore createScore() throws IMException {
        IScore score = abstractFactory.createScore();
        IPart part = abstractFactory.createPart(score, "default");
        IVoice voice = abstractFactory.createVoice(part);
        IStaff staff = abstractFactory.createStaff(score);
        IClef clef = abstractFactory.createClef(2, abstractFactory.createClefSign(EClefSigns.G));
        score.add(voice, staff, clef);
        IKey key = abstractFactory.createKey(ECommonAlterationKeys.DM);
        score.add(voice, staff, key);
        IMeterSymbol meterSymbol = abstractFactory.createMeterSymbol(EMeterSymbols.commonTime);
        score.add(voice, staff, meterSymbol);
        INote note1 = new INoteBuilder(abstractFactory).build(EDiatonicPitches.F, Optional.of(EAccidentalSymbols.SHARP), 4, EFigures.WHOLE, 0);
        score.add(voice, staff, note1);
        return score;
    }

    private void testExportImport(IScore score, IExporter exporter, IImporter importer) throws IMException {
        String exported = exporter.exportScore(score);
        System.out.println("EXPORTED: ");
        System.out.println(exported);

        IScore imported = importer.importScore(exported);

        //TODO evaluate equals - now we export it again and check they are equal
        String reexported = exporter.exportScore(imported);
        assertEquals(exported, reexported);
    }

    @Test
    public void exportScore() throws IMException {
        ICoreAbstractFactory abstractFactory = new CoreAbstractFactoryImpl();
        IScore score = createScore();
        //testExportImport(score, new SkmExporter(), new SkmImporter(abstractFactory));
        //testExportImport(score, new MEIExporter(), new MEIImporter(abstractFactory));
        testExportImport(score, new MusicXMLExporter(), new MusicXMLImporter(abstractFactory));
    }


    @Test
    public void exportLilypondScore() throws IMException {
        ICoreAbstractFactory abstractFactory = new CoreAbstractFactoryImpl();
        IScore score = createScore();
        LilypondExporter exporter = new LilypondExporter();
        System.out.println(exporter.exportScore(score));
    }
}
