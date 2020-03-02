package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.meters;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.SkmMeter;
import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.meters.mensural.*;
import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.meters.mensural.hispanic.SkmProporcionMayorMeter;
import es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.meters.mensural.hispanic.SkmProporcionMenorMeter;
import es.ua.dlsi.grfia.im4.utils.Factory;


public class SkmMeterFactory extends Factory<SkmMeter> {
    private static SkmMeterFactory instance = null;

    public static SkmMeterFactory getInstance() {
        if (instance == null) {
            instance = new SkmMeterFactory();
        }
        return instance;
    }

    private SkmMeterFactory() {
        super("meter");

        defaultConstructor.put(SkmMeterCommonTime.SKM, SkmMeterCommonTime::new);
        defaultConstructor.put(SkmMeterCutTime.SKM, SkmMeterCutTime::new);

        // mensural meters
        defaultConstructor.put(SkmProporcionMayorMeter.SKM, SkmProporcionMayorMeter::new);
        defaultConstructor.put(SkmProporcionMenorMeter.SKM, SkmProporcionMenorMeter::new);
        defaultConstructor.put(SkmTempusImperfectumCumProlationeImperfecta.SKM, SkmTempusImperfectumCumProlationeImperfecta::new);
        defaultConstructor.put(SkmTempusImperfectumCumProlationeImperfectaDiminutum.SKM, SkmTempusImperfectumCumProlationeImperfectaDiminutum::new);
        defaultConstructor.put(SkmTempusImperfectumCumProlationePerfecta.SKM, SkmTempusImperfectumCumProlationePerfecta::new);
        defaultConstructor.put(SkmTempusPerfectumCumProlationeImperfecta.SKM, SkmTempusPerfectumCumProlationeImperfecta::new);
        defaultConstructor.put(SkmTempusPerfectumCumProlationePerfecta.SKM, SkmTempusPerfectumCumProlationePerfecta::new);
    }
}
