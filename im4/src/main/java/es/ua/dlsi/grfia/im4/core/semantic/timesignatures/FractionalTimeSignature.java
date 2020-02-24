package es.ua.dlsi.grfia.im4.core.semantic.timesignatures;

import es.ua.dlsi.grfia.im4.core.Time;
import es.ua.dlsi.grfia.im4.core.semantic.TimeSignature;
import org.apache.commons.lang3.math.Fraction;

//TODO HACER COMO CON LAS CLAVES, HACER ESTA ABSTRACTA Y CREAR UNA CLASE HIJA POR CADA CLAVE CONOCIDA

/**
 * //TODO Add C and C/ TODO Hacer jerarquía de objetos, compuesto, simple,
 * etc... - orientación a objetos - compases de amalgama
 *
 * Modern (vs mensural) meter
 * @author drizo
 * @date 03/06/2011
 *
 */
public abstract class FractionalTimeSignature extends TimeSignature implements Comparable<FractionalTimeSignature> {
	private static final String SLASH = "/";

	protected Fraction fraction;
	/**
	 * Cached
	 */
	private Time duration;

	/**
	 * The lesser the tempo, the most stable or strong //TODO Generalizarlo -
	 * podemos usar los �rboles m�tricos
	 */
	// protected int [] rhythmicStability;
	/**
	 * @param numerator
	 * @param denominator
	 */
	public FractionalTimeSignature(String skmEncoding, int numerator, int denominator) {
		super(skmEncoding);
		fraction = Fraction.getFraction(numerator, denominator);				
		duration = new Time(Fraction.getFraction(numerator, 1).multiplyBy(Fraction.getFraction(4, denominator)));
	}

	/**
	@Override
	public String toString() {
		return "[getNumerator()=" + getNumerator() + ", getDenominator()=" + getDenominator() + "]";
	}

	/**
	 * @return the getNumerator()
	 */
	public final int getNumerator() {
		return fraction.getNumerator();
	}

	/**
	 * @return the getDenominator()
	 */
	public final int getDenominator() {
		return fraction.getDenominator();
	}
	// TODO Javi Ver esto para compases compuestos
	// TODO Test unitario


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getDenominator();
		result = prime * result + getNumerator();
		return result;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!getClass().isAssignableFrom(obj.getClass())) { // Important to
															// allow inheritance
			return false;
		}
		FractionalTimeSignature other = (FractionalTimeSignature) obj;
		if (getDenominator() != other.getDenominator()) {
			return false;
		}
		return getNumerator() == other.getNumerator();
	}


	/**
	 * Returns true if the meter is compound (not simple)
	 *
	 * @return
	 */
	public boolean isCompound() { // TODO Javi Tests unitarios
		return (getDenominator() == 2 && getNumerator() == 6) || (getDenominator() > 2) && (getNumerator() % 3 == 0)
				&& (getDenominator() % 2 == 0) && (getNumerator() / 3 > 1);
	}

	@Override
	public Time getDuration() {
		return duration;
	}

	public int compareTo(FractionalTimeSignature other) {
		return getNumerator() * getDenominator() - other.getNumerator() * other.getDenominator();
	}	
}
