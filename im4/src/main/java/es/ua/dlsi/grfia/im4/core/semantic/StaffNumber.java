package es.ua.dlsi.grfia.im4.core.semantic;

/**
 * It just has the number of the staff where the next items should be located
 */
public class StaffNumber extends SemanticItem {
    final int number;

    public StaffNumber(int number) {
        super("*staff" + number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public StaffNumber clone() {
        return new StaffNumber(number);
    }
}
