package es.ua.dlsi.grfia.im4.core;

import org.apache.commons.lang3.math.Fraction;

/**
 * This is an inmutable object in order to be able to speed up the time computing as a double 
 * @author drizo
 */
public class Time implements Comparable<Time> {
	public static final Time TIME_ZERO = new Time(Fraction.ZERO);
	public static final Time TIME_MAX = new Time(Fraction.getFraction(Integer.MAX_VALUE, 1));
	
	final double computedTime;
	final Fraction exactTime;
	
	public Time(Fraction exactTime) {
		this.exactTime = exactTime.reduce();
 		computedTime = this.exactTime.doubleValue();
	}

	/**
	 * By default, zero
	 */
	public Time() {
		this.exactTime = Fraction.ZERO;
		computedTime = 0;
	}
	/**
	 * Specified as a fraction
	 * @param numerator
	 * @param denominator
	 */
	public Time(int numerator, int denominator) {
		this.exactTime = Fraction.getFraction(numerator, denominator);
		computedTime = this.exactTime.doubleValue(); 
	}

    public Time(int numerator) {
	    this(numerator, 1);
    }

    public double getComputedTime() {
		return computedTime;
	}
	public Fraction getExactTime() {
		return exactTime;
	}
	
	//TODO Test unitario
	public Time add(Time time) {
		if (time == null) {
			throw new IM4RuntimeException("Parameter time is null");
		}
		return new Time(exactTime.add(time.exactTime));
	}

	//TODO Test unitario
	public Time substract(Time time) {
		if (time == null) {
			throw new IM4RuntimeException("Parameter time is null");
		}
		return new Time(exactTime.subtract(time.exactTime));
	}
	

	public Time divide(double divisor) {
		return new Time(exactTime.divideBy(Fraction.getFraction(divisor)));
	}	
	
	public Time multiply(double multiplier) {
		return new Time(exactTime.multiplyBy(Fraction.getFraction(multiplier)));
	}

    public Time multiplyBy(Time m) {
        return new Time(this.exactTime.multiplyBy(m.exactTime));
    }

	public Time multiplyBy(Fraction fraction) {
		return new Time(this.exactTime.multiplyBy(fraction));
	}
    public Time divideBy(Time d) {
        return new Time(this.exactTime.divideBy(d.exactTime));
    }

    public Time divideBy(Fraction fraction) {
        return new Time(this.exactTime.divideBy(fraction));
    }
    public Time add(Fraction fraction) {
        return new Time(this.exactTime.add(fraction));
    }
    public Time substract(Fraction fraction) {
        return new Time(this.exactTime.subtract(fraction));
    }
    public double mod(Time d) {
	    return computedTime % d.getComputedTime();
    }


	@Override
	public int compareTo(Time o) {
		if (o == null) {
			throw new IM4RuntimeException("Parameter time is null");
		}
		return exactTime.compareTo(o.exactTime);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exactTime == null) ? 0 : exactTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (exactTime == null) {
			if (other.exactTime != null)
				return false;
		} else if (!exactTime.equals(other.exactTime))
			return false;
		return true;
	}


	public static Time max(Time a, Time b) {
		if (a.compareTo(b) >= 0) {
			return a;
		} else {
			return b;
		}
	}

	public static Time min(Time a, Time b) {
		if (a.compareTo(b) <= 0) {
			return a;
		} else {
			return b;
		}
	}

	//TODO Test unitario
	/**
	 * @param fromTime Included
	 * @param toTime Not included
	 * @return
	 */
	public boolean isContainedIn(Time fromTime, Time toTime) {
		return this.compareTo(fromTime) >= 0 && this.compareTo(toTime) < 0;
	}

	/**
	 * 
	 * @param fromTimeA
	 * @param toTimeA
	 * @param fromTimeB
	 * @param toTimeB
	 * @return
	 */
	public static boolean overlaps(Time fromTimeA, Time toTimeA, Time fromTimeB, Time toTimeB) {
		return fromTimeA.compareTo(toTimeB) < 0 && fromTimeB.compareTo(toTimeA) < 0
				||
				fromTimeB.compareTo(toTimeA) < 0 && fromTimeA.compareTo(toTimeB) < 0;
		//return (this.low <= other.high && other.low <= this.high);

	}

	public boolean isZero() {
		return exactTime.getNumerator() == 0;
	}

	@Override
	public String toString() {
		return "Time [computedTime=" + computedTime + ", exactTime=" + exactTime + "]";
	}


    public int intValue() {
	    return exactTime.intValue();
    }

    public boolean isMaxValue() {
		return exactTime.getNumerator() == Integer.MAX_VALUE;
    }

    public boolean isNegative() {
	    return exactTime.getNumerator() < 0;
    }

    public boolean isOne() {
	    return exactTime.getNumerator() == 1;
    }

}
