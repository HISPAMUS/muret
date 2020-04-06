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

    public MetersTest(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);
    }

    private IMeter generateMeter(int num, int den) {
        IMeter meter = coreAbstractFactory.createStandardTimeSignature(null,
                coreAbstractFactory.createTimeSignatureNumerator(null, num),
                coreAbstractFactory.createTimeSignatureDenominator(null, den)
        );
        return meter;
    }

    private IAdditiveMeter generateMeter(int [] nums, int den) {
        ITimeSignatureNumerator[] numerators = new ITimeSignatureNumerator[nums.length];
        for (int i=0; i<nums.length; i++) {
            numerators[i] = coreAbstractFactory.createTimeSignatureNumerator(null, nums[i]);
        }

        IAdditiveMeter compoundMeter = coreAbstractFactory.createAdditiveMeter(
                null,
                numerators,
                coreAbstractFactory.createTimeSignatureDenominator(null, den)
        );
        return compoundMeter;
    }

    private IMeter generateMeter(Fraction... fractions) {
        IMeter [] meters = new IMeter[fractions.length];
        for (int i=0; i<fractions.length; i++) {
            meters[i] = generateMeter(fractions[i].getNumerator(), fractions[i].getDenominator());
        }

        IMixedMeter mixedMeter = coreAbstractFactory.createMixedMeter(null, meters);
        return mixedMeter;
    }

    private IInterchangingMeter generateInterchanging() throws IMException {
        IMeter left = generateMeter(6, 8);
        IMeter right = generateMeter(3, 4);
        return coreAbstractFactory.createInterchangingMeter(null, left, right);
    }

    @Override
    public Map<String, IScore> generateTestScores() throws Exception {
        Map<String, IMeter> clefs = PrototypesAbstractBuilder.getInstance(coreAbstractFactory).getMeters().getMap();

        // now generate some special meters
        clefs.put("2_4p7_8", generateMeter(Fraction.getFraction(2, 4), Fraction.getFraction(7, 8)));
        clefs.put("2_4p3_8p3_16", generateMeter(Fraction.getFraction(2, 4), Fraction.getFraction(3, 8), Fraction.getFraction(3, 16)));
        clefs.put("2_4p1_8", generateMeter(Fraction.getFraction(2, 4), Fraction.getFraction(1, 8)));
        clefs.put("3_4p3_16", generateMeter(Fraction.getFraction(3, 4), Fraction.getFraction(3, 16)));
        clefs.put("M4_4p1_32", generateMeter(Fraction.getFraction(4, 4), Fraction.getFraction(1, 32)));
        clefs.put("M6_8=3_4", generateInterchanging());

        HashMap<String, IScore> result = new HashMap<>();
        clefs.forEach((name, clef) -> {
            prepareScore();
            score.add(voice, staff, clef);
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
