package es.ua.dlsi.grfia.moosicae.io.allcore;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.builders.INoteBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class MinimalTest extends MonodicTest {


    public MinimalTest(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);
    }

    @Override
    public Map<String, IScore> generateTestScores() throws Exception {
        generateScore();
        IClef clef = coreAbstractFactory.createClef(coreAbstractFactory.createId(), coreAbstractFactory.createClefSign(coreAbstractFactory.createId(), EClefSigns.G), coreAbstractFactory.createClefLine(coreAbstractFactory.createId(), 2));
        score.add(voice, staff, clef);
        IKey key = coreAbstractFactory.createCommonAlterationKey(coreAbstractFactory.createId(), ECommonAlterationKeys.DM);
        score.add(voice, staff, key);
        IMeter meterSymbol = coreAbstractFactory.createCommonTime(coreAbstractFactory.createId());
        score.add(voice, staff, meterSymbol);
        INote note1 = new INoteBuilder(coreAbstractFactory).build(EDiatonicPitches.F, EAccidentalSymbols.SHARP, 4, EFigures.WHOLE, 0);
        score.add(voice, staff, note1);
        HashMap<String, IScore> result = new HashMap<>();
        result.put("minimal", score);
        return result;
    }

    @Override
    public String getName() {
        return "minimal";
    }
}
