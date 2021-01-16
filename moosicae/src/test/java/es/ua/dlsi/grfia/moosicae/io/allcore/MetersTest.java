package es.ua.dlsi.grfia.moosicae.io.allcore;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.prototypes.PrototypesAbstractBuilder;
import org.apache.commons.lang3.math.Fraction;

import java.util.HashMap;
import java.util.Map;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class MetersTest extends MonodicTest {


    private IMeter generateMeter(int num, int den) {
        IMeter meter = ICoreAbstractFactory.getInstance().createStandardTimeSignature(null,
                ICoreAbstractFactory.getInstance().createTimeSignatureNumerator(null, num),
                ICoreAbstractFactory.getInstance().createTimeSignatureDenominator(null, den)
        );
        return meter;
    }

    private IAdditiveMeter generateMeter(int [] nums, int den) {
        ITimeSignatureNumerator[] numerators = new ITimeSignatureNumerator[nums.length];
        for (int i=0; i<nums.length; i++) {
            numerators[i] = ICoreAbstractFactory.getInstance().createTimeSignatureNumerator(null, nums[i]);
        }

        IAdditiveMeter compoundMeter = ICoreAbstractFactory.getInstance().createAdditiveMeter(
                null,
                numerators,
                ICoreAbstractFactory.getInstance().createTimeSignatureDenominator(null, den)
        );
        return compoundMeter;
    }

    private IMeter generateMeter(Fraction... fractions) {
        IMeter [] meters = new IMeter[fractions.length];
        for (int i=0; i<fractions.length; i++) {
            meters[i] = generateMeter(fractions[i].getNumerator(), fractions[i].getDenominator());
        }

        IMixedMeter mixedMeter = ICoreAbstractFactory.getInstance().createMixedMeter(null, meters);
        return mixedMeter;
    }

    private IInterchangingMeter generateInterchanging() throws IMException {
        IMeter left = generateMeter(6, 8);
        IMeter right = generateMeter(3, 4);
        return ICoreAbstractFactory.getInstance().createInterchangingMeter(null, left, right);
    }

    @Override
    public Map<String, IScore> generateTestScores() throws Exception {
        Map<String, IMeter> meters = PrototypesAbstractBuilder.getInstance().getMeters().getMap();

        // now generate some special meters
        meters.put("2_4p7_8", generateMeter(Fraction.getFraction(2, 4), Fraction.getFraction(7, 8)));
        meters.put("2_4p3_8p3_16", generateMeter(Fraction.getFraction(2, 4), Fraction.getFraction(3, 8), Fraction.getFraction(3, 16)));
        meters.put("2_4p1_8", generateMeter(Fraction.getFraction(2, 4), Fraction.getFraction(1, 8)));
        meters.put("3_4p3_16", generateMeter(Fraction.getFraction(3, 4), Fraction.getFraction(3, 16)));
        meters.put("M4_4p1_32", generateMeter(Fraction.getFraction(4, 4), Fraction.getFraction(1, 32)));
        meters.put("M6_8=3_4", generateInterchanging());

        HashMap<String, IScore> result = new HashMap<>();
        meters.forEach((name, meter) -> {
            prepareScore();
            addG2Clef();
            score.add(voice, staff, meter);
            addSmallRest();
            String validName = name.replace('/', '-');
            result.put("meter_" + validName, score);
        });


        return result;
    }

    @Override
    public String getName() {
        return "meters";
    }
}
