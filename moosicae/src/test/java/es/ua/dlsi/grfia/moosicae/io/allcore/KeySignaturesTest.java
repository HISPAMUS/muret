package es.ua.dlsi.grfia.moosicae.io.allcore;

import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IKey;
import es.ua.dlsi.grfia.moosicae.core.IKeySignature;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.core.builders.properties.IPitchClassBuilder;
import es.ua.dlsi.grfia.moosicae.core.enums.EAccidentalSymbols;
import es.ua.dlsi.grfia.moosicae.core.enums.EDiatonicPitches;
import es.ua.dlsi.grfia.moosicae.core.properties.IPitchClass;
import es.ua.dlsi.grfia.moosicae.core.prototypes.PrototypesAbstractBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class KeySignaturesTest extends MonodicTest {

    public KeySignaturesTest(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);
    }

    @Override
    public Map<String, IScore> generateTestScores() throws Exception {
        Map<String, IKey> keys = PrototypesAbstractBuilder.getInstance(coreAbstractFactory).getKeys().getMap();

        HashMap<String, IScore> result = new HashMap<>();
        keys.forEach((name, key) -> {
            prepareScore();
            addG2Clef();
            score.add(voice, staff, key.getKeySignature().get());
            addSmallRest();
            result.put("conventional_keysignature_" + name, score);
        });


        // not create a special key signature
        prepareScore();

        IPitchClass [] pitchClasses = {
                new IPitchClassBuilder(coreAbstractFactory).from(EDiatonicPitches.C).from(coreAbstractFactory.createAccidentalSymbol(null, EAccidentalSymbols.SHARP)).build(),
                new IPitchClassBuilder(coreAbstractFactory).from(EDiatonicPitches.G).from(coreAbstractFactory.createAccidentalSymbol(null, EAccidentalSymbols.SHARP)).build()
        };
        IKeySignature keySignature = coreAbstractFactory.createUnconventionalKeySignature(null, pitchClasses, null);
        score.add(voice, staff, keySignature);
        result.put("unconventional_keysignature_cs_gs", score);
        return result;
    }

    @Override
    public String getName() {
        return "key_signatures";
    }
}
