package es.ua.dlsi.grfia.im4.core.semantic;

public abstract class BarLine extends SemanticItem {
    /**
     * Package visibility to be used by the factory
     */
    protected static final String BASE_SKM = "=";

    /**
     * Optional bar number
     */
    private final Integer barNumber;

    public BarLine(String skmEncoding, int barNumber) {
        super(skmEncoding);
        this.barNumber = barNumber;
    }

    public BarLine(String skmEncoding) {
        super(skmEncoding);
        this.barNumber = null;
    }

    public Integer getBarNumber() {
        return barNumber;
    }

    /**
     * To be used just by the factory - do not use by any other method
     * @param number
     */
    public void setBarNumberOnlyByFactory(int number) {
        setSkmEncodingJustInConstructor(BASE_SKM + number + getChildClassSkm());
    }

    protected abstract String getChildClassSkm();
}
