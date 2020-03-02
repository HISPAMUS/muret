package es.ua.dlsi.grfia.im4.core.notated.io.skm;

import java.util.Objects;

/**
 * Devised to be inserted into a part spine without any information about timing or any relationship between items
 * All elements that inherit SemanticItem must be immutable to make it easier the maintenance and allow for some
 * parallel operations
 */
public abstract class SkmItem {
    private final String skmEncoding;

    public SkmItem(String skmEncoding) {
        this.skmEncoding = skmEncoding;
    }

    public String getSkmEncoding() {
        return skmEncoding;
    }

    @Override
    public String toString() {
        return skmEncoding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkmItem that = (SkmItem) o;
        return skmEncoding.equals(that.skmEncoding);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skmEncoding);
    }

    public abstract SkmItem clone();
}
