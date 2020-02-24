package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;

import java.util.Objects;

/**
 * Devised to be inserted into a part spine without any information about timinig or any relationship between items
 * All elements that inherit SemanticItem must be inmutable to make it easier the maintainance and allow for some
 * parallel operations
 */
public abstract class SemanticItem {
    /**
     * This value should only be changed within constuctor
     */
    private String skmEncoding;

    protected String facsimileElementID;

    public SemanticItem(String skmEncoding) {
        this.skmEncoding = skmEncoding;
    }

    public String getFacsimileElementID() {
        return facsimileElementID;
    }

    public void setFacsimileElementID(String facsimileElementID) {
        this.facsimileElementID = facsimileElementID;
    }

    public String getSkmEncoding() throws IM4Exception {
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
        SemanticItem that = (SemanticItem) o;
        return skmEncoding.equals(that.skmEncoding);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skmEncoding);
    }

    public abstract SemanticItem clone();

    /**
     * This value should only be changed within constuctor
     * @param skmEncoding
     */
    public void setSkmEncodingJustInConstructor(String skmEncoding) {
        this.skmEncoding = skmEncoding;
    }
}
