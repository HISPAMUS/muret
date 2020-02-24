package es.ua.dlsi.grfia.im4.core.semantic.meters.mensural;


import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;
import es.ua.dlsi.grfia.im4.core.semantic.Perfection;

public class MeterMensuralFactory {
    public static MeterMensuralFactory instance = null;

    public static final MeterMensuralFactory getInstance() {
        synchronized (MeterMensuralFactory.class) {
            if (instance == null) {
                instance = new MeterMensuralFactory();
            }
        }
        return instance;
    }

    public MeterMensural create(Perfection modusMaior, Perfection modusMinor, Perfection tempus, Perfection prolatio) {
        MeterMensural result;

        switch (tempus) {
            case imperfectum:
                if (prolatio == Perfection.imperfectum) {
                    result = new TempusImperfectumCumProlationeImperfecta();
                } else if (prolatio == Perfection.perfectum) {
                    result = new TempusImperfectumCumProlationePerfecta();
                } else {
                    throw new IM4RuntimeException("Invalid prolatio: " + prolatio);
                }
                break;
            case perfectum:
                if (prolatio == Perfection.imperfectum) {
                    result = new TempusPerfectumCumProlationeImperfecta();
                } else if (prolatio == Perfection.perfectum) {
                    result = new TempusPerfectumCumProlationePerfecta();
                } else {
                    throw new IM4RuntimeException("Invalid prolatio: " + prolatio);
                }
                break;
            default:
                throw new IM4RuntimeException("Invalid tempus: " + tempus);
        }

        if (modusMaior != null) {
            result.setModusMaior(modusMaior);
        }
        if (modusMinor != null) {
            result.setModusMinor(modusMinor);
        }
        return result;
    }

}
