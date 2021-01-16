package es.ua.dlsi.grfia.moosicae.io.allcore;

import es.ua.dlsi.grfia.moosicae.core.*;

import java.util.Map;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 27/03/2020
 */
public abstract class AbstractCoreTest {
    /**
     * Name, score
     * @return
     * @throws Exception
     */
    public abstract Map<String, IScore> generateTestScores() throws Exception;

    public abstract String getName();
}
