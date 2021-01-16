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


    @Override
    public Map<String, IScore> generateTestScores() throws Exception {
        prepareScore();
        IClef clef = ICoreAbstractFactory.getInstance().createClef(ICoreAbstractFactory.getInstance().createId(), ICoreAbstractFactory.getInstance().createClefSign(ICoreAbstractFactory.getInstance().createId(), EClefSigns.G), ICoreAbstractFactory.getInstance().createClefLine(ICoreAbstractFactory.getInstance().createId(), 2), null);
        score.add(voice, staff, clef);
        IKey key = ICoreAbstractFactory.getInstance().createConventionalKey(ICoreAbstractFactory.getInstance().createId(), EConventionalKeys.DM, null);
        score.add(voice, staff, key);
        IMeter meterSymbol = ICoreAbstractFactory.getInstance().createCommonTime(ICoreAbstractFactory.getInstance().createId());
        score.add(voice, staff, meterSymbol);
        INote note1 = new INoteBuilder().build(EDiatonicPitches.F, EAccidentalSymbols.SHARP, 4, EFigures.WHOLE, 0);
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
