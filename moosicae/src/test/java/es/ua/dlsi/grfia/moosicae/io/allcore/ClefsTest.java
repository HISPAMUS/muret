package es.ua.dlsi.grfia.moosicae.io.allcore;

import es.ua.dlsi.grfia.moosicae.core.*;
import es.ua.dlsi.grfia.moosicae.core.prototypes.PrototypesAbstractBuilder;

import java.util.*;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public class ClefsTest extends MonodicTest {

    public ClefsTest(ICoreAbstractFactory coreAbstractFactory) {
        super(coreAbstractFactory);
    }

    @Override
    public Map<String, IScore> generateTestScores() throws Exception {
        Map<String, IClef> clefs = PrototypesAbstractBuilder.getInstance(coreAbstractFactory).getClefs().getMap();

        HashMap<String, IScore> result = new HashMap<>();
        clefs.forEach((name, clef) -> {
            prepareScore();
            score.add(voice, staff, clef);
            addSmallRest();
            result.put("clef_" + name, score);
        });

        return result;
    }

    @Override
    public String getName() {
        return "clefs";
    }
}
