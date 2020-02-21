package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;

/**
 * Line or space in the staff. Invariant.
 * @author drizo
 */
public class PositionInStaff implements Comparable<PositionInStaff> {
    public static final String LINE_STR = "L";
    public static final String SPACE_STR = "S";
    /**
     * 0 for bottom line, -1 for space under bottom line, 1 for space above bottom line
     */
    private final int lineSpace;

    public PositionInStaff(PositionInStaff other) {
        this.lineSpace = other.getLineSpace();
    }

    public PositionInStaff(int lineSpace) {
        this.lineSpace = lineSpace;
    }

    public int getLine() {
        return this.lineSpace / 2+1;
    }

    public int getSpace() {
        return (this.lineSpace-1) / 2+1;
    }


    public int getLineSpace() {
        return lineSpace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionInStaff that = (PositionInStaff) o;

        return lineSpace == that.lineSpace;
    }

    @Override
    public int hashCode() {
        return lineSpace;
    }

    @Override
    public String toString() {
        if (lineSpace % 2 == 0) {
            return LINE_STR + getLine();
        } else {
            return SPACE_STR + getSpace();
        }
    }

    public boolean laysOnLine() {
        return lineSpace % 2 == 0;
    }

    /**
     * @param line 1 is bottom line, 2 is the 1st line from bottom, 0 is the bottom ledger line
     * @return 0 for the bottom line, 2 for the 1st line from bottom, -1 for the bottom ledger line, etc.
     */
    public static PositionInStaff fromLine(int line) {
        return new PositionInStaff((line-1)*2);
    }

    /**
     * @param space 1 is bottom space, 2
     */
    public static PositionInStaff fromSpace(int space) {
        return new PositionInStaff((space)*2-1);
    }

    /**
     * Create a new PositionInStaff with the difference
     * @param lineSpaceDifference
     * @return
     */
    public PositionInStaff move(int lineSpaceDifference) {
        return new PositionInStaff(lineSpace + lineSpaceDifference);
    }

    public PositionInStaff getPositionBelow() {
        return move(-2);
    }

    public PositionInStaff getPositionAbove() {
        return move(2);
    }

    public static PositionInStaff parseString(String val) throws IM4Exception {
        try {
            if (val.startsWith(LINE_STR)) {
                int line = Integer.parseInt(val.substring(1));
                return fromLine(line);
            } else if (val.startsWith(SPACE_STR)) {
                int space = Integer.parseInt(val.substring(1));
                return fromSpace(space);
            } else {
                throw new IM4Exception("Cannot parse '" + val + "' as a PositionInStaff");
            }
        } catch (NumberFormatException e) {
            throw new IM4Exception("Cannot parse '" + val + "' as a PositionInStaff");
        }
    }

    /**
     * Lower values are below, and higher on the top part of the staff
     * @param position
     * @return
     */
    public int compareTo(PositionInStaff position) {
        return lineSpace - position.lineSpace;
    }
}
