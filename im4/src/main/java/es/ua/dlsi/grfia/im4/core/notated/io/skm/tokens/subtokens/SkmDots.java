package es.ua.dlsi.grfia.im4.core.notated.io.skm.tokens.subtokens;

import es.ua.dlsi.grfia.im4.core.notated.io.skm.SkmItem;

public class SkmDots extends SkmItem {
    private static String SKM = ".";

    private final int count;

    public SkmDots(int count) {
        super(buildSkmEncoding(count));
        this.count = count;
    }

    private static String buildSkmEncoding(int count) {
        if (count == 1) {
            return SKM; // faster this way
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(SKM);
            return stringBuilder.toString();
        }
    }

    public int getCount() {
        return count;
    }

    @Override
    public SkmDots clone() {
        return new SkmDots(count);
    }
}
