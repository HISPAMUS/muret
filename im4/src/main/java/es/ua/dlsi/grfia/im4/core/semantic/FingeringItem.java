package es.ua.dlsi.grfia.im4.core.semantic;

public class FingeringItem extends SemanticItem {
    private int digit;

    public FingeringItem(int digit) {
        super(Integer.toString(digit));
        this.digit = digit;
    }

    public int getDigit() {
        return digit;
    }

    @Override
    public FingeringItem clone() {
        return new FingeringItem(digit);
    }
}
