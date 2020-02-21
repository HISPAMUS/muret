package es.ua.dlsi.grfia.im4.core.semantic;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionsInStaffTest {
    @Test
    public void testAll() {
        assertEquals(1, PositionsInStaff.LINE_1.getLine());
        assertEquals(1, PositionsInStaff.SPACE_1.getSpace());
        assertEquals(PositionsInStaff.LINE_4, PositionsInStaff.LINE_3.getPositionAbove());
        assertEquals(PositionsInStaff.LINE_2, PositionsInStaff.LINE_3.getPositionBelow());
        assertEquals(PositionsInStaff.SPACE_3, PositionsInStaff.SPACE_4.getPositionBelow());
        assertEquals(PositionsInStaff.SPACE_5, PositionsInStaff.SPACE_4.getPositionAbove());

    }

}
