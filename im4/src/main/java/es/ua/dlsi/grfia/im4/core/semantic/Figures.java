package es.ua.dlsi.grfia.im4.core.semantic;

import es.ua.dlsi.grfia.im4.core.IM4Exception;
import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;
import es.ua.dlsi.grfia.im4.core.Time;
import org.apache.commons.lang3.math.Fraction;

enum Decoration {
	none, stem, stemAndFlag
}

/**
 * The figures must be mantained in descending length
 */
public enum Figures implements Comparable<Figures> {
	MAX_FIGURE (Integer.MAX_VALUE, 1, Integer.MAX_VALUE, NotationType.eModern, Decoration.none, 0), // used the same way Integer.MAX_VALUE
	QUADRUPLE_WHOLE (16,1,-1, NotationType.eModern, Decoration.none, 0),
	DOUBLE_WHOLE (8,1,0, NotationType.eModern, Decoration.none, 0),
	WHOLE (4,1,1, NotationType.eModern, Decoration.none, 0),
	HALF (2,1,2, NotationType.eModern, Decoration.stem, 0),
	QUARTER (1,1,4,NotationType.eModern, Decoration.stem, 0),
	EIGHTH (1,2,8, NotationType.eModern, Decoration.stem, 1),
	SIXTEENTH (1, 4, 16, NotationType.eModern, Decoration.stem, 2),
	THIRTY_SECOND (1, 8, 32, NotationType.eModern, Decoration.stem, 3),
	SIXTY_FOURTH (1, 16, 64,NotationType.eModern, Decoration.stem, 4),
	HUNDRED_TWENTY_EIGHTH (1, 32, 128, NotationType.eModern, Decoration.stem, 5),
	TWO_HUNDRED_FIFTY_SIX (1, 64, 256, NotationType.eModern, Decoration.stem, 6),
	/*MAXIMA (16, 1, -2, NotationType.eMensural, false, 0), //TODO Dejar con MAXIMA 32, etc...
	LONGA (8, 1, -1, NotationType.eMensural, false, 0),
	BREVE (4, 1, 0, NotationType.eMensural, false, 0),
	SEMIBREVE (2, 1, 1, NotationType.eMensural, false, 0),
	MINIM(1, 1, 2, NotationType.eMensural, false, 0),
	SEMIMINIM(1, 2, 4, NotationType.eMensural, false, 0),
	FUSA (1, 4, 8, NotationType.eMensural, false, 1),
	SEMIFUSA (1, 8, 16, NotationType.eMensural, false, 2),*/
    MAXIMA (32, 1, -2, NotationType.eMensural, Decoration.stem, 0),
    LONGA (16, 1, -1, NotationType.eMensural, Decoration.stem, 0),
    BREVE (8, 1, 0, NotationType.eMensural, Decoration.none, 0),
    SEMIBREVE (4, 1, 1, NotationType.eMensural, Decoration.none, 0),
    MINIM(2, 1, 2, NotationType.eMensural, Decoration.stemAndFlag, 0),
    SEMIMINIM(1, 1, 4, NotationType.eMensural, Decoration.stemAndFlag, 0),
    FUSA (1, 2, 8, NotationType.eMensural, Decoration.stemAndFlag, 1),
    SEMIFUSA (1, 4, 16, NotationType.eMensural, Decoration.stemAndFlag, 2),
	NO_DURATION (0,1,0, NotationType.eModern, Decoration.none, 0); // TODO: 22/9/17 Que tenga plica o no depende de la tipografía?

    static Figures [] SORTED_DESC_MENSURAL = new Figures[] {
            MAXIMA, LONGA, BREVE, SEMIBREVE, MINIM, SEMIMINIM, FUSA, SEMIFUSA
    };

    static Figures [] SORTED_DESC_MODERN = new Figures[] {
            QUADRUPLE_WHOLE, DOUBLE_WHOLE, WHOLE, HALF, QUARTER, EIGHTH, SIXTEENTH, THIRTY_SECOND, SIXTY_FOURTH, HUNDRED_TWENTY_EIGHTH, TWO_HUNDRED_FIFTY_SIX
    };

	final Time duration;
	/**
	 * Classical interpretation (the one used in denominators of meters)
	 */
    final int meterUnit;
    final NotationType notationType;

    final Decoration decoration;
    final int numFlags;
    private final Time ratio;

    Figures(int quarters, int quarterSubdivisions, int meterUnit, NotationType notationType, Decoration decoration, int flags) {
		duration = new Time(Fraction.getFraction(quarters, quarterSubdivisions));
		this.meterUnit = meterUnit;
		this.notationType = notationType;
		this.decoration = decoration;
		this.numFlags = flags;
		this.ratio = new Time(Fraction.getFraction(quarters, quarterSubdivisions));
	}

	public Time getDuration() {
		return duration;
	}

	public int getMeterUnit() {
		return meterUnit;
	}

	public final NotationType getNotationType() {
		return notationType;
	}

	public boolean usesFlag() {
		return (decoration == Decoration.stemAndFlag || decoration == Decoration.stem) && numFlags > 0;
	}
	public boolean usesStem() {
		return decoration == Decoration.stem || decoration == Decoration.stemAndFlag;
	}

	public boolean usesCombinedStemAndFlag() {
		return decoration == Decoration.stemAndFlag;
	}


	public Time getRatio() {
	    return ratio;
    }
	/**
	 * Compute the duration of the figure using dots
	 * @param dots
	 * @return
	 */
	public Time getDurationWithDots(int dots) {
		Fraction sumDurations = duration.getExactTime();
		Fraction lastDur = sumDurations;
		
		for (int i=0; i<dots; i++) {
			lastDur = lastDur.multiplyBy(Fraction.ONE_HALF);
			sumDurations = sumDurations.add(lastDur);
		}
		
		return new Time(sumDurations);
	}

	public static Figures findDuration(Time duration, NotationType notationType) throws IM4Exception {
		if (notationType == null) {
			throw new IM4Exception("Cannot search a duration if notationType is null");
		}
		for (Figures fig: Figures.values()) {
			if (fig.notationType == notationType && fig.duration.equals(duration)) {
				return fig;
			}
		}
		throw new IM4Exception("Cannot find a figure with duration " + duration + " and notation type " + notationType);
	}

	public static Figures findMeterUnit(int meterUnit, NotationType notationType) throws IM4Exception {
		for (Figures fig: Figures.values()) {
			if (fig.notationType == notationType && meterUnit == fig.meterUnit) {
				return fig;
			}
		}
		throw new IM4Exception("Cannot find a figure with meter unit " + meterUnit + " and notation type " + notationType);
	}

    public static Figures findFigureWithFlags(int flags, NotationType notationType) throws IM4Exception {
        for (Figures fig: Figures.values()) {
            if (fig.notationType == notationType && flags == fig.numFlags) {
                return fig;
            }
        }
        throw new IM4Exception("Cannot find a figure with flags " + flags + " and notation type " + notationType);
    }
	public int getNumFlags() {
		return numFlags;
	}

    public static Figures[] getFiguresSortedDesc(NotationType notationType) {
        if (notationType == NotationType.eMensural) {
            return SORTED_DESC_MENSURAL;
        } else if (notationType == NotationType.eModern) {
            return SORTED_DESC_MODERN;
        } else {
            throw new IM4RuntimeException("Unknown notation type " + notationType);
        }
    }
}
