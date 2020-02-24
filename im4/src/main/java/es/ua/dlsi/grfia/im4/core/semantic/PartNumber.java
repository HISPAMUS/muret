package es.ua.dlsi.grfia.im4.core.semantic;

public class PartNumber extends SemanticItem {
    final int number;

    public PartNumber(int number) {
        super("*part" + number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public PartNumber clone() {
        return new PartNumber(number);
    }
}
