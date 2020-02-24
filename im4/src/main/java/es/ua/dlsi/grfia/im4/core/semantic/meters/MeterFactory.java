package es.ua.dlsi.grfia.im4.core.semantic.meters;

import es.ua.dlsi.grfia.im4.core.Factory;
import es.ua.dlsi.grfia.im4.core.semantic.HeaderItem;
import es.ua.dlsi.grfia.im4.core.semantic.headers.*;
import es.ua.dlsi.grfia.im4.core.semantic.meters.mensural.*;
import es.ua.dlsi.grfia.im4.core.semantic.meters.mensural.hispanic.MeterProporcionMayor;
import es.ua.dlsi.grfia.im4.core.semantic.meters.mensural.hispanic.MeterProporcionMenor;


public class MeterFactory extends Factory<Meter> {
    private static MeterFactory instance = null;

    public static MeterFactory getInstance() {
        if (instance == null) {
            instance = new MeterFactory();
        }
        return instance;
    }

    private MeterFactory() {
        super("meter");

        map.put(MeterCommonTime.SKM, MeterCommonTime::new);
        map.put(MeterCutTime.SKM, MeterCutTime::new);

        // mensural meters
        map.put(MeterProporcionMayor.SKM, MeterProporcionMayor::new);
        map.put(MeterProporcionMenor.SKM, MeterProporcionMenor::new);
        map.put(TempusImperfectumCumProlationeImperfecta.SKM, TempusImperfectumCumProlationeImperfecta::new);
        map.put(TempusImperfectumCumProlationeImperfectaDiminutum.SKM, TempusImperfectumCumProlationeImperfectaDiminutum::new);
        map.put(TempusImperfectumCumProlationePerfecta.SKM, TempusImperfectumCumProlationePerfecta::new);
        map.put(TempusPerfectumCumProlationeImperfecta.SKM, TempusPerfectumCumProlationeImperfecta::new);
        map.put(TempusPerfectumCumProlationePerfecta.SKM, TempusPerfectumCumProlationePerfecta::new);
    }
}
