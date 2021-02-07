package es.ua.dlsi.grfia.im3ws.muret.entity;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 5/2/21
 */
public interface IDelimitedWithBoundingBox {
    BoundingBox getBoundingBox();

    static int compareBoundingBoxesVertically(BoundingBox boundingBox, BoundingBox boundingBox2, int i, int i2, IDelimitedWithBoundingBox o1, IDelimitedWithBoundingBox o2) {
        if (boundingBox.getFromY() < boundingBox2.getFromY()) {
            return -1;
        } else if (boundingBox.getFromY() > boundingBox2.getFromY()) {
            return 1;
        } else {
            if (boundingBox.getFromX() < boundingBox2.getFromX()) {
                return -1;
            } else if (boundingBox.getFromX() > boundingBox2.getFromX()) {
                return 1;
            } else {
                return i - i2;
            }
        }
    }
}
