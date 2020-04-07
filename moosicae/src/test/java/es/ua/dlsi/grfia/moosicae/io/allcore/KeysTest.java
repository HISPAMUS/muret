package es.ua.dlsi.grfia.moosicae.io.allcore;

import es.ua.dlsi.grfia.moosicae.core.ICoreAbstractFactory;
import es.ua.dlsi.grfia.moosicae.core.IKey;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.core.prototypes.PrototypesAbstractBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class KeysTest extends MonodicTest {

    public KeysTest(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);
    }

    @Override
    public Map<String, IScore> generateTestScores() throws Exception {
        Map<String, IKey> keys = PrototypesAbstractBuilder.getInstance(coreAbstractFactory).getKeys().getMap();

        HashMap<String, IScore> result = new HashMap<>();
        keys.forEach((name, key) -> {
            prepareScore();
            addG2Clef();
            score.add(voice, staff, key);
            addSmallRest();
            result.put("key_" + name, score);
        });

        return result;
    }

    @Override
    public String getName() {
        return "keys";
    }
}
