package es.ua.dlsi.grfia.moosicae.core.prototypes;

import es.ua.dlsi.grfia.moosicae.core.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 04/04/2020
 */
public class Meters extends Prototypes<IMeter> {
    public static String M1_1 = "1/1";
    public static String M2_1 = "2/1";

    public static String M1_2 = "1/2";
    public static String M3_2 = "2/2";
    public static String CUT_TIME = "C|";
    public static String M4_2 = "4/2";

    public static String M4_3 = "4/3";

    public static String M1_4 = "1/4";
    public static String M2_4 = "2/4";
    public static String M3_4 = "3/4";
    public static String M4_4 = "4/4";
    public static String COMMON_TIME = "C";
    public static String M5_4 = "5/4";
    public static String M6_4 = "6/4";
    public static String M7_4 = "7/4";
    public static String M8_4 = "8/4";
    public static String M9_4 = "9/4";

    public static String M2_5 = "2/5";

    public static String M2_6 = "2/6";
    public static String M4_6 = "4/6";

    public static String M1_8 = "1/8";
    public static String M2_8 = "2/8";
    public static String M3_8 = "3/8";
    public static String M4_8 = "4/8";
    public static String M5_8 = "5/8";
    public static String M6_8 = "6/8";
    public static String M7_8 = "7/8";
    public static String M8_8 = "8/8";
    public static String M9_8 = "9/8";
    public static String M10_8 = "10/8";
    public static String M12_8 = "12/8";
    public static String M15_8 = "15/8";
    public static String M18_8 = "18/8";

    public static String M2_9 = "2/9";

    public static String M5_12 = "2/12";

    public static String M2_16 = "2/16";
    public static String M3_16 = "3/16";
    public static String M4_16 = "4/16";
    public static String M5_16 = "5/16";
    public static String M6_16 = "6/16";
    public static String M15_16 = "6/16";
    public static String M21_16 = "21/16";

    public static String M9_16 = "9/16";
    public static String M12_16 = "12/16";


    private IMeter generateMeter(int num, int den) {
        IMeter meter = coreAbstractFactory.createStandardTimeSignature(null,
                coreAbstractFactory.createTimeSignatureNumerator(null, num),
                coreAbstractFactory.createTimeSignatureDenominator(null, den)
        );
        return meter;
    }

    public Meters(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);

        add(M1_1, generateMeter(1, 1));
        add(M2_1, generateMeter(2, 1));

        add(M1_2, generateMeter(1, 2));
        add(M3_2, generateMeter(2, 2));
        add(CUT_TIME, coreAbstractFactory.createCutTime(null));
        add(M4_2, generateMeter(4, 2));

        add(M4_3, generateMeter(4, 3));

        add(M1_4, generateMeter(1, 4));
        add(M2_4, generateMeter(2, 4));
        add(M3_4, generateMeter(3, 4));
        add(M4_4, generateMeter(4, 4));
        add(COMMON_TIME, coreAbstractFactory.createCommonTime(null));
        add(M5_4, generateMeter(5, 4));
        add(M6_4, generateMeter(6, 4));
        add(M7_4, generateMeter(7, 4));
        add(M8_4, generateMeter(8, 4));
        add(M9_4, generateMeter(9, 4));

        add(M2_5, generateMeter(2, 5));

        add(M2_6, generateMeter(2, 6));
        add(M4_6, generateMeter(4, 6));

        add(M1_8, generateMeter(1, 8));
        add(M2_8, generateMeter(2, 8));
        add(M3_8, generateMeter(3, 8));
        add(M4_8, generateMeter(4, 8));
        add(M5_8, generateMeter(5, 8));
        add(M6_8, generateMeter(6, 8));
        add(M7_8, generateMeter(7, 8));
        add(M8_8, generateMeter(8, 8));
        add(M9_8, generateMeter(9, 8));
        add(M10_8, generateMeter(10, 8));
        add(M12_8, generateMeter(12, 8));
        add(M15_8, generateMeter(15, 8));
        add(M18_8, generateMeter(18, 8));

        add(M2_9, generateMeter(2, 9));

        add(M5_12, generateMeter(2, 12));

        add(M2_16, generateMeter(2, 16));
        add(M3_16, generateMeter(3, 16));
        add(M4_16, generateMeter(4, 16));
        add(M5_16, generateMeter(5, 16));
        add(M6_16, generateMeter(6, 16));
        add(M15_16, generateMeter(6, 16));
        add(M21_16, generateMeter(21, 16));

        add(M9_16, generateMeter(9, 16));
        add(M12_16, generateMeter(12, 16));
    }
}
