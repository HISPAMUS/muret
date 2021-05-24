package es.ua.dlsi.grfia.moosicae.utils;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.LogManager;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 24/5/21
 */
public class LoggerLevels {
    public static final void changeLevel(Level level) {
        Arrays.stream(LogManager.getLogManager().getLogger("").getHandlers()).forEach(h -> h.setLevel(level));
    }
}
