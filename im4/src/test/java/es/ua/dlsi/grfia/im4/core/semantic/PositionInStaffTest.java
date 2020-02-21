package es.ua.dlsi.grfia.im4.core.semantic;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionInStaffTest {
    @Test
    public void converionsTest() throws Exception {
        assertEquals(0, PositionInStaff.fromLine(1).getLineSpace()); // bottom line
        assertEquals(2, PositionInStaff.fromLine(2).getLineSpace());
        assertEquals(8, PositionInStaff.fromLine(5).getLineSpace()); // top line
        assertEquals(-2, PositionInStaff.fromLine(0).getLineSpace()); // bottom 1st ledger line
        assertEquals(-4, PositionInStaff.fromLine(-1).getLineSpace()); // below bottom 1st ledger line

        for (int i=-5; i<10; i++) {
            PositionInStaff pos = PositionInStaff.fromLine(i);
            assertEquals("Line " + i, pos.getLine(), i);
            assertEquals("L"+i, pos.toString());

            assertEquals("Parsed position in staff", pos, PositionInStaff.parseString(pos.toString()));
        }

        for (int i=-5; i<10; i++) {
            PositionInStaff pos = PositionInStaff.fromSpace(i);
            assertEquals("Space " + i, pos.getSpace(), i);
            assertEquals("S"+i, pos.toString());
            assertEquals("Parsed position in staff", pos, PositionInStaff.parseString(pos.toString()));
        }
    }
}
