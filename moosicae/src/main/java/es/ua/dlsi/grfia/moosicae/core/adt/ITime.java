package es.ua.dlsi.grfia.moosicae.core.adt;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 15/1/21
 */
public interface ITime extends Comparable<ITime> {
    double getComputedTime();

    IFraction getExactTime();

    //TODO Test unitario
    ITime add(ITime ITime);

    //TODO Test unitario
    ITime substract(ITime ITime);

    ITime divide(double divisor);

    ITime multiply(double multiplier);

    ITime multiplyBy(ITime m);

    ITime multiplyBy(IFraction fraction);

    ITime divideBy(ITime d);

    ITime divideBy(IFraction fraction);

    ITime add(IFraction fraction);

    ITime substract(IFraction fraction);

    double mod(ITime d);

//TODO Test unitario
    /**
     * @param fromTime Included
     * @param toTime Not included
     * @return
     */
    default boolean isContainedIn(ITime fromTime, ITime toTime) {
        return this.compareTo(fromTime) >= 0 && this.compareTo(toTime) < 0;
    }

    boolean computeIsZero();

    @Override
    String toString();

    int intValue();

    boolean computeIsMaxValue();

    boolean computeIsNegative();

    boolean computeIsOne();

    static boolean overlaps(ITime fromITimeA, ITime toITimeA, ITime fromITimeB, ITime toITimeB) {
        return fromITimeA.compareTo(toITimeB) < 0 && fromITimeB.compareTo(toITimeA) < 0
                ||
                fromITimeB.compareTo(toITimeA) < 0 && fromITimeA.compareTo(toITimeB) < 0;
        //return (this.low <= other.high && other.low <= this.high);

    }

    static ITime max(ITime a, ITime b) {
        if (a.compareTo(b) >= 0) {
            return a;
        } else {
            return b;
        }
    }

    static ITime min(ITime a, ITime b) {
        if (a.compareTo(b) <= 0) {
            return a;
        } else {
            return b;
        }
    }

    @Override
    default int compareTo(ITime other) {
        return getExactTime().compareTo(other.getExactTime());
    }
}
