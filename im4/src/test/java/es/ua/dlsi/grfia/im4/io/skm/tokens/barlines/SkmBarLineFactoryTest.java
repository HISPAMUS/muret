package es.ua.dlsi.grfia.im4.io.skm.tokens.barlines;

import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.io.skm.tokens.SkmBarLine;
import org.junit.Test;

import static org.junit.Assert.*;

public class SkmBarLineFactoryTest {

    @Test
    public void create() throws IM4Exception {
        SkmBarLine skmBarLineSingle = SkmBarLineFactory.getInstance().create(SkmBarLineSingle.CHILD_SKM);
        assertTrue(skmBarLineSingle instanceof SkmBarLineSingle);
        assertTrue(SkmBarLineFactory.getInstance().create(SkmBarLineSingle.CHILD_SKM, 3) instanceof SkmBarLineSingle);

        Integer barNumber = 2;
        SkmBarLine skmBarLineDouble = SkmBarLineFactory.getInstance().create(SkmBarLineDoubleThin.CHILD_SKM, barNumber);
        assertTrue(skmBarLineDouble instanceof SkmBarLineDoubleThin);
        assertEquals("Bar number", barNumber, skmBarLineDouble.getBarNumber());
    }

}
