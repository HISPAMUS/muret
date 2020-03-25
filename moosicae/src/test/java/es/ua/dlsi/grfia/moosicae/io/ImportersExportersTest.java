package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.INoteBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.*;
import es.ua.dlsi.grfia.moosicae.core.impl.CoreAbstractFactoryImpl;
import es.ua.dlsi.grfia.moosicae.io.lilypond.LilypondExporter;
import es.ua.dlsi.grfia.moosicae.io.mei.MEIExporter;
import es.ua.dlsi.grfia.moosicae.io.mei.MEIImporter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.MusicXMLExporter;
import es.ua.dlsi.grfia.moosicae.io.musicxml.MusicXMLImporter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//TODO hacer un test de añadir una key signature sin key (sin modo)
public class ImportersExportersTest {
    private ICoreAbstractFactory abstractFactory;

    @Before
    public void init() {
        abstractFactory = new CoreAbstractFactoryImpl();
    }

    private IScore createScore() throws IMException {
        IScore score = abstractFactory.createScore(abstractFactory.createId());
        IPart part = abstractFactory.createPart(score, abstractFactory.createId(), abstractFactory.createName(abstractFactory.createId(), "Violin"));
        IVoice voice = abstractFactory.createVoice(part, abstractFactory.createId(), null);
        IStaff staff = abstractFactory.createStaff(score, abstractFactory.createId(), abstractFactory.createStaffLineCount(5));
        IClef clef = abstractFactory.createClef(abstractFactory.createId(), abstractFactory.createClefLine(abstractFactory.createId(), 2), abstractFactory.createClefSign(abstractFactory.createId(), EClefSigns.G));
        score.add(voice, staff, clef);
        IKey key = abstractFactory.createCommonAlterationKey(abstractFactory.createId(), ECommonAlterationKeys.DM);
        score.add(voice, staff, key);
        IMeter meterSymbol = abstractFactory.createCommonTime(abstractFactory.createId());
        score.add(voice, staff, meterSymbol);
        INote note1 = new INoteBuilder(abstractFactory).build(EDiatonicPitches.F, EAccidentalSymbols.SHARP, 4, EFigures.WHOLE, 0);
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
        /// testExportImport(score, new MEIExporter(), new MEIImporter(abstractFactory));
        //testExportImport(score, new SkmExporter(), new SkmImporter(abstractFactory));
        //testExportImport(score, new MusicXMLExporter(), new MusicXMLImporter(abstractFactory));
    }


    @Test
    public void exportLilypondScore() throws IMException {
        ICoreAbstractFactory abstractFactory = new CoreAbstractFactoryImpl();
        IScore score = createScore();
        LilypondExporter exporter = new LilypondExporter();
        System.out.println(exporter.exportScore(score));
    }
}
