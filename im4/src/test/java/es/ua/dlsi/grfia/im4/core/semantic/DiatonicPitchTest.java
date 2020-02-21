package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiatonicPitchTest {

    @Test
    public void testAll() throws IM4Exception {
        for (DiatonicPitch diatonicPitch: DiatonicPitch.values()) {
            assertEquals(diatonicPitch, DiatonicPitch.noteFromName(diatonicPitch.name().charAt(0)));
            assertEquals(diatonicPitch, DiatonicPitch.noteFromName(diatonicPitch.name()));
            assertEquals(diatonicPitch, DiatonicPitch.noteFromOrder(diatonicPitch.getOrder()));
        }

        assertEquals(0, DiatonicPitch.C.getSemitonesFromC());
        assertEquals(11, DiatonicPitch.B.getSemitonesFromC());
    }
}
