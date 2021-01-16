package es.ua.dlsi.grfia.moosicae.core.impl.adt;

import es.ua.dlsi.grfia.moosicae.IMRuntimeException;
import es.ua.dlsi.grfia.moosicae.core.adt.IFraction;
import es.ua.dlsi.grfia.moosicae.core.adt.ITime;

/**
 * This is an inmutable object in order to be able to speed up the time computing as a double 
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class Time implements ITime {
	final double computedTime;
	final IFraction exactTime;
	
	public Time(IFraction exactTime) {
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

    @Override
	public double getComputedTime() {
		return computedTime;
	}

	@Override
	public IFraction getExactTime() {
		return exactTime;
	}
	
	//TODO Test unitario
	@Override
	public ITime add(ITime time) {
		if (time == null) {
			throw new IMRuntimeException("Parameter time is null");
		}
		return new Time(exactTime.add(time.getExactTime()));
	}

	//TODO Test unitario
	@Override
	public ITime substract(ITime time) {
		if (time == null) {
			throw new IMRuntimeException("Parameter time is null");
		}
		return new Time(exactTime.subtract(time.getExactTime()));
	}

	@Override
	public ITime divide(double divisor) {
		return new Time(exactTime.divideBy(new Fraction(divisor)));
	}	
	
	@Override
	public ITime multiply(double multiplier) {
		return new Time(exactTime.multiplyBy(new Fraction(multiplier)));
	}

    @Override
	public ITime multiplyBy(ITime m) {
        return new Time(this.exactTime.multiplyBy(m.getExactTime()));
    }

	@Override
	public ITime multiplyBy(IFraction fraction) {
		return new Time(this.exactTime.multiplyBy(fraction));
	}
    @Override
	public ITime divideBy(ITime d) {
        return new Time(this.exactTime.divideBy(d.getExactTime()));
    }
    @Override
	public Time divideBy(IFraction fraction) {
        return new Time(this.exactTime.divideBy(fraction));
    }
    @Override
	public ITime add(IFraction fraction) {
        return new Time(this.exactTime.add(fraction));
    }
    @Override
	public ITime substract(IFraction fraction) {
        return new Time(this.exactTime.subtract(fraction));
    }
    @Override
	public double mod(ITime d) {
	    return computedTime % d.getComputedTime();
    }

	@Override
	public int compareTo(ITime o) {
		if (o == null) {
			throw new IMRuntimeException("Parameter time is null");
		}
		return exactTime.compareTo(o.getExactTime());
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

	@Override
	public boolean computeIsZero() {
		return exactTime.getNumerator() == 0;
	}

	@Override
	public String toString() {
		return "Time [computedTime=" + computedTime + ", exactTime=" + exactTime + "]";
	}


    @Override
	public int intValue() {
	    return exactTime.intValue();
    }

    @Override
	public boolean computeIsMaxValue() {
		return exactTime.getNumerator() == Integer.MAX_VALUE;
    }

    @Override
	public boolean computeIsNegative() {
	    return exactTime.getNumerator() < 0;
    }

    @Override
	public boolean computeIsOne() {
	    return exactTime.getNumerator() == 1;
    }

}
