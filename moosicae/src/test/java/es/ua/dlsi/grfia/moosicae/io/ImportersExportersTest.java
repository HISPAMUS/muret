package es.ua.dlsi.grfia.moosicae.io;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import es.ua.dlsi.grfia.moosicae.core.enums.EMeterSymbols;
import es.ua.dlsi.grfia.moosicae.core.impl.CoreAbstractFactoryImpl;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.io.mei.MEIExporter;
import es.ua.dlsi.grfia.moosicae.io.mei.MEIImporter;
import es.ua.dlsi.grfia.moosicae.io.skm.SkmExporter;
import es.ua.dlsi.grfia.moosicae.io.skm.SkmImporter;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class ImportersExportersTest {
    private IScore createScore(ICoreAbstractFactory abstractFactory) {
        IScore score = abstractFactory.createScore();
        IPart part = abstractFactory.createPart(score, "default");
        IVoice voice = abstractFactory.createVoice(part);
        IClef clef = abstractFactory.createClef(2, abstractFactory.createClefSign(EClefSigns.G));
        IStaff staff = abstractFactory.createStaff(score);
        IKeySignature keySignature = abstractFactory.createKeySignature(
          new IPitchClass[] {
                  abstractFactory.createPitchClass(
                          abstractFactory.createDiatonicPitch(EDiatonicPitches.B),
                          Optional.of(
                                  abstractFactory.createAccidentalSymbol(EAccidentalSymbols.FLAT)
                          )
                  )
          }
        );
        voice.addItem(keySignature);
        staff.put(keySignature);
        IMeterSymbol meterSymbol = abstractFactory.createMeterSymbol(EMeterSymbols.commonTime);
        voice.addItem(meterSymbol);
        staff.put(meterSymbol);

        staff.put(clef);
        voice.addItem(clef);
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
        IScore score = createScore(abstractFactory);
        testExportImport(score, new SkmExporter(), new SkmImporter(abstractFactory));
       // testExportImport(score, new MEIExporter(), new MEIImporter(abstractFactory));
    }
}
