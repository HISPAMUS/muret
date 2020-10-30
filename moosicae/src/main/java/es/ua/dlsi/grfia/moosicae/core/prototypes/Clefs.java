package es.ua.dlsi.grfia.moosicae.core.prototypes;

import es.ua.dlsi.grfia.moosicae.core.IClef;
import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IOctaveTransposition;
import es.ua.dlsi.grfia.moosicae.core.enums.EClefSigns;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefLine;
import es.ua.dlsi.grfia.moosicae.core.properties.IClefSign;


/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class Clefs extends Prototypes<IClef> {
    public static String G2 = "G2";

    public static String C1 = "C1";
    public static String C2 = "C2";
    public static String C3 = "C3";
    public static String C4 = "C4";
    public static String C5 = "C5";

    public static String F3 = "F3";
    public static String F4 = "F4";
    public static String F5 = "F5";

    public static String PERCUSSION = "PERCUSSION";
    public static String TAB = "TAB";

    public static String G2_OTTAVA_BASSA = "G2_8";
    public static String G2_OTTAVA_ALTA = "G2^8";

    public static String F4_OTTAVA_BASSA = "F4_8";
    public static String F4_OTTAVA_ALTA = "F4^8";

    public static String G2_QUINDICESIMA_BASSA = "G2_15";
    public static String G2_QUINDICESIMA_ALTA = "G2^15";

    public static String F4_QUINDICESIMA_BASSA = "F4_15";
    public static String F4_QUINDICESIMA_ALTA = "F4^15";


    private IClef generateClef(EClefSigns eClefSign, int line, Integer octaveTranspositionValue) {
        IClefLine clefLine = coreAbstractFactory.createClefLine(null, line);
        IClefSign clefSign = coreAbstractFactory.createClefSign(null, eClefSign);
        IOctaveTransposition octaveTransposition = null;
        if (octaveTranspositionValue != null) {
            octaveTransposition = coreAbstractFactory.createOctaveTransposition(null, octaveTranspositionValue);
        }
        IClef clef = coreAbstractFactory.createClef(null, clefSign, clefLine, octaveTransposition);
        return clef;
    }


    private IClef generateClef(EClefSigns eClefSign, int line) {
        return generateClef(eClefSign, line, null);
    }

    private IClef generateClef(EClefSigns eClefSign) {
        IClefSign clefSign = coreAbstractFactory.createClefSign(null, eClefSign);
        IClef clef = coreAbstractFactory.createClef(null, clefSign, null, null);
        return clef;
    }

    /**
     * Instantiate it using PrototypesAbstractBuilder
     * @param coreAbstractFactory
     */
    Clefs(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);
        add(G2, generateClef(EClefSigns.G, 2));
        add(G2_OTTAVA_ALTA, generateClef(EClefSigns.G, 2, 1));
        add(G2_OTTAVA_BASSA, generateClef(EClefSigns.G, 2, -1));
        add(G2_QUINDICESIMA_ALTA, generateClef(EClefSigns.G, 2, 2));
        add(G2_QUINDICESIMA_BASSA, generateClef(EClefSigns.G, 2, -2));

        add(C1, generateClef(EClefSigns.C, 1));
        add(C2, generateClef(EClefSigns.C, 2));
        add(C3, generateClef(EClefSigns.C, 3));
        add(C4, generateClef(EClefSigns.C, 4));
        add(C5, generateClef(EClefSigns.C, 5));

        add(F3, generateClef(EClefSigns.F, 3));
        add(F4, generateClef(EClefSigns.F, 4));
        add(F4_OTTAVA_ALTA, generateClef(EClefSigns.F, 4, 1));
        add(F4_OTTAVA_BASSA, generateClef(EClefSigns.F, 4, -1));

        add(F4_QUINDICESIMA_ALTA, generateClef(EClefSigns.F, 4, -2));
        add(F4_QUINDICESIMA_BASSA, generateClef(EClefSigns.F, 4, -2));

        add(F5, generateClef(EClefSigns.F, 5));

        add(PERCUSSION, generateClef(EClefSigns.Percussion));
        add(TAB, generateClef(EClefSigns.TAB));
    }

}
